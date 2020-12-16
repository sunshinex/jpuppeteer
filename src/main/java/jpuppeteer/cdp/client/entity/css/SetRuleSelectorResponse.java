package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetRuleSelectorResponse {

    /**
    * The resulting selector list after modification.
    */
    public final SelectorList selectorList;

    public SetRuleSelectorResponse(SelectorList selectorList) {
        this.selectorList = selectorList;
    }

}