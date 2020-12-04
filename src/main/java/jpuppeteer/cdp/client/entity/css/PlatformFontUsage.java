package jpuppeteer.cdp.client.entity.css;

/**
* Information about amount of glyphs that were rendered with given font.
* experimental
*/
public class PlatformFontUsage {

    /**
    * Font's family name reported by platform.
    */
    public final String familyName;

    /**
    * Indicates if the font was downloaded or resolved locally.
    */
    public final Boolean isCustomFont;

    /**
    * Amount of glyphs that were rendered with this font.
    */
    public final java.math.BigDecimal glyphCount;

    public PlatformFontUsage(String familyName, Boolean isCustomFont, java.math.BigDecimal glyphCount) {
        this.familyName = familyName;
        this.isCustomFont = isCustomFont;
        this.glyphCount = glyphCount;
    }

}