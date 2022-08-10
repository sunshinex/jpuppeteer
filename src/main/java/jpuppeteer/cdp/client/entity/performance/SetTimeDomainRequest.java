package jpuppeteer.cdp.client.entity.performance;

/**
*/
public class SetTimeDomainRequest {

    /**
    * Time domain
    */
    private jpuppeteer.cdp.client.constant.performance.SetTimeDomainRequestTimeDomain timeDomain;

    public void setTimeDomain (jpuppeteer.cdp.client.constant.performance.SetTimeDomainRequestTimeDomain timeDomain) {
        this.timeDomain = timeDomain;
    }

    public jpuppeteer.cdp.client.constant.performance.SetTimeDomainRequestTimeDomain getTimeDomain() {
        return this.timeDomain;
    }

    public SetTimeDomainRequest(jpuppeteer.cdp.client.constant.performance.SetTimeDomainRequestTimeDomain timeDomain) {
        this.timeDomain = timeDomain;
    }

    public SetTimeDomainRequest() {
    }

}