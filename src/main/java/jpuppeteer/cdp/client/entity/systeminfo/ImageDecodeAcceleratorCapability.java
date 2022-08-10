package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes a supported image decoding profile with its associated minimum and maximum resolutions and subsampling.
* experimental
*/
public class ImageDecodeAcceleratorCapability {

    /**
    * Image coded, e.g. Jpeg.
    */
    private jpuppeteer.cdp.client.constant.systeminfo.ImageType imageType;

    /**
    * Maximum supported dimensions of the image in pixels.
    */
    private jpuppeteer.cdp.client.entity.systeminfo.Size maxDimensions;

    /**
    * Minimum supported dimensions of the image in pixels.
    */
    private jpuppeteer.cdp.client.entity.systeminfo.Size minDimensions;

    /**
    * Optional array of supported subsampling formats, e.g. 4:2:0, if known.
    */
    private java.util.List<jpuppeteer.cdp.client.constant.systeminfo.SubsamplingFormat> subsamplings;

    public void setImageType (jpuppeteer.cdp.client.constant.systeminfo.ImageType imageType) {
        this.imageType = imageType;
    }

    public jpuppeteer.cdp.client.constant.systeminfo.ImageType getImageType() {
        return this.imageType;
    }

    public void setMaxDimensions (jpuppeteer.cdp.client.entity.systeminfo.Size maxDimensions) {
        this.maxDimensions = maxDimensions;
    }

    public jpuppeteer.cdp.client.entity.systeminfo.Size getMaxDimensions() {
        return this.maxDimensions;
    }

    public void setMinDimensions (jpuppeteer.cdp.client.entity.systeminfo.Size minDimensions) {
        this.minDimensions = minDimensions;
    }

    public jpuppeteer.cdp.client.entity.systeminfo.Size getMinDimensions() {
        return this.minDimensions;
    }

    public void setSubsamplings (java.util.List<jpuppeteer.cdp.client.constant.systeminfo.SubsamplingFormat> subsamplings) {
        this.subsamplings = subsamplings;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.systeminfo.SubsamplingFormat> getSubsamplings() {
        return this.subsamplings;
    }

    public ImageDecodeAcceleratorCapability(jpuppeteer.cdp.client.constant.systeminfo.ImageType imageType, jpuppeteer.cdp.client.entity.systeminfo.Size maxDimensions, jpuppeteer.cdp.client.entity.systeminfo.Size minDimensions, java.util.List<jpuppeteer.cdp.client.constant.systeminfo.SubsamplingFormat> subsamplings) {
        this.imageType = imageType;
        this.maxDimensions = maxDimensions;
        this.minDimensions = minDimensions;
        this.subsamplings = subsamplings;
    }

    public ImageDecodeAcceleratorCapability() {
    }

}