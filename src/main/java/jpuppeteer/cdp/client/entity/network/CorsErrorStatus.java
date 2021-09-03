package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CorsErrorStatus {

    /**
    */
    public final jpuppeteer.cdp.client.constant.network.CorsError corsError;

    /**
    */
    public final String failedParameter;

    public CorsErrorStatus(jpuppeteer.cdp.client.constant.network.CorsError corsError, String failedParameter) {
        this.corsError = corsError;
        this.failedParameter = failedParameter;
    }

}