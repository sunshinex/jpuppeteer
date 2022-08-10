package jpuppeteer.cdp.client.entity.performance;

/**
*/
public class EnableRequest {

    /**
    * Time domain to use for collecting and reporting duration metrics.
    */
    private jpuppeteer.cdp.client.constant.performance.EnableRequestTimeDomain timeDomain;

    public void setTimeDomain (jpuppeteer.cdp.client.constant.performance.EnableRequestTimeDomain timeDomain) {
        this.timeDomain = timeDomain;
    }

    public jpuppeteer.cdp.client.constant.performance.EnableRequestTimeDomain getTimeDomain() {
        return this.timeDomain;
    }

    public EnableRequest(jpuppeteer.cdp.client.constant.performance.EnableRequestTimeDomain timeDomain) {
        this.timeDomain = timeDomain;
    }

    public EnableRequest() {
        this.timeDomain = null;
    }

}