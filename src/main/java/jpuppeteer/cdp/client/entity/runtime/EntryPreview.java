package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class EntryPreview {

    /**
    * Preview of the key. Specified for map-like collection entries.
    */
    private jpuppeteer.cdp.client.entity.runtime.ObjectPreview key;

    /**
    * Preview of the value.
    */
    private jpuppeteer.cdp.client.entity.runtime.ObjectPreview value;

    public void setKey (jpuppeteer.cdp.client.entity.runtime.ObjectPreview key) {
        this.key = key;
    }

    public jpuppeteer.cdp.client.entity.runtime.ObjectPreview getKey() {
        return this.key;
    }

    public void setValue (jpuppeteer.cdp.client.entity.runtime.ObjectPreview value) {
        this.value = value;
    }

    public jpuppeteer.cdp.client.entity.runtime.ObjectPreview getValue() {
        return this.value;
    }

    public EntryPreview(jpuppeteer.cdp.client.entity.runtime.ObjectPreview key, jpuppeteer.cdp.client.entity.runtime.ObjectPreview value) {
        this.key = key;
        this.value = value;
    }

    public EntryPreview(jpuppeteer.cdp.client.entity.runtime.ObjectPreview value) {
        this.key = null;
        this.value = value;
    }

    public EntryPreview() {
    }

}