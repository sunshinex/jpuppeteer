package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Key.
* experimental
*/
public class Key {

    /**
    * Key type.
    */
    private jpuppeteer.cdp.client.constant.indexeddb.KeyType type;

    /**
    * Number value.
    */
    private java.math.BigDecimal number;

    /**
    * String value.
    */
    private String string;

    /**
    * Date value.
    */
    private java.math.BigDecimal date;

    /**
    * Array value.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.indexeddb.Key> array;

    public void setType (jpuppeteer.cdp.client.constant.indexeddb.KeyType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.indexeddb.KeyType getType() {
        return this.type;
    }

    public void setNumber (java.math.BigDecimal number) {
        this.number = number;
    }

    public java.math.BigDecimal getNumber() {
        return this.number;
    }

    public void setString (String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

    public void setDate (java.math.BigDecimal date) {
        this.date = date;
    }

    public java.math.BigDecimal getDate() {
        return this.date;
    }

    public void setArray (java.util.List<jpuppeteer.cdp.client.entity.indexeddb.Key> array) {
        this.array = array;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.indexeddb.Key> getArray() {
        return this.array;
    }

    public Key(jpuppeteer.cdp.client.constant.indexeddb.KeyType type, java.math.BigDecimal number, String string, java.math.BigDecimal date, java.util.List<jpuppeteer.cdp.client.entity.indexeddb.Key> array) {
        this.type = type;
        this.number = number;
        this.string = string;
        this.date = date;
        this.array = array;
    }

    public Key(jpuppeteer.cdp.client.constant.indexeddb.KeyType type) {
        this.type = type;
        this.number = null;
        this.string = null;
        this.date = null;
        this.array = null;
    }

    public Key() {
    }

}