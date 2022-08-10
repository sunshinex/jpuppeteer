package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class DisplayFeature {

    /**
    * Orientation of a display feature in relation to screen
    */
    private jpuppeteer.cdp.client.constant.emulation.DisplayFeatureOrientation orientation;

    /**
    * The offset from the screen origin in either the x (for vertical orientation) or y (for horizontal orientation) direction.
    */
    private Integer offset;

    /**
    * A display feature may mask content such that it is not physically displayed - this length along with the offset describes this area. A display feature that only splits content will have a 0 mask_length.
    */
    private Integer maskLength;

    public void setOrientation (jpuppeteer.cdp.client.constant.emulation.DisplayFeatureOrientation orientation) {
        this.orientation = orientation;
    }

    public jpuppeteer.cdp.client.constant.emulation.DisplayFeatureOrientation getOrientation() {
        return this.orientation;
    }

    public void setOffset (Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setMaskLength (Integer maskLength) {
        this.maskLength = maskLength;
    }

    public Integer getMaskLength() {
        return this.maskLength;
    }

    public DisplayFeature(jpuppeteer.cdp.client.constant.emulation.DisplayFeatureOrientation orientation, Integer offset, Integer maskLength) {
        this.orientation = orientation;
        this.offset = offset;
        this.maskLength = maskLength;
    }

    public DisplayFeature() {
    }

}