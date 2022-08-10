package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Key path.
* experimental
*/
public class KeyPath {

    /**
    * Key path type.
    */
    private jpuppeteer.cdp.client.constant.indexeddb.KeyPathType type;

    /**
    * String value.
    */
    private String string;

    /**
    * Array value.
    */
    private java.util.List<String> array;

    public void setType (jpuppeteer.cdp.client.constant.indexeddb.KeyPathType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.indexeddb.KeyPathType getType() {
        return this.type;
    }

    public void setString (String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

    public void setArray (java.util.List<String> array) {
        this.array = array;
    }

    public java.util.List<String> getArray() {
        return this.array;
    }

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

    public KeyPath() {
    }

}