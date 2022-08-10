package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetFontSizesRequest {

    /**
    * Specifies font sizes to set. If a font size is not specified, it won't be changed.
    */
    private jpuppeteer.cdp.client.entity.page.FontSizes fontSizes;

    public void setFontSizes (jpuppeteer.cdp.client.entity.page.FontSizes fontSizes) {
        this.fontSizes = fontSizes;
    }

    public jpuppeteer.cdp.client.entity.page.FontSizes getFontSizes() {
        return this.fontSizes;
    }

    public SetFontSizesRequest(jpuppeteer.cdp.client.entity.page.FontSizes fontSizes) {
        this.fontSizes = fontSizes;
    }

    public SetFontSizesRequest() {
    }

}