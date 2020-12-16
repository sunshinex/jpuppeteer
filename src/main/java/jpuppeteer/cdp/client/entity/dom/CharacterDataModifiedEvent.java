package jpuppeteer.cdp.client.entity.dom;

/**
* Mirrors `DOMCharacterDataModified` event.
*/
public class CharacterDataModifiedEvent {

    /**
    * Id of the node that has changed.
    */
    public final Integer nodeId;

    /**
    * New text value.
    */
    public final String characterData;

    public CharacterDataModifiedEvent(Integer nodeId, String characterData) {
        this.nodeId = nodeId;
        this.characterData = characterData;
    }

}