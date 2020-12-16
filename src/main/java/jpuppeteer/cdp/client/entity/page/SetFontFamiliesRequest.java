package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetFontFamiliesRequest {

    /**
    * Specifies font families to set. If a font family is not specified, it won't be changed.
    */
    public final FontFamilies fontFamilies;

    public SetFontFamiliesRequest(FontFamilies fontFamilies) {
        this.fontFamilies = fontFamilies;
    }

}