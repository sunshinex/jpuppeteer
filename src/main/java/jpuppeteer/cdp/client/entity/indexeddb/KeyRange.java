package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Key range.
* experimental
*/
public class KeyRange {

    /**
    * Lower bound.
    */
    public final jpuppeteer.cdp.client.entity.indexeddb.Key lower;

    /**
    * Upper bound.
    */
    public final jpuppeteer.cdp.client.entity.indexeddb.Key upper;

    /**
    * If true lower bound is open.
    */
    public final Boolean lowerOpen;

    /**
    * If true upper bound is open.
    */
    public final Boolean upperOpen;

    public KeyRange(jpuppeteer.cdp.client.entity.indexeddb.Key lower, jpuppeteer.cdp.client.entity.indexeddb.Key upper, Boolean lowerOpen, Boolean upperOpen) {
        this.lower = lower;
        this.upper = upper;
        this.lowerOpen = lowerOpen;
        this.upperOpen = upperOpen;
    }

    public KeyRange(Boolean lowerOpen, Boolean upperOpen) {
        this.lower = null;
        this.upper = null;
        this.lowerOpen = lowerOpen;
        this.upperOpen = upperOpen;
    }

}