package jpuppeteer.cdp.client.entity.performance;

/**
*/
public class EnableRequest {

    /**
    * Time domain to use for collecting and reporting duration metrics.
    */
    public final jpuppeteer.cdp.client.constant.performance.EnableRequestTimeDomain timeDomain;

    public EnableRequest(jpuppeteer.cdp.client.constant.performance.EnableRequestTimeDomain timeDomain) {
        this.timeDomain = timeDomain;
    }

    public EnableRequest() {
        this.timeDomain = null;
    }

}