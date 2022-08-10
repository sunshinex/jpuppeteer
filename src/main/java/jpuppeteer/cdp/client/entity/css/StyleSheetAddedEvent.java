package jpuppeteer.cdp.client.entity.css;

/**
* Fired whenever an active document stylesheet is added.
* experimental
*/
public class StyleSheetAddedEvent {

    /**
    * Added stylesheet metainfo.
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyleSheetHeader header;

    public void setHeader (jpuppeteer.cdp.client.entity.css.CSSStyleSheetHeader header) {
        this.header = header;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyleSheetHeader getHeader() {
        return this.header;
    }

    public StyleSheetAddedEvent(jpuppeteer.cdp.client.entity.css.CSSStyleSheetHeader header) {
        this.header = header;
    }

    public StyleSheetAddedEvent() {
    }

}