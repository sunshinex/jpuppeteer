package jpuppeteer.cdp.client.entity.css;

/**
* Selector list data.
* experimental
*/
public class SelectorList {

    /**
    * Selectors in the list.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.Value> selectors;

    /**
    * Rule selector text.
    */
    private String text;

    public void setSelectors (java.util.List<jpuppeteer.cdp.client.entity.css.Value> selectors) {
        this.selectors = selectors;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.Value> getSelectors() {
        return this.selectors;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public SelectorList(java.util.List<jpuppeteer.cdp.client.entity.css.Value> selectors, String text) {
        this.selectors = selectors;
        this.text = text;
    }

    public SelectorList() {
    }

}