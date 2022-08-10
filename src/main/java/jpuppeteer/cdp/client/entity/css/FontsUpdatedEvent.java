package jpuppeteer.cdp.client.entity.css;

/**
* Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded web font
* experimental
*/
public class FontsUpdatedEvent {

    /**
    * The web font that has loaded.
    */
    private jpuppeteer.cdp.client.entity.css.FontFace font;

    public void setFont (jpuppeteer.cdp.client.entity.css.FontFace font) {
        this.font = font;
    }

    public jpuppeteer.cdp.client.entity.css.FontFace getFont() {
        return this.font;
    }

    public FontsUpdatedEvent(jpuppeteer.cdp.client.entity.css.FontFace font) {
        this.font = font;
    }

    public FontsUpdatedEvent() {
        this.font = null;
    }

}