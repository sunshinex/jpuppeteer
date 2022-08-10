package jpuppeteer.cdp.client.entity.dom;

/**
* Called when a pseudo element is removed from an element.
*/
public class PseudoElementRemovedEvent {

    /**
    * Pseudo element's parent element id.
    */
    private Integer parentId;

    /**
    * The removed pseudo element id.
    */
    private Integer pseudoElementId;

    public void setParentId (Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setPseudoElementId (Integer pseudoElementId) {
        this.pseudoElementId = pseudoElementId;
    }

    public Integer getPseudoElementId() {
        return this.pseudoElementId;
    }

    public PseudoElementRemovedEvent(Integer parentId, Integer pseudoElementId) {
        this.parentId = parentId;
        this.pseudoElementId = pseudoElementId;
    }

    public PseudoElementRemovedEvent() {
    }

}