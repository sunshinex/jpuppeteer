package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetHistogramResponse {

    /**
    * Histogram.
    */
    public final Histogram histogram;

    public GetHistogramResponse(Histogram histogram) {
        this.histogram = histogram;
    }

}