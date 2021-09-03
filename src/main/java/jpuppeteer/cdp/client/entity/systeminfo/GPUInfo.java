package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Provides information about the GPU(s) on the system.
* experimental
*/
public class GPUInfo {

    /**
    * The graphics devices on the system. Element 0 is the primary GPU.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.systeminfo.GPUDevice> devices;

    /**
    * An optional dictionary of additional GPU related attributes.
    */
    public final java.util.Map<String, Object> auxAttributes;

    /**
    * An optional dictionary of graphics features and their status.
    */
    public final java.util.Map<String, Object> featureStatus;

    /**
    * An optional array of GPU driver bug workarounds.
    */
    public final java.util.List<String> driverBugWorkarounds;

    /**
    * Supported accelerated video decoding capabilities.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoDecodeAcceleratorCapability> videoDecoding;

    /**
    * Supported accelerated video encoding capabilities.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.systeminfo.VideoEncodeAcceleratorCapability> videoEncoding;

    /**
    * Supported accelerated image decoding capabilities.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.systeminfo.ImageDecodeAcceleratorCapability> imageDecoding;

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

}