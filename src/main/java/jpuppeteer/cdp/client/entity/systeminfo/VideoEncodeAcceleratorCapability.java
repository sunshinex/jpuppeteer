package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a supported video encoding profile with its associated maximum resolution and maximum framerate.
* experimental
*/
public class VideoEncodeAcceleratorCapability {

    /**
    * Video codec profile that is supported, e.g H264 Main.
    */
    public final String profile;

    /**
    * Maximum video dimensions in pixels supported for this |profile|.
    */
    public final jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution;

    /**
    * Maximum encoding framerate in frames per second supported for this |profile|, as fraction's numerator and denominator, e.g. 24/1 fps, 24000/1001 fps, etc.
    */
    public final Integer maxFramerateNumerator;

    /**
    */
    public final Integer maxFramerateDenominator;

    public VideoEncodeAcceleratorCapability(String profile, jpuppeteer.cdp.client.entity.systeminfo.Size maxResolution, Integer maxFramerateNumerator, Integer maxFramerateDenominator) {
        this.profile = profile;
        this.maxResolution = maxResolution;
        this.maxFramerateNumerator = maxFramerateNumerator;
        this.maxFramerateDenominator = maxFramerateDenominator;
    }

}