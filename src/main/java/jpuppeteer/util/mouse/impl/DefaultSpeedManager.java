package jpuppeteer.util.mouse.impl;

import jpuppeteer.util.mouse.Flow;
import jpuppeteer.util.mouse.FlowTemplates;
import jpuppeteer.util.mouse.Pair;
import jpuppeteer.util.mouse.SpeedManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DefaultSpeedManager implements SpeedManager {
    private static final double SMALL_DELTA = 10e-6;
    private final List<Flow> flows = new ArrayList<>();
    private long mouseMovementTimeMs = 500;

    public DefaultSpeedManager(Collection<Flow> flows) {
        this.flows.addAll(flows);
    }

    public DefaultSpeedManager() {
        this(Arrays.asList(
                new Flow(FlowTemplates.constantSpeed()),
                new Flow(FlowTemplates.variatingFlow()),
                new Flow(FlowTemplates.interruptedFlow()),
                new Flow(FlowTemplates.interruptedFlow2()),
                new Flow(FlowTemplates.slowStartupFlow()),
                new Flow(FlowTemplates.slowStartup2Flow()),
                new Flow(FlowTemplates.adjustingFlow()),
                new Flow(FlowTemplates.jaggedFlow()),
                new Flow(FlowTemplates.stoppingFlow())
        ));
    }

    @Override
    public Pair<Flow, Long> getFlowWithTime(double distance) {
        double time = mouseMovementTimeMs + (long)(Math.random() * mouseMovementTimeMs);
        Flow flow = flows.get((int) (Math.random() * flows.size()));

        double timePerBucket = time / (double)flow.getFlowCharacteristics().length;
        for (double bucket : flow.getFlowCharacteristics()) {
            if (Math.abs(bucket - 0) < SMALL_DELTA) {
                time += timePerBucket;
            }
        }

        return new Pair<>(flow, (long)time);
    }

    public void setMouseMovementBaseTimeMs(long mouseMovementSpeedMs) {
        this.mouseMovementTimeMs = mouseMovementSpeedMs;
    }
}
