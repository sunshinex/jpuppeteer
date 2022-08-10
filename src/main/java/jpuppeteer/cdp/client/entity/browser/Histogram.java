package jpuppeteer.cdp.client.entity.browser;

/**
* Chrome histogram.
*/
public class Histogram {

    /**
    * Name.
    */
    private String name;

    /**
    * Sum of sample values.
    */
    private Integer sum;

    /**
    * Total number of samples.
    */
    private Integer count;

    /**
    * Buckets.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.browser.Bucket> buckets;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSum (Integer sum) {
        this.sum = sum;
    }

    public Integer getSum() {
        return this.sum;
    }

    public void setCount (Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setBuckets (java.util.List<jpuppeteer.cdp.client.entity.browser.Bucket> buckets) {
        this.buckets = buckets;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.browser.Bucket> getBuckets() {
        return this.buckets;
    }

    public Histogram(String name, Integer sum, Integer count, java.util.List<jpuppeteer.cdp.client.entity.browser.Bucket> buckets) {
        this.name = name;
        this.sum = sum;
        this.count = count;
        this.buckets = buckets;
    }

    public Histogram() {
    }

}