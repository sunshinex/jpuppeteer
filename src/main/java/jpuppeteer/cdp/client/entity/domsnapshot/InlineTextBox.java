package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* Details of post layout rendered text positions. The exact layout should not be regarded as stable and may change between versions.
* experimental
*/
public class InlineTextBox {

    /**
    * The bounding box in document coordinates. Note that scroll offset of the document is ignored.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect boundingBox;

    /**
    * The starting index in characters, for this post layout textbox substring. Characters that would be represented as a surrogate pair in UTF-16 have length 2.
    */
    public final Integer startCharacterIndex;

    /**
    * The number of characters in this post layout textbox substring. Characters that would be represented as a surrogate pair in UTF-16 have length 2.
    */
    public final Integer numCharacters;

    public InlineTextBox(jpuppeteer.cdp.client.entity.dom.Rect boundingBox, Integer startCharacterIndex, Integer numCharacters) {
        this.boundingBox = boundingBox;
        this.startCharacterIndex = startCharacterIndex;
        this.numCharacters = numCharacters;
    }

}