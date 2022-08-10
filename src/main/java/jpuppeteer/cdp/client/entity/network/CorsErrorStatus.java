package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CorsErrorStatus {

    /**
    */
    private jpuppeteer.cdp.client.constant.network.CorsError corsError;

    /**
    */
    private String failedParameter;

    public void setCorsError (jpuppeteer.cdp.client.constant.network.CorsError corsError) {
        this.corsError = corsError;
    }

    public jpuppeteer.cdp.client.constant.network.CorsError getCorsError() {
        return this.corsError;
    }

    public void setFailedParameter (String failedParameter) {
        this.failedParameter = failedParameter;
    }

    public String getFailedParameter() {
        return this.failedParameter;
    }

    public CorsErrorStatus(jpuppeteer.cdp.client.constant.network.CorsError corsError, String failedParameter) {
        this.corsError = corsError;
        this.failedParameter = failedParameter;
    }

    public CorsErrorStatus() {
    }

}