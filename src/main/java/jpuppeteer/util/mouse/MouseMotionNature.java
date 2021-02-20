package jpuppeteer.util.mouse;

import jpuppeteer.entity.Point;
import jpuppeteer.util.mouse.impl.*;

import java.util.Random;

public class MouseMotionNature {

    public static final int TIME_TO_STEPS_DIVIDER = 8;
    public static final int MIN_STEPS = 10;
    public static final int EFFECT_FADE_STEPS = 15;
    public static final int REACTION_TIME_BASE_MS = 20;
    public static final int REACTION_TIME_VARIATION_MS = 120;

    private double timeToStepsDivider;
    private int minSteps;

    private int effectFadeSteps;
    private int reactionTimeBaseMs;
    private int reactionTimeVariationMs;
    private DeviationProvider deviationProvider;
    private NoiseProvider noiseProvider;
    private OvershootManager overshootManager;
    private MouseInfoAccessor mouseInfo;
    private ScreenSize screenSize;
    private SpeedManager speedManager;

    public MouseMotionNature(ScreenSize screenSize, Point mousePosition) {
        setDeviationProvider(new DefaultDeviationProvider(DefaultDeviationProvider.DEFAULT_SLOPE_DIVIDER));
        setNoiseProvider(new DefaultNoiseProvider(DefaultNoiseProvider.DEFAULT_NOISINESS_DIVIDER));
        setSpeedManager(new DefaultSpeedManager());
        setOvershootManager(new DefaultOvershootManager(new Random()));
        setEffectFadeSteps(EFFECT_FADE_STEPS);
        setMinSteps(MIN_STEPS);
        setMouseInfo(new DefaultMouseInfoAccessor(mousePosition));
        setReactionTimeBaseMs(REACTION_TIME_BASE_MS);
        setReactionTimeVariationMs(REACTION_TIME_VARIATION_MS);
        setTimeToStepsDivider(TIME_TO_STEPS_DIVIDER);
        setScreenSize(screenSize);
    }

    public double getTimeToStepsDivider() {
        return timeToStepsDivider;
    }

    public void setTimeToStepsDivider(double timeToStepsDivider) {
        this.timeToStepsDivider = timeToStepsDivider;
    }

    public int getMinSteps() {
        return minSteps;
    }

    public void setMinSteps(int minSteps) {
        this.minSteps = minSteps;
    }

    public int getEffectFadeSteps() {
        return effectFadeSteps;
    }

    public void setEffectFadeSteps(int effectFadeSteps) {
        this.effectFadeSteps = effectFadeSteps;
    }

    public int getReactionTimeBaseMs() {
        return reactionTimeBaseMs;
    }

    public void setReactionTimeBaseMs(int reactionTimeBaseMs) {
        this.reactionTimeBaseMs = reactionTimeBaseMs;
    }

    public int getReactionTimeVariationMs() {
        return reactionTimeVariationMs;
    }

    public void setReactionTimeVariationMs(int reactionTimeVariationMs) {
        this.reactionTimeVariationMs = reactionTimeVariationMs;
    }

    public DeviationProvider getDeviationProvider() {
        return deviationProvider;
    }

    public void setDeviationProvider(DeviationProvider deviationProvider) {
        this.deviationProvider = deviationProvider;
    }

    public NoiseProvider getNoiseProvider() {
        return noiseProvider;
    }

    public void setNoiseProvider(NoiseProvider noiseProvider) {
        this.noiseProvider = noiseProvider;
    }

    public MouseInfoAccessor getMouseInfo() {
        return mouseInfo;
    }

    public void setMouseInfo(MouseInfoAccessor mouseInfo) {
        this.mouseInfo = mouseInfo;
    }

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ScreenSize screenSize) {
        this.screenSize = screenSize;
    }

    public SpeedManager getSpeedManager() {
        return speedManager;
    }

    public void setSpeedManager(SpeedManager speedManager) {
        this.speedManager = speedManager;
    }

    public OvershootManager getOvershootManager() {
        return overshootManager;
    }

    public void setOvershootManager(OvershootManager overshootManager) {
        this.overshootManager = overshootManager;
    }

}
