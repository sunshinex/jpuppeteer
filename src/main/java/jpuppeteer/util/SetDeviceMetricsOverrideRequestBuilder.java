package jpuppeteer.util;

import jpuppeteer.cdp.client.entity.emulation.DisplayFeature;
import jpuppeteer.cdp.client.entity.emulation.ScreenOrientation;
import jpuppeteer.cdp.client.entity.emulation.SetDeviceMetricsOverrideRequest;
import jpuppeteer.cdp.client.entity.page.Viewport;

import java.math.BigDecimal;

public final class SetDeviceMetricsOverrideRequestBuilder {
    private Integer width;
    private Integer height;
    private java.math.BigDecimal deviceScaleFactor;
    private Boolean mobile;
    private java.math.BigDecimal scale;
    private Integer screenWidth;
    private Integer screenHeight;
    private Integer positionX;
    private Integer positionY;
    private Boolean dontSetVisibleSize;
    private jpuppeteer.cdp.client.entity.emulation.ScreenOrientation screenOrientation;
    private jpuppeteer.cdp.client.entity.page.Viewport viewport;
    private jpuppeteer.cdp.client.entity.emulation.DisplayFeature displayFeature;

    private SetDeviceMetricsOverrideRequestBuilder() {
    }

    public static SetDeviceMetricsOverrideRequestBuilder newBuilder() {
        return new SetDeviceMetricsOverrideRequestBuilder();
    }

    public SetDeviceMetricsOverrideRequestBuilder width(Integer width) {
        this.width = width;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder height(Integer height) {
        this.height = height;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder deviceScaleFactor(BigDecimal deviceScaleFactor) {
        this.deviceScaleFactor = deviceScaleFactor;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder mobile(Boolean mobile) {
        this.mobile = mobile;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder scale(BigDecimal scale) {
        this.scale = scale;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder screenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder screenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder positionX(Integer positionX) {
        this.positionX = positionX;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder positionY(Integer positionY) {
        this.positionY = positionY;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder dontSetVisibleSize(Boolean dontSetVisibleSize) {
        this.dontSetVisibleSize = dontSetVisibleSize;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder screenOrientation(ScreenOrientation screenOrientation) {
        this.screenOrientation = screenOrientation;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder viewport(Viewport viewport) {
        this.viewport = viewport;
        return this;
    }

    public SetDeviceMetricsOverrideRequestBuilder displayFeature(DisplayFeature displayFeature) {
        this.displayFeature = displayFeature;
        return this;
    }

    public SetDeviceMetricsOverrideRequest build() {
        return new SetDeviceMetricsOverrideRequest(width, height, deviceScaleFactor, mobile, scale, screenWidth, screenHeight, positionX, positionY, dontSetVisibleSize, screenOrientation, viewport, displayFeature);
    }
}
