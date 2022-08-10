package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetPlatformFontsForNodeResponse {

    /**
    * Usage statistics for every employed platform font.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.PlatformFontUsage> fonts;

    public void setFonts (java.util.List<jpuppeteer.cdp.client.entity.css.PlatformFontUsage> fonts) {
        this.fonts = fonts;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.PlatformFontUsage> getFonts() {
        return this.fonts;
    }

    public GetPlatformFontsForNodeResponse(java.util.List<jpuppeteer.cdp.client.entity.css.PlatformFontUsage> fonts) {
        this.fonts = fonts;
    }

    public GetPlatformFontsForNodeResponse() {
    }

}