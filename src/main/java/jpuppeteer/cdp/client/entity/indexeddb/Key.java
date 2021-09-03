package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Key.
* experimental
*/
public class Key {

    /**
    * Key type.
    */
    public final jpuppeteer.cdp.client.constant.indexeddb.KeyType type;

    /**
    * Number value.
    */
    public final java.math.BigDecimal number;

    /**
    * String value.
    */
    public final String string;

    /**
    * Date value.
    */
    public final java.math.BigDecimal date;

    /**
    * Array value.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.indexeddb.Key> array;

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

}