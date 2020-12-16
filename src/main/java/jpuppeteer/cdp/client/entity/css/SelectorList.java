package jpuppeteer.cdp.client.entity.css;

/**
* Selector list data.
* experimental
*/
public class SelectorList {

    /**
    * Selectors in the list.
    */
    public final java.util.List<Value> selectors;

    /**
    * Rule selector text.
    */
    public final String text;

    public SelectorList(java.util.List<Value> selectors, String text) {
        this.selectors = selectors;
        this.text = text;
    }

}