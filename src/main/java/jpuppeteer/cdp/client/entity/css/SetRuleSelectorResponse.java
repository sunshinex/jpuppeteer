package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetRuleSelectorResponse {

    /**
    * The resulting selector list after modification.
    */
    public final jpuppeteer.cdp.client.entity.css.SelectorList selectorList;

    public SetRuleSelectorResponse(jpuppeteer.cdp.client.entity.css.SelectorList selectorList) {
        this.selectorList = selectorList;
    }

}