package jpuppeteer.cdp.client.entity.css;

/**
* Information about amount of glyphs that were rendered with given font.
* experimental
*/
public class PlatformFontUsage {

    /**
    * Font's family name reported by platform.
    */
    private String familyName;

    /**
    * Indicates if the font was downloaded or resolved locally.
    */
    private Boolean isCustomFont;

    /**
    * Amount of glyphs that were rendered with this font.
    */
    private java.math.BigDecimal glyphCount;

    public void setFamilyName (String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setIsCustomFont (Boolean isCustomFont) {
        this.isCustomFont = isCustomFont;
    }

    public Boolean getIsCustomFont() {
        return this.isCustomFont;
    }

    public void setGlyphCount (java.math.BigDecimal glyphCount) {
        this.glyphCount = glyphCount;
    }

    public java.math.BigDecimal getGlyphCount() {
        return this.glyphCount;
    }

    public PlatformFontUsage(String familyName, Boolean isCustomFont, java.math.BigDecimal glyphCount) {
        this.familyName = familyName;
        this.isCustomFont = isCustomFont;
        this.glyphCount = glyphCount;
    }

    public PlatformFontUsage() {
    }

}