package jpuppeteer.util;

import jpuppeteer.cdp.client.constant.input.DispatchTouchEventRequestType;
import jpuppeteer.cdp.client.entity.input.DispatchTouchEventRequest;
import jpuppeteer.cdp.client.entity.input.TouchPoint;

import java.math.BigDecimal;
import java.util.List;

public final class DispatchTouchEventRequestBuilder {
    private DispatchTouchEventRequestType type;
    private java.util.List<jpuppeteer.cdp.client.entity.input.TouchPoint> touchPoints;
    private Integer modifiers;
    private java.math.BigDecimal timestamp;

    public DispatchTouchEventRequestBuilder() {
    }

    public DispatchTouchEventRequestBuilder type(DispatchTouchEventRequestType type) {
        this.type = type;
        return this;
    }

    public DispatchTouchEventRequestBuilder touchPoints(List<TouchPoint> touchPoints) {
        this.touchPoints = touchPoints;
        return this;
    }

    public DispatchTouchEventRequestBuilder modifiers(Integer modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public DispatchTouchEventRequestBuilder timestamp(BigDecimal timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public DispatchTouchEventRequest build() {
        return new DispatchTouchEventRequest(type, touchPoints, modifiers, timestamp);
    }
}
