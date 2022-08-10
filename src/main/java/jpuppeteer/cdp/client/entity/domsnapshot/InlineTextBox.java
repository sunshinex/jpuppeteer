package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Details of post layout rendered text positions. The exact layout should not be regarded as stable and may change between versions.
* experimental
*/
public class InlineTextBox {

    /**
    * The bounding box in document coordinates. Note that scroll offset of the document is ignored.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect boundingBox;

    /**
    * The starting index in characters, for this post layout textbox substring. Characters that would be represented as a surrogate pair in UTF-16 have length 2.
    */
    private Integer startCharacterIndex;

    /**
    * The number of characters in this post layout textbox substring. Characters that would be represented as a surrogate pair in UTF-16 have length 2.
    */
    private Integer numCharacters;

    public void setBoundingBox (jpuppeteer.cdp.client.entity.dom.Rect boundingBox) {
        this.boundingBox = boundingBox;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getBoundingBox() {
        return this.boundingBox;
    }

    public void setStartCharacterIndex (Integer startCharacterIndex) {
        this.startCharacterIndex = startCharacterIndex;
    }

    public Integer getStartCharacterIndex() {
        return this.startCharacterIndex;
    }

    public void setNumCharacters (Integer numCharacters) {
        this.numCharacters = numCharacters;
    }

    public Integer getNumCharacters() {
        return this.numCharacters;
    }

    public InlineTextBox(jpuppeteer.cdp.client.entity.dom.Rect boundingBox, Integer startCharacterIndex, Integer numCharacters) {
        this.boundingBox = boundingBox;
        this.startCharacterIndex = startCharacterIndex;
        this.numCharacters = numCharacters;
    }

    public InlineTextBox() {
    }

}