package jpuppeteer.cdp.client.entity.indexeddb;

/**
* Key range.
* experimental
*/
public class KeyRange {

    /**
    * Lower bound.
    */
    private jpuppeteer.cdp.client.entity.indexeddb.Key lower;

    /**
    * Upper bound.
    */
    private jpuppeteer.cdp.client.entity.indexeddb.Key upper;

    /**
    * If true lower bound is open.
    */
    private Boolean lowerOpen;

    /**
    * If true upper bound is open.
    */
    private Boolean upperOpen;

    public void setLower (jpuppeteer.cdp.client.entity.indexeddb.Key lower) {
        this.lower = lower;
    }

    public jpuppeteer.cdp.client.entity.indexeddb.Key getLower() {
        return this.lower;
    }

    public void setUpper (jpuppeteer.cdp.client.entity.indexeddb.Key upper) {
        this.upper = upper;
    }

    public jpuppeteer.cdp.client.entity.indexeddb.Key getUpper() {
        return this.upper;
    }

    public void setLowerOpen (Boolean lowerOpen) {
        this.lowerOpen = lowerOpen;
    }

    public Boolean getLowerOpen() {
        return this.lowerOpen;
    }

    public void setUpperOpen (Boolean upperOpen) {
        this.upperOpen = upperOpen;
    }

    public Boolean getUpperOpen() {
        return this.upperOpen;
    }

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

    public KeyRange() {
    }

}