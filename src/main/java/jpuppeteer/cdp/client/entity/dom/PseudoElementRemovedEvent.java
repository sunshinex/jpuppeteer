package jpuppeteer.cdp.client.entity.dom;

/**
* Called when a pseudo element is removed from an element.
*/
public class PseudoElementRemovedEvent {

    /**
    * Pseudo element's parent element id.
    */
    public final Integer parentId;

    /**
    * The removed pseudo element id.
    */
    public final Integer pseudoElementId;

    public PseudoElementRemovedEvent(Integer parentId, Integer pseudoElementId) {
        this.parentId = parentId;
        this.pseudoElementId = pseudoElementId;
    }

}