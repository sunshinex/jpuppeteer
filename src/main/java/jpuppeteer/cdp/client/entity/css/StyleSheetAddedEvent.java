package jpuppeteer.cdp.client.entity.css;

/**
* Fired whenever an active document stylesheet is added.
* experimental
*/
public class StyleSheetAddedEvent {

    /**
    * Added stylesheet metainfo.
    */
    public final CSSStyleSheetHeader header;

    public StyleSheetAddedEvent(CSSStyleSheetHeader header) {
        this.header = header;
    }

}