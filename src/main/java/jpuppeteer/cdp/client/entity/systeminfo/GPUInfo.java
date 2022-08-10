package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Provides information about the GPU(s) on the system.
* experimental
*/
public class GPUInfo {

    /**
    * The graphics devices on the system. Element 0 is the primary GPU.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.systeminfo.GPUDevice> devices;

    /**
    * An optional dictionary of additional GPU related attributes.
    */
    private java.util.Map<String, Object> auxAttributes;

    /**
    * An optional dictionary of graphics features and their status.
    */
    private java.util.Map<String, Object> featureStatus;

    /**
    * An optional array of GPU driver bug workarounds.
    */
    private java.util.List<String> driverBugWorkarounds;

    /**
    * Supported accelerated video decoding capabilities.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoDecodeAcceleratorCapability> videoDecoding;

    /**
    * Supported accelerated video encoding capabilities.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoEncodeAcceleratorCapability> videoEncoding;

    /**
    * Supported accelerated image decoding capabilities.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ImageDecodeAcceleratorCapability> imageDecoding;

    public void setDevices (java.util.List<jpuppeteer.cdp.client.entity.systeminfo.GPUDevice> devices) {
        this.devices = devices;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.systeminfo.GPUDevice> getDevices() {
        return this.devices;
    }

    public void setAuxAttributes (java.util.Map<String, Object> auxAttributes) {
        this.auxAttributes = auxAttributes;
    }

    public java.util.Map<String, Object> getAuxAttributes() {
        return this.auxAttributes;
    }

    public void setFeatureStatus (java.util.Map<String, Object> featureStatus) {
        this.featureStatus = featureStatus;
    }

    public java.util.Map<String, Object> getFeatureStatus() {
        return this.featureStatus;
    }

    public void setDriverBugWorkarounds (java.util.List<String> driverBugWorkarounds) {
        this.driverBugWorkarounds = driverBugWorkarounds;
    }

    public java.util.List<String> getDriverBugWorkarounds() {
        return this.driverBugWorkarounds;
    }

    public void setVideoDecoding (java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoDecodeAcceleratorCapability> videoDecoding) {
        this.videoDecoding = videoDecoding;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoDecodeAcceleratorCapability> getVideoDecoding() {
        return this.videoDecoding;
    }

    public void setVideoEncoding (java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoEncodeAcceleratorCapability> videoEncoding) {
        this.videoEncoding = videoEncoding;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoEncodeAcceleratorCapability> getVideoEncoding() {
        return this.videoEncoding;
    }

    public void setImageDecoding (java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ImageDecodeAcceleratorCapability> imageDecoding) {
        this.imageDecoding = imageDecoding;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ImageDecodeAcceleratorCapability> getImageDecoding() {
        return this.imageDecoding;
    }

    public GPUInfo(java.util.List<jpuppeteer.cdp.client.entity.systeminfo.GPUDevice> devices, java.util.Map<String, Object> auxAttributes, java.util.Map<String, Object> featureStatus, java.util.List<String> driverBugWorkarounds, java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoDecodeAcceleratorCapability> videoDecoding, java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoEncodeAcceleratorCapability> videoEncoding, java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ImageDecodeAcceleratorCapability> imageDecoding) {
        this.devices = devices;
        this.auxAttributes = auxAttributes;
        this.featureStatus = featureStatus;
        this.driverBugWorkarounds = driverBugWorkarounds;
        this.videoDecoding = videoDecoding;
        this.videoEncoding = videoEncoding;
        this.imageDecoding = imageDecoding;
    }

    public GPUInfo(java.util.List<jpuppeteer.cdp.client.entity.systeminfo.GPUDevice> devices, java.util.List<String> driverBugWorkarounds, java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoDecodeAcceleratorCapability> videoDecoding, java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoEncodeAcceleratorCapability> videoEncoding, java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ImageDecodeAcceleratorCapability> imageDecoding) {
        this.devices = devices;
        this.auxAttributes = null;
        this.featureStatus = null;
        this.driverBugWorkarounds = driverBugWorkarounds;
        this.videoDecoding = videoDecoding;
        this.videoEncoding = videoEncoding;
        this.imageDecoding = imageDecoding;
    }

    public GPUInfo() {
    }

}