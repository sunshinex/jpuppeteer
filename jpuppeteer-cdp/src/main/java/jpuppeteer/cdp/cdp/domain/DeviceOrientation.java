package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void clearDeviceOrientationOverride(int timeout) throws Exception {
        session.send("DeviceOrientation.clearDeviceOrientationOverride", null, timeout);
    }


    /**
    * Overrides the Device Orientation.
    * experimental
    */
    public void setDeviceOrientationOverride(jpuppeteer.cdp.cdp.entity.deviceorientation.SetDeviceOrientationOverrideRequest request, int timeout) throws Exception {
        session.send("DeviceOrientation.setDeviceOrientationOverride", request, timeout);
    }

}