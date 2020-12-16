package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class DeviceOrientation {

    private jpuppeteer.cdp.CDPSession session;

    public DeviceOrientation(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Clears the overridden Device Orientation.
    */
    public io.netty.util.concurrent.Future clearDeviceOrientationOverride() {
        return session.send("DeviceOrientation.clearDeviceOrientationOverride", null);
    }


    /**
    * Overrides the Device Orientation.
    */
    public io.netty.util.concurrent.Future setDeviceOrientationOverride(jpuppeteer.cdp.client.entity.deviceorientation.SetDeviceOrientationOverrideRequest request) {
        return session.send("DeviceOrientation.setDeviceOrientationOverride", request);
    }

}