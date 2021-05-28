package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a supported image decoding profile with its associated minimum and maximum resolutions and subsampling.
* experimental
*/
public class ImageDecodeAcceleratorCapability {

    /**
    * Image coded, e.g. Jpeg.
    */
    public final jpuppeteer.cdp.client.constant.systeminfo.ImageType imageType;

    /**
    * Maximum supported dimensions of the image in pixels.
    */
    public final jpuppeteer.cdp.client.entity.systeminfo.Size maxDimensions;

    /**
    * Minimum supported dimensions of the image in pixels.
    */
    public final jpuppeteer.cdp.client.entity.systeminfo.Size minDimensions;

    /**
    * Optional array of supported subsampling formats, e.g. 4:2:0, if known.
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.systeminfo.SubsamplingFormat> subsamplings;

    public ImageDecodeAcceleratorCapability(jpuppeteer.cdp.client.constant.systeminfo.ImageType imageType, jpuppeteer.cdp.client.entity.systeminfo.Size maxDimensions, jpuppeteer.cdp.client.entity.systeminfo.Size minDimensions, java.util.List<jpuppeteer.cdp.client.constant.systeminfo.SubsamplingFormat> subsamplings) {
        this.imageType = imageType;
        this.maxDimensions = maxDimensions;
        this.minDimensions = minDimensions;
        this.subsamplings = subsamplings;
    }

}