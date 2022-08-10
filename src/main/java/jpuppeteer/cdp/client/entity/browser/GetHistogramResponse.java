package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetHistogramResponse {

    /**
    * Histogram.
    */
    private jpuppeteer.cdp.client.entity.browser.Histogram histogram;

    public void setHistogram (jpuppeteer.cdp.client.entity.browser.Histogram histogram) {
        this.histogram = histogram;
    }

    public jpuppeteer.cdp.client.entity.browser.Histogram getHistogram() {
        return this.histogram;
    }

    public GetHistogramResponse(jpuppeteer.cdp.client.entity.browser.Histogram histogram) {
        this.histogram = histogram;
    }

    public GetHistogramResponse() {
    }

}