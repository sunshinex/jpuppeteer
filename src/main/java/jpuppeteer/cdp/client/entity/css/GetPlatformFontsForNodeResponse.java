package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetPlatformFontsForNodeResponse {

    /**
    * Usage statistics for every employed platform font.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.PlatformFontUsage> fonts;

    public GetPlatformFontsForNodeResponse(java.util.List<jpuppeteer.cdp.client.entity.css.PlatformFontUsage> fonts) {
        this.fonts = fonts;
    }

}