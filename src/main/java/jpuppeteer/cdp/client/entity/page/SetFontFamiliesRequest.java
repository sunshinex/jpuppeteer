package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetFontFamiliesRequest {

    /**
    * Specifies font families to set. If a font family is not specified, it won't be changed.
    */
    private jpuppeteer.cdp.client.entity.page.FontFamilies fontFamilies;

    public void setFontFamilies (jpuppeteer.cdp.client.entity.page.FontFamilies fontFamilies) {
        this.fontFamilies = fontFamilies;
    }

    public jpuppeteer.cdp.client.entity.page.FontFamilies getFontFamilies() {
        return this.fontFamilies;
    }

    public SetFontFamiliesRequest(jpuppeteer.cdp.client.entity.page.FontFamilies fontFamilies) {
        this.fontFamilies = fontFamilies;
    }

    public SetFontFamiliesRequest() {
    }

}