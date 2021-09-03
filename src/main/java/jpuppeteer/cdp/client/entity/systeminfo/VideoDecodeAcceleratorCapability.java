package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a supported video decoding profile with its associated minimum and maximum resolutions.
* experimental
*/
public class VideoDecodeAcceleratorCapability {

    /**
    * Video codec profile that is supported, e.g. VP9 Profile 2.
    */
    public final String profile;

    /**
    * Maximum video dimensions in pixels supported for this |profile|.
    */
    public final jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution;

    /**
    * Minimum video dimensions in pixels supported for this |profile|.
    */
    public final jpuppeteer.cdp.client.entity.systeminfo.Size minResolution;

    public VideoDecodeAcceleratorCapability(String profile, jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution, jpuppeteer.cdp.client.entity.systeminfo.Size minResolution) {
        this.profile = profile;
        this.maxResolution = maxResolution;
        this.minResolution = minResolution;
    }

}