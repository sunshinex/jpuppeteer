package jpuppeteer.util.mouse;

import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.Page;
import jpuppeteer.entity.Point;
import jpuppeteer.util.mouse.impl.DefaultDeviationProvider;
import jpuppeteer.util.mouse.impl.DefaultNoiseProvider;
import jpuppeteer.util.mouse.impl.DefaultOvershootManager;
import jpuppeteer.util.mouse.impl.DefaultSpeedManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class MouseMotionFactory {

    private MouseMotionNature nature;
    private EventExecutor executor;
    private Random random;

    public MouseMotionFactory(MouseMotionNature nature, EventExecutor executor) {
        this.nature = nature;
        this.executor = executor;
        this.random = new Random();
    }

    public MouseMotion build(int xDest, int yDest) {
        return new MouseMotion(nature, executor, random, xDest, yDest);
    }

    public Future move(int xDest, int yDest, Function<Point, Future> function) {
        return build(xDest, yDest).move(function);
    }

    public DeviationProvider getDeviationProvider() {
        return nature.getDeviationProvider();
    }

    public void setDeviationProvider(DeviationProvider deviationProvider) {
        nature.setDeviationProvider(deviationProvider);
    }

    public NoiseProvider getNoiseProvider() {
        return nature.getNoiseProvider();
    }

    public void setNoiseProvider(NoiseProvider noiseProvider) {
        nature.setNoiseProvider(noiseProvider);
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public MouseInfoAccessor getMouseInfo() {
        return nature.getMouseInfo();
    }

    public void setMouseInfo(MouseInfoAccessor mouseInfo) {
        nature.setMouseInfo(mouseInfo);
    }

    public SpeedManager getSpeedManager() {
        return nature.getSpeedManager();
    }

    public void setSpeedManager(SpeedManager speedManager) {
        nature.setSpeedManager(speedManager);
    }

    public MouseMotionNature getNature() {
        return nature;
    }

    public void setNature(MouseMotionNature nature) {
        this.nature = nature;
    }

    public void setOvershootManager(OvershootManager manager) {
        nature.setOvershootManager(manager);
    }

    public OvershootManager getOvershootManager() {
        return nature.getOvershootManager();
    }

    public static MouseMotionFactory createGrannyMotionFactory(MouseMotionNature nature, EventExecutor executor) {
        MouseMotionFactory factory = new MouseMotionFactory(nature, executor);
        List<Flow> flows = new ArrayList<>(Arrays.asList(
                new Flow(FlowTemplates.jaggedFlow()),
                new Flow(FlowTemplates.random()),
                new Flow(FlowTemplates.interruptedFlow()),
                new Flow(FlowTemplates.interruptedFlow2()),
                new Flow(FlowTemplates.adjustingFlow()),
                new Flow(FlowTemplates.stoppingFlow())
        ));
        DefaultSpeedManager manager = new DefaultSpeedManager(flows);
        factory.setDeviationProvider(new DefaultDeviationProvider(9));
        factory.setNoiseProvider(new DefaultNoiseProvider(1.6));
        factory.getNature().setReactionTimeBaseMs(100);

        DefaultOvershootManager overshootManager = (DefaultOvershootManager) factory.getOvershootManager();
        overshootManager.setOvershoots(3);
        overshootManager.setMinDistanceForOvershoots(3);
        overshootManager.setMinOvershootMovementMs(400);
        overshootManager.setOvershootRandomModifierDivider(DefaultOvershootManager.OVERSHOOT_RANDOM_MODIFIER_DIVIDER / 2);
        overshootManager.setOvershootSpeedupDivider(DefaultOvershootManager.OVERSHOOT_SPEEDUP_DIVIDER * 2);

        factory.getNature().setTimeToStepsDivider(MouseMotionNature.TIME_TO_STEPS_DIVIDER - 2);
        manager.setMouseMovementBaseTimeMs(1000);
        factory.setSpeedManager(manager);
        return factory;
    }

    public static MouseMotionFactory createFastGamerMotionFactory(MouseMotionNature nature, EventExecutor executor) {
        MouseMotionFactory factory = new MouseMotionFactory(nature, executor);
        List<Flow> flows = new ArrayList<>(Arrays.asList(
                new Flow(FlowTemplates.variatingFlow()),
                new Flow(FlowTemplates.slowStartupFlow()),
                new Flow(FlowTemplates.slowStartup2Flow()),
                new Flow(FlowTemplates.adjustingFlow()),
                new Flow(FlowTemplates.jaggedFlow())
        ));
        DefaultSpeedManager manager = new DefaultSpeedManager(flows);
        factory.setDeviationProvider(new DefaultDeviationProvider(DefaultDeviationProvider.DEFAULT_SLOPE_DIVIDER));
        factory.setNoiseProvider(new DefaultNoiseProvider(DefaultNoiseProvider.DEFAULT_NOISINESS_DIVIDER));
        factory.getNature().setReactionTimeVariationMs(100);
        manager.setMouseMovementBaseTimeMs(250);

        DefaultOvershootManager overshootManager = (DefaultOvershootManager) factory.getOvershootManager();
        overshootManager.setOvershoots(4);

        factory.setSpeedManager(manager);
        return factory;
    }

    public static MouseMotionFactory createAverageComputerUserMotionFactory(MouseMotionNature nature, EventExecutor executor) {
        MouseMotionFactory factory = new MouseMotionFactory(nature, executor);
        List<Flow> flows = new ArrayList<>(Arrays.asList(
                new Flow(FlowTemplates.variatingFlow()),
                new Flow(FlowTemplates.interruptedFlow()),
                new Flow(FlowTemplates.interruptedFlow2()),
                new Flow(FlowTemplates.slowStartupFlow()),
                new Flow(FlowTemplates.slowStartup2Flow()),
                new Flow(FlowTemplates.adjustingFlow()),
                new Flow(FlowTemplates.jaggedFlow()),
                new Flow(FlowTemplates.stoppingFlow())
        ));
        DefaultSpeedManager manager = new DefaultSpeedManager(flows);
        factory.setDeviationProvider(new DefaultDeviationProvider(DefaultDeviationProvider.DEFAULT_SLOPE_DIVIDER));
        factory.setNoiseProvider(new DefaultNoiseProvider(DefaultNoiseProvider.DEFAULT_NOISINESS_DIVIDER));
        factory.getNature().setReactionTimeVariationMs(110);
        manager.setMouseMovementBaseTimeMs(100);

        DefaultOvershootManager overshootManager = (DefaultOvershootManager) factory.getOvershootManager();
        overshootManager.setOvershoots(4);

        factory.setSpeedManager(manager);

        return factory;
    }
}
