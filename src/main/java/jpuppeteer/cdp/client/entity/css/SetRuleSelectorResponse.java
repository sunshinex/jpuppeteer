package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetRuleSelectorResponse {

    /**
    * The resulting selector list after modification.
    */
    private jpuppeteer.cdp.client.entity.css.SelectorList selectorList;

    public void setSelectorList (jpuppeteer.cdp.client.entity.css.SelectorList selectorList) {
        this.selectorList = selectorList;
    }

    public jpuppeteer.cdp.client.entity.css.SelectorList getSelectorList() {
        return this.selectorList;
    }

    public SetRuleSelectorResponse(jpuppeteer.cdp.client.entity.css.SelectorList selectorList) {
        this.selectorList = selectorList;
    }

    public SetRuleSelectorResponse() {
    }

}