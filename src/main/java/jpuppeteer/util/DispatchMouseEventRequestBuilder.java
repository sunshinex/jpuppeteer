package jpuppeteer.util;

import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType;
import jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType;
import jpuppeteer.cdp.client.constant.input.MouseButton;
import jpuppeteer.cdp.client.entity.input.DispatchMouseEventRequest;

import java.math.BigDecimal;

public final class DispatchMouseEventRequestBuilder {
    private jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestType type;
    private java.math.BigDecimal x;
    private java.math.BigDecimal y;
    private Integer modifiers;
    private java.math.BigDecimal timestamp;
    private jpuppeteer.cdp.client.constant.input.MouseButton button;
    private Integer buttons;
    private Integer clickCount;
    private java.math.BigDecimal force;
    private java.math.BigDecimal tangentialPressure;
    private Integer tiltX;
    private Integer tiltY;
    private Integer twist;
    private java.math.BigDecimal deltaX;
    private java.math.BigDecimal deltaY;
    private jpuppeteer.cdp.client.constant.input.DispatchMouseEventRequestPointerType pointerType;

    public DispatchMouseEventRequestBuilder() {
    }

    public DispatchMouseEventRequestBuilder type(DispatchMouseEventRequestType type) {
        this.type = type;
        return this;
    }

    public DispatchMouseEventRequestBuilder x(BigDecimal x) {
        this.x = x;
        return this;
    }

    public DispatchMouseEventRequestBuilder y(BigDecimal y) {
        this.y = y;
        return this;
    }

    public DispatchMouseEventRequestBuilder modifiers(Integer modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public DispatchMouseEventRequestBuilder timestamp(BigDecimal timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public DispatchMouseEventRequestBuilder button(MouseButton button) {
        this.button = button;
        return this;
    }

    public DispatchMouseEventRequestBuilder buttons(Integer buttons) {
        this.buttons = buttons;
        return this;
    }

    public DispatchMouseEventRequestBuilder clickCount(Integer clickCount) {
        this.clickCount = clickCount;
        return this;
    }

    public DispatchMouseEventRequestBuilder force(BigDecimal force) {
        this.force = force;
        return this;
    }

    public DispatchMouseEventRequestBuilder tangentialPressure(BigDecimal tangentialPressure) {
        this.tangentialPressure = tangentialPressure;
        return this;
    }

    public DispatchMouseEventRequestBuilder tiltX(Integer tiltX) {
        this.tiltX = tiltX;
        return this;
    }

    public DispatchMouseEventRequestBuilder tiltY(Integer tiltY) {
        this.tiltY = tiltY;
        return this;
    }

    public DispatchMouseEventRequestBuilder twist(Integer twist) {
        this.twist = twist;
        return this;
    }

    public DispatchMouseEventRequestBuilder deltaX(BigDecimal deltaX) {
        this.deltaX = deltaX;
        return this;
    }

    public DispatchMouseEventRequestBuilder deltaY(BigDecimal deltaY) {
        this.deltaY = deltaY;
        return this;
    }

    public DispatchMouseEventRequestBuilder pointerType(DispatchMouseEventRequestPointerType pointerType) {
        this.pointerType = pointerType;
        return this;
    }

    public DispatchMouseEventRequest build() {
        return new DispatchMouseEventRequest(type, x, y, modifiers, timestamp, button, buttons, clickCount, force, tangentialPressure, tiltX, tiltY, twist, deltaX, deltaY, pointerType);
    }
}
