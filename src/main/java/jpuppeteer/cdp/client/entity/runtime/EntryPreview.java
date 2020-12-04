package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class EntryPreview {

    /**
    * Preview of the key. Specified for map-like collection entries.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ObjectPreview key;

    /**
    * Preview of the value.
    */
    public final jpuppeteer.cdp.client.entity.runtime.ObjectPreview value;

    public EntryPreview(jpuppeteer.cdp.client.entity.runtime.ObjectPreview key, jpuppeteer.cdp.client.entity.runtime.ObjectPreview value) {
        this.key = key;
        this.value = value;
    }

    public EntryPreview(jpuppeteer.cdp.client.entity.runtime.ObjectPreview value) {
        this.key = null;
        this.value = value;
    }

}