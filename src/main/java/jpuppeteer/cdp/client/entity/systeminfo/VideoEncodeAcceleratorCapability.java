package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a supported video encoding profile with its associated maximum resolution and maximum framerate.
* experimental
*/
public class VideoEncodeAcceleratorCapability {

    /**
    * Video codec profile that is supported, e.g H264 Main.
    */
    private String profile;

    /**
    * Maximum video dimensions in pixels supported for this |profile|.
    */
    private jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution;

    /**
    * Maximum encoding framerate in frames per second supported for this |profile|, as fraction's numerator and denominator, e.g. 24/1 fps, 24000/1001 fps, etc.
    */
    private Integer maxFramerateNumerator;

    /**
    */
    private Integer maxFramerateDenominator;

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

    public void setMaxFramerateNumerator (Integer maxFramerateNumerator) {
        this.maxFramerateNumerator = maxFramerateNumerator;
    }

    public Integer getMaxFramerateNumerator() {
        return this.maxFramerateNumerator;
    }

    public void setMaxFramerateDenominator (Integer maxFramerateDenominator) {
        this.maxFramerateDenominator = maxFramerateDenominator;
    }

    public Integer getMaxFramerateDenominator() {
        return this.maxFramerateDenominator;
    }

    public VideoEncodeAcceleratorCapability(String profile, jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution, Integer maxFramerateNumerator, Integer maxFramerateDenominator) {
        this.profile = profile;
        this.maxResolution = maxResolution;
        this.maxFramerateNumerator = maxFramerateNumerator;
        this.maxFramerateDenominator = maxFramerateDenominator;
    }

    public VideoEncodeAcceleratorCapability() {
    }

}