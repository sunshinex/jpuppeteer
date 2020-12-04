package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Table of details of the post layout rendered text positions. The exact layout should not be regarded as stable and may change between versions.
* experimental
*/
public class TextBoxSnapshot {

    /**
    * Index of the layout tree node that owns this box collection.
    */
    public final java.util.List<Integer> layoutIndex;

    /**
    * The absolute position bounding box.
    */
    public final java.util.List<java.util.List<java.math.BigDecimal>> bounds;

    /**
    * The starting index in characters, for this post layout textbox substring. Characters that would be represented as a surrogate pair in UTF-16 have length 2.
    */
    public final java.util.List<Integer> start;

    /**
    * The number of characters in this post layout textbox substring. Characters that would be represented as a surrogate pair in UTF-16 have length 2.
    */
    public final java.util.List<Integer> length;

    public TextBoxSnapshot(java.util.List<Integer> layoutIndex, java.util.List<java.util.List<java.math.BigDecimal>> bounds, java.util.List<Integer> start, java.util.List<Integer> length) {
        this.layoutIndex = layoutIndex;
        this.bounds = bounds;
        this.start = start;
        this.length = length;
    }

}