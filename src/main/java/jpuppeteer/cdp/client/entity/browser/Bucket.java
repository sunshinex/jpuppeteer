package jpuppeteer.cdp.client.entity.browser;

/**
* Chrome histogram bucket.
*/
public class Bucket {

    /**
    * Minimum value (inclusive).
    */
    public final Integer low;

    /**
    * Maximum value (exclusive).
    */
    public final Integer high;

    /**
    * Number of samples.
    */
    public final Integer count;

    public Bucket(Integer low, Integer high, Integer count) {
        this.low = low;
        this.high = high;
        this.count = count;
    }

}