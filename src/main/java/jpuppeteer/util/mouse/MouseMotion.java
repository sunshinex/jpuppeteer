package jpuppeteer.util.mouse;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.entity.Point;
import jpuppeteer.util.SeriesFuture;
import jpuppeteer.util.mouse.impl.DefaultSpeedManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class MouseMotion {

    private static final Logger logger = LoggerFactory.getLogger(MouseMotion.class);
    private static final int SLEEP_AFTER_ADJUSTMENT_MS = 2;
    private final int minSteps;
    private final int effectFadeSteps;
    private final int reactionTimeBaseMs;
    private final int reactionTimeVariationMs;
    private final double timeToStepsDivider;
    private final ScreenSize screenSize;
    private final DeviationProvider deviationProvider;
    private final NoiseProvider noiseProvider;
    private final SpeedManager speedManager;
    private final OvershootManager overshootManager;
    private final int xDest;
    private final int yDest;
    private final Random random;
    private final MouseInfoAccessor mouseInfo;
    private final EventExecutor executor;
    private volatile Point mousePosition;

    public MouseMotion(MouseMotionNature nature, EventExecutor executor, Random random, int xDest, int yDest) {
        this.deviationProvider = nature.getDeviationProvider();
        this.noiseProvider = nature.getNoiseProvider();
        this.screenSize = nature.getScreenSize();
        this.xDest = limitByScreenWidth(xDest);
        this.yDest = limitByScreenHeight(yDest);
        this.random = random;
        this.mouseInfo = nature.getMouseInfo();
        this.speedManager = nature.getSpeedManager();
        this.timeToStepsDivider = nature.getTimeToStepsDivider();
        this.minSteps = nature.getMinSteps();
        this.effectFadeSteps = nature.getEffectFadeSteps();
        this.reactionTimeBaseMs = nature.getReactionTimeBaseMs();
        this.reactionTimeVariationMs = nature.getReactionTimeVariationMs();
        this.overshootManager = nature.getOvershootManager();
        this.executor = executor;
    }

    public Future move(Function<Point, Future> function) {
        updateMouseInfo();
        logger.info("Starting to move mouse to ({}, {}), current position: ({}, {})", xDest, yDest, mousePosition.x, mousePosition.y);

        MovementFactory movementFactory = new MovementFactory(xDest, yDest, speedManager, overshootManager, screenSize);
        ArrayDeque<Movement> movements = movementFactory.createMovements(mousePosition);
        int overshoots = movements.size() - 1;
        SeriesFuture next = SeriesFuture.wrap(executor.newSucceededFuture(null));
        while (mousePosition.x != xDest || mousePosition.y != yDest) {
            if (movements.isEmpty()) {
                updateMouseInfo();
                logger.warn("Re-populating movement array. Did not end up on target pixel.");
                movements = movementFactory.createMovements(mousePosition);
            }

            Movement movement = movements.removeFirst();
            if (!movements.isEmpty()) {
                logger.debug("Using overshoots ({} out of {}), aiming at ({}, {})",
                        overshoots - movements.size() + 1, overshoots, movement.destX, movement.destY);
            }

            double distance = movement.distance;
            long mouseMovementMs = movement.time;
            Flow flow = movement.flow;
            double xDistance = movement.xDistance;
            double yDistance = movement.yDistance;
            logger.debug("Movement arc length computed to {} and time predicted to {} ms", distance, mouseMovementMs);

            int steps = (int) Math.ceil(Math.min(distance, Math.max(mouseMovementMs / timeToStepsDivider, minSteps)));

            long startTime = System.currentTimeMillis();
            long stepTime = (long) (mouseMovementMs / (double) steps);

            updateMouseInfo();
            double simulatedMouseX = mousePosition.x;
            double simulatedMouseY = mousePosition.y;

            double deviationMultiplierX = (random.nextDouble() - 0.5) * 2;
            double deviationMultiplierY = (random.nextDouble() - 0.5) * 2;

            double completedXDistance = 0;
            double completedYDistance = 0;
            double noiseX = 0;
            double noiseY = 0;

            for (int i = 0; i < steps; i++) {
                double timeCompletion = i / (double) steps;

                double effectFadeStep = Math.max(i - (steps - effectFadeSteps) + 1, 0);
                double effectFadeMultiplier = (effectFadeSteps - effectFadeStep) / effectFadeSteps;

                double xStepSize = flow.getStepSize(xDistance, steps, timeCompletion);
                double yStepSize = flow.getStepSize(yDistance, steps, timeCompletion);

                completedXDistance += xStepSize;
                completedYDistance += yStepSize;
                double completedDistance = Math.hypot(completedXDistance, completedYDistance);
                double completion = Math.min(1, completedDistance / distance);
                logger.trace("Step: x: {} y: {} tc: {} c: {}", xStepSize, yStepSize, timeCompletion, completion);

                DoublePoint noise = noiseProvider.getNoise(random, xStepSize, yStepSize);
                DoublePoint deviation = deviationProvider.getDeviation(distance, completion);

                noiseX += noise.x;
                noiseY += noise.y;
                simulatedMouseX += xStepSize;
                simulatedMouseY += yStepSize;

                logger.trace("EffectFadeMultiplier: {}", effectFadeMultiplier);
                logger.trace("SimulatedMouse: [{}, {}]", simulatedMouseX, simulatedMouseY);

                long endTime = startTime + stepTime * (i + 1);
                int mousePosX = MathUtil.roundTowards(
                        simulatedMouseX +
                                deviation.x * deviationMultiplierX * effectFadeMultiplier +
                                noiseX * effectFadeMultiplier,
                        movement.destX
                );

                int mousePosY = MathUtil.roundTowards(
                        simulatedMouseY +
                                deviation.x * deviationMultiplierY * effectFadeMultiplier +
                                noiseY * effectFadeMultiplier,
                        movement.destY
                );

                mousePosX = limitByScreenWidth(mousePosX);
                mousePosY = limitByScreenHeight(mousePosY);

                next = setMousePosition(next, function, mousePosX, mousePosY)
                        .async(o -> {
                            long timeLeft = endTime - System.currentTimeMillis();
                            return sleepAround(Math.max(timeLeft, 0), 0);
                        });
            }
            updateMouseInfo();

            if (mousePosition.x != movement.destX || mousePosition.y != movement.destY) {
                logger.warn("Mouse off from step endpoint (adjustment was done) " +
                        "x: (" + mousePosition.x + " -> " + movement.destX + ") " +
                        "y: (" + mousePosition.y + " -> " + movement.destY + ") "
                );

                next = setMousePosition(next, function, movement.destX, movement.destY)
                        .async(o -> sleepAround(SLEEP_AFTER_ADJUSTMENT_MS, 0));

                updateMouseInfo();
            }

            if (mousePosition.x != xDest || mousePosition.y != yDest) {
                next = next.async(o -> sleepAround(reactionTimeBaseMs, reactionTimeVariationMs));
            }
            logger.debug("Steps completed, mouse at " + mousePosition.x + " " + mousePosition.y);
        }
        logger.info("Mouse movement to ({}, {}) completed", xDest, yDest);
        return next;
    }

    private int limitByScreenWidth(int value) {
        return Math.max(0, Math.min(screenSize.width - 1, value));
    }

    private int limitByScreenHeight(int value) {
        return Math.max(0, Math.min(screenSize.height - 1, value));
    }

    private SeriesFuture setMousePosition(SeriesFuture next, Function<Point, Future> function, int mousePosX, int mousePosY) {
        if (mouseInfo.setMousePosition(mousePosX, mousePosY)) {
            return next.async(o -> function.apply(new Point(mousePosX, mousePosY)));
        } else {
            return next;
        }
    }

    private Future sleepAround(long sleepMin, long randomPart) {
        long sleepTime = (long) (sleepMin + random.nextDouble() * randomPart);
        if (sleepTime > 0) {
            logger.trace("Sleeping at ({}, {}) for {} ms", mousePosition.x, mousePosition.y, sleepTime);
            return executor.schedule(() -> {}, sleepTime, TimeUnit.MILLISECONDS);
        } else {
            return executor.newSucceededFuture(null);
        }
    }

    private void updateMouseInfo() {
        mousePosition = mouseInfo.getMousePosition();
    }
}
