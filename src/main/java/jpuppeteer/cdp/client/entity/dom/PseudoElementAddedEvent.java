package jpuppeteer.cdp.client.entity.dom;

/**
* Called when a pseudo element is added to an element.
*/
public class PseudoElementAddedEvent {

    /**
    * Pseudo element's parent element id.
    */
    public final Integer parentId;

    /**
    * The added pseudo element.
    */
    public final jpuppeteer.cdp.client.entity.dom.Node pseudoElement;

    public PseudoElementAddedEvent(Integer parentId, jpuppeteer.cdp.client.entity.dom.Node pseudoElement) {
        this.parentId = parentId;
        this.pseudoElement = pseudoElement;
    }

}