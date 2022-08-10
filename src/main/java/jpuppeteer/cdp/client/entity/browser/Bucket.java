package jpuppeteer.cdp.client.entity.browser;

/**
* Chrome histogram bucket.
*/
public class Bucket {

    /**
    * Minimum value (inclusive).
    */
    private Integer low;

    /**
    * Maximum value (exclusive).
    */
    private Integer high;

    /**
    * Number of samples.
    */
    private Integer count;

    public void setLow (Integer low) {
        this.low = low;
    }

    public Integer getLow() {
        return this.low;
    }

    public void setHigh (Integer high) {
        this.high = high;
    }

    public Integer getHigh() {
        return this.high;
    }

    public void setCount (Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return this.count;
    }

    public Bucket(Integer low, Integer high, Integer count) {
        this.low = low;
        this.high = high;
        this.count = count;
    }

    public Bucket() {
    }

}