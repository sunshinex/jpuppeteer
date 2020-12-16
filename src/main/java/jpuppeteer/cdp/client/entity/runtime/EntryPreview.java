package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class EntryPreview {

    /**
    * Preview of the key. Specified for map-like collection entries.
    */
    public final ObjectPreview key;

    /**
    * Preview of the value.
    */
    public final ObjectPreview value;

    public EntryPreview(ObjectPreview key, ObjectPreview value) {
        this.key = key;
        this.value = value;
    }

    public EntryPreview(ObjectPreview value) {
        this.key = null;
        this.value = value;
    }

}