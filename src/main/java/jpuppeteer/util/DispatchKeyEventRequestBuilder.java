package jpuppeteer.util;

import jpuppeteer.cdp.client.constant.input.DispatchKeyEventRequestType;
import jpuppeteer.cdp.client.entity.input.DispatchKeyEventRequest;

import java.math.BigDecimal;

public final class DispatchKeyEventRequestBuilder {
    private DispatchKeyEventRequestType type;
    private Integer modifiers;
    private java.math.BigDecimal timestamp;
    private String text;
    private String unmodifiedText;
    private String keyIdentifier;
    private String code;
    private String key;
    private Integer windowsVirtualKeyCode;
    private Integer nativeVirtualKeyCode;
    private Boolean autoRepeat;
    private Boolean isKeypad;
    private Boolean isSystemKey;
    private Integer location;

    public DispatchKeyEventRequestBuilder() {
    }

    public DispatchKeyEventRequestBuilder type(DispatchKeyEventRequestType type) {
        this.type = type;
        return this;
    }

    public DispatchKeyEventRequestBuilder modifiers(Integer modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public DispatchKeyEventRequestBuilder timestamp(BigDecimal timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public DispatchKeyEventRequestBuilder text(String text) {
        this.text = text;
        return this;
    }

    public DispatchKeyEventRequestBuilder unmodifiedText(String unmodifiedText) {
        this.unmodifiedText = unmodifiedText;
        return this;
    }

    public DispatchKeyEventRequestBuilder keyIdentifier(String keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
        return this;
    }

    public DispatchKeyEventRequestBuilder code(String code) {
        this.code = code;
        return this;
    }

    public DispatchKeyEventRequestBuilder key(String key) {
        this.key = key;
        return this;
    }

    public DispatchKeyEventRequestBuilder windowsVirtualKeyCode(Integer windowsVirtualKeyCode) {
        this.windowsVirtualKeyCode = windowsVirtualKeyCode;
        return this;
    }

    public DispatchKeyEventRequestBuilder nativeVirtualKeyCode(Integer nativeVirtualKeyCode) {
        this.nativeVirtualKeyCode = nativeVirtualKeyCode;
        return this;
    }

    public DispatchKeyEventRequestBuilder autoRepeat(Boolean autoRepeat) {
        this.autoRepeat = autoRepeat;
        return this;
    }

    public DispatchKeyEventRequestBuilder isKeypad(Boolean isKeypad) {
        this.isKeypad = isKeypad;
        return this;
    }

    public DispatchKeyEventRequestBuilder isSystemKey(Boolean isSystemKey) {
        this.isSystemKey = isSystemKey;
        return this;
    }

    public DispatchKeyEventRequestBuilder location(Integer location) {
        this.location = location;
        return this;
    }

    public DispatchKeyEventRequest build() {
        return new DispatchKeyEventRequest(type, modifiers, timestamp, text, unmodifiedText, keyIdentifier, code, key, windowsVirtualKeyCode, nativeVirtualKeyCode, autoRepeat, isKeypad, isSystemKey, location);
    }
}
