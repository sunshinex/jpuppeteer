package jpuppeteer.cdp.client.entity.css;

/**
* Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions and additional information such as platformFontFamily and fontVariationAxes.
* experimental
*/
public class FontFace {

    /**
    * The font-family.
    */
    private String fontFamily;

    /**
    * The font-style.
    */
    private String fontStyle;

    /**
    * The font-variant.
    */
    private String fontVariant;

    /**
    * The font-weight.
    */
    private String fontWeight;

    /**
    * The font-stretch.
    */
    private String fontStretch;

    /**
    * The unicode-range.
    */
    private String unicodeRange;

    /**
    * The src.
    */
    private String src;

    /**
    * The resolved platform font family
    */
    private String platformFontFamily;

    /**
    * Available variation settings (a.k.a. "axes").
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.FontVariationAxis> fontVariationAxes;

    public void setFontFamily (String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public void setFontStyle (String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getFontStyle() {
        return this.fontStyle;
    }

    public void setFontVariant (String fontVariant) {
        this.fontVariant = fontVariant;
    }

    public String getFontVariant() {
        return this.fontVariant;
    }

    public void setFontWeight (String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getFontWeight() {
        return this.fontWeight;
    }

    public void setFontStretch (String fontStretch) {
        this.fontStretch = fontStretch;
    }

    public String getFontStretch() {
        return this.fontStretch;
    }

    public void setUnicodeRange (String unicodeRange) {
        this.unicodeRange = unicodeRange;
    }

    public String getUnicodeRange() {
        return this.unicodeRange;
    }

    public void setSrc (String src) {
        this.src = src;
    }

    public String getSrc() {
        return this.src;
    }

    public void setPlatformFontFamily (String platformFontFamily) {
        this.platformFontFamily = platformFontFamily;
    }

    public String getPlatformFontFamily() {
        return this.platformFontFamily;
    }

    public void setFontVariationAxes (java.util.List<jpuppeteer.cdp.client.entity.css.FontVariationAxis> fontVariationAxes) {
        this.fontVariationAxes = fontVariationAxes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.FontVariationAxis> getFontVariationAxes() {
        return this.fontVariationAxes;
    }

    public FontFace(String fontFamily, String fontStyle, String fontVariant, String fontWeight, String fontStretch, String unicodeRange, String src, String platformFontFamily, java.util.List<jpuppeteer.cdp.client.entity.css.FontVariationAxis> fontVariationAxes) {
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
        this.fontVariant = fontVariant;
        this.fontWeight = fontWeight;
        this.fontStretch = fontStretch;
        this.unicodeRange = unicodeRange;
        this.src = src;
        this.platformFontFamily = platformFontFamily;
        this.fontVariationAxes = fontVariationAxes;
    }

    public FontFace(String fontFamily, String fontStyle, String fontVariant, String fontWeight, String fontStretch, String unicodeRange, String src, String platformFontFamily) {
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
        this.fontVariant = fontVariant;
        this.fontWeight = fontWeight;
        this.fontStretch = fontStretch;
        this.unicodeRange = unicodeRange;
        this.src = src;
        this.platformFontFamily = platformFontFamily;
        this.fontVariationAxes = null;
    }

    public FontFace() {
    }

}