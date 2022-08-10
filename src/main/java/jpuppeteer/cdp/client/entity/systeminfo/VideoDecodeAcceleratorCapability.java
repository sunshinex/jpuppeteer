package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a supported video decoding profile with its associated minimum and maximum resolutions.
* experimental
*/
public class VideoDecodeAcceleratorCapability {

    /**
    * Video codec profile that is supported, e.g. VP9 Profile 2.
    */
    private String profile;

    /**
    * Maximum video dimensions in pixels supported for this |profile|.
    */
    private jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution;

    /**
    * Minimum video dimensions in pixels supported for this |profile|.
    */
    private jpuppeteer.cdp.client.entity.systeminfo.Size minResolution;

    public void setProfile (String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setMaxResolution (jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution) {
        this.maxResolution = maxResolution;
    }

    public jpuppeteer.cdp.client.entity.systeminfo.Size getMaxResolution() {
        return this.maxResolution;
    }

    public void setMinResolution (jpuppeteer.cdp.client.entity.systeminfo.Size minResolution) {
        this.minResolution = minResolution;
    }

    public jpuppeteer.cdp.client.entity.systeminfo.Size getMinResolution() {
        return this.minResolution;
    }

    public VideoDecodeAcceleratorCapability(String profile, jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution, jpuppeteer.cdp.client.entity.systeminfo.Size minResolution) {
        this.profile = profile;
        this.maxResolution = maxResolution;
        this.minResolution = minResolution;
    }

    public VideoDecodeAcceleratorCapability() {
    }

}