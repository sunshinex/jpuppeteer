package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Key path.
* experimental
*/
public class KeyPath {

    /**
    * Key path type.
    */
    public final jpuppeteer.cdp.client.constant.indexeddb.KeyPathType type;

    /**
    * String value.
    */
    public final String string;

    /**
    * Array value.
    */
    public final java.util.List<String> array;

    public KeyPath(jpuppeteer.cdp.client.constant.indexeddb.KeyPathType type, String string, java.util.List<String> array) {
        this.type = type;
        this.string = string;
        this.array = array;
    }

    public KeyPath(jpuppeteer.cdp.client.constant.indexeddb.KeyPathType type) {
        this.type = type;
        this.string = null;
        this.array = null;
    }

}