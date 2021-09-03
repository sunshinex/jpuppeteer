package jpuppeteer.cdp.client.entity.css;

/**
* Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded web font
* experimental
*/
public class FontsUpdatedEvent {

    /**
    * The web font that has loaded.
    */
    public final jpuppeteer.cdp.client.entity.css.FontFace font;

    public FontsUpdatedEvent(jpuppeteer.cdp.client.entity.css.FontFace font) {
        this.font = font;
    }

    public FontsUpdatedEvent() {
        this.font = null;
    }

}