package jpuppeteer.cdp.client.entity.css;

/**
* Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
* experimental
*/
public class FontFace {

    /**
    * The font-family.
    */
    public final String fontFamily;

    /**
    * The font-style.
    */
    public final String fontStyle;

    /**
    * The font-variant.
    */
    public final String fontVariant;

    /**
    * The font-weight.
    */
    public final String fontWeight;

    /**
    * The font-stretch.
    */
    public final String fontStretch;

    /**
    * The unicode-range.
    */
    public final String unicodeRange;

    /**
    * The src.
    */
    public final String src;

    /**
    * The resolved platform font family
    */
    public final String platformFontFamily;

    public FontFace(String fontFamily, String fontStyle, String fontVariant, String fontWeight, String fontStretch, String unicodeRange, String src, String platformFontFamily) {
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
        this.fontVariant = fontVariant;
        this.fontWeight = fontWeight;
        this.fontStretch = fontStretch;
        this.unicodeRange = unicodeRange;
        this.src = src;
        this.platformFontFamily = platformFontFamily;
    }

}