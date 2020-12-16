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
    public final Node pseudoElement;

    public PseudoElementAddedEvent(Integer parentId, Node pseudoElement) {
        this.parentId = parentId;
        this.pseudoElement = pseudoElement;
    }

}