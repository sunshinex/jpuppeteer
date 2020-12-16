package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetFontSizesRequest {

    /**
    * Specifies font sizes to set. If a font size is not specified, it won't be changed.
    */
    public final FontSizes fontSizes;

    public SetFontSizesRequest(FontSizes fontSizes) {
        this.fontSizes = fontSizes;
    }

}