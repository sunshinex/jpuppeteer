package jpuppeteer.cdp.client.entity.css;

/**
* Fired whenever an active document stylesheet is added.
* experimental
*/
public class StyleSheetAddedEvent {

    /**
    * Added stylesheet metainfo.
    */
    public final jpuppeteer.cdp.client.entity.css.CSSStyleSheetHeader header;

    public StyleSheetAddedEvent(jpuppeteer.cdp.client.entity.css.CSSStyleSheetHeader header) {
        this.header = header;
    }

}