package jpuppeteer.cdp.client.entity.browser;

/**
* Chrome histogram.
*/
public class Histogram {

    /**
    * Name.
    */
    public final String name;

    /**
    * Sum of sample values.
    */
    public final Integer sum;

    /**
    * Total number of samples.
    */
    public final Integer count;

    /**
    * Buckets.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.browser.Bucket> buckets;

    public Histogram(String name, Integer sum, Integer count, java.util.List<jpuppeteer.cdp.client.entity.browser.Bucket> buckets) {
        this.name = name;
        this.sum = sum;
        this.count = count;
        this.buckets = buckets;
    }

}