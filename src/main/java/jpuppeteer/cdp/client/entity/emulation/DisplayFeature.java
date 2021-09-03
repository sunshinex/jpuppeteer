package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class DisplayFeature {

    /**
    * Orientation of a display feature in relation to screen
    */
    public final jpuppeteer.cdp.client.constant.emulation.DisplayFeatureOrientation orientation;

    /**
    * The offset from the screen origin in either the x (for vertical orientation) or y (for horizontal orientation) direction.
    */
    public final Integer offset;

    /**
    * A display feature may mask content such that it is not physically displayed - this length along with the offset describes this area. A display feature that only splits content will have a 0 mask_length.
    */
    public final Integer maskLength;

    public DisplayFeature(jpuppeteer.cdp.client.constant.emulation.DisplayFeatureOrientation orientation, Integer offset, Integer maskLength) {
        this.orientation = orientation;
        this.offset = offset;
        this.maskLength = maskLength;
    }

}