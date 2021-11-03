package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class DeviceOrientation {

    private jpuppeteer.cdp.CDPConnection connection;

    public DeviceOrientation(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Clears the overridden Device Orientation.
    */
    public io.netty.util.concurrent.Future clearDeviceOrientationOverride() {
        return connection.send("DeviceOrientation.clearDeviceOrientationOverride", null);
    }


    /**
    * Overrides the Device Orientation.
    */
    public io.netty.util.concurrent.Future setDeviceOrientationOverride(jpuppeteer.cdp.client.entity.deviceorientation.SetDeviceOrientationOverrideRequest request) {
        return connection.send("DeviceOrientation.setDeviceOrientationOverride", request);
    }

}