package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetHistogramsResponse {

    /**
    * Histograms.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.browser.Histogram> histograms;

    public void setHistograms (java.util.List<jpuppeteer.cdp.client.entity.browser.Histogram> histograms) {
        this.histograms = histograms;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.browser.Histogram> getHistograms() {
        return this.histograms;
    }

    public GetHistogramsResponse(java.util.List<jpuppeteer.cdp.client.entity.browser.Histogram> histograms) {
        this.histograms = histograms;
    }

    public GetHistogramsResponse() {
    }

}