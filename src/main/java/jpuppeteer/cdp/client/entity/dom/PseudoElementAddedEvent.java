package jpuppeteer.cdp.client.entity.dom;

/**
* Called when a pseudo element is added to an element.
*/
public class PseudoElementAddedEvent {

    /**
    * Pseudo element's parent element id.
    */
    private Integer parentId;

    /**
    * The added pseudo element.
    */
    private jpuppeteer.cdp.client.entity.dom.Node pseudoElement;

    public void setParentId (Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setPseudoElement (jpuppeteer.cdp.client.entity.dom.Node pseudoElement) {
        this.pseudoElement = pseudoElement;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getPseudoElement() {
        return this.pseudoElement;
    }

    public PseudoElementAddedEvent(Integer parentId, jpuppeteer.cdp.client.entity.dom.Node pseudoElement) {
        this.parentId = parentId;
        this.pseudoElement = pseudoElement;
    }

    public PseudoElementAddedEvent() {
    }

}