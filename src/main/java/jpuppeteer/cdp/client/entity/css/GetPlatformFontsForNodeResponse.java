package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetPlatformFontsForNodeResponse {

    /**
    * Usage statistics for every employed platform font.
    */
    public final java.util.List<PlatformFontUsage> fonts;

    public GetPlatformFontsForNodeResponse(java.util.List<PlatformFontUsage> fonts) {
        this.fonts = fonts;
    }

}