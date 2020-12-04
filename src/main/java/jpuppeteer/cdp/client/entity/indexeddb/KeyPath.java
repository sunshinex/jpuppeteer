package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Key path.
* experimental
*/
public class KeyPath {

    /**
    * Key path type.
    */
    public final String type;

    /**
    * String value.
    */
    public final String string;

    /**
    * Array value.
    */
    public final java.util.List<String> array;

    public KeyPath(String type, String string, java.util.List<String> array) {
        this.type = type;
        this.string = string;
        this.array = array;
    }

    public KeyPath(String type) {
        this.type = type;
        this.string = null;
        this.array = null;
    }

}