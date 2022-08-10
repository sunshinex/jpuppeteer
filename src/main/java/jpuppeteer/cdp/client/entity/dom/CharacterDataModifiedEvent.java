package jpuppeteer.cdp.client.entity.dom;

/**
* Mirrors `DOMCharacterDataModified` event.
*/
public class CharacterDataModifiedEvent {

    /**
    * Id of the node that has changed.
    */
    private Integer nodeId;

    /**
    * New text value.
    */
    private String characterData;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setCharacterData (String characterData) {
        this.characterData = characterData;
    }

    public String getCharacterData() {
        return this.characterData;
    }

    public CharacterDataModifiedEvent(Integer nodeId, String characterData) {
        this.nodeId = nodeId;
        this.characterData = characterData;
    }

    public CharacterDataModifiedEvent() {
    }

}