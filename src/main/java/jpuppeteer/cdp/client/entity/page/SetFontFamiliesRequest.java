package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetFontFamiliesRequest {

    /**
    * Specifies font families to set. If a font family is not specified, it won't be changed.
    */
    public final jpuppeteer.cdp.client.entity.page.FontFamilies fontFamilies;

    public SetFontFamiliesRequest(jpuppeteer.cdp.client.entity.page.FontFamilies fontFamilies) {
        this.fontFamilies = fontFamilies;
    }

}