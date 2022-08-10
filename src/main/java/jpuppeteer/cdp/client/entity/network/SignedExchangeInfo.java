package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange response.
*/
public class SignedExchangeInfo {

    /**
    * The outer response of signed HTTP exchange which was received from network.
    */
    private jpuppeteer.cdp.client.entity.network.Response outerResponse;

    /**
    * Information about the signed exchange header.
    */
    private jpuppeteer.cdp.client.entity.network.SignedExchangeHeader header;

    /**
    * Security details for the signed exchange header.
    */
    private jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails;

    /**
    * Errors occurred while handling the signed exchagne.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeError> errors;

    public void setOuterResponse (jpuppeteer.cdp.client.entity.network.Response outerResponse) {
        this.outerResponse = outerResponse;
    }

    public jpuppeteer.cdp.client.entity.network.Response getOuterResponse() {
        return this.outerResponse;
    }

    public void setHeader (jpuppeteer.cdp.client.entity.network.SignedExchangeHeader header) {
        this.header = header;
    }

    public jpuppeteer.cdp.client.entity.network.SignedExchangeHeader getHeader() {
        return this.header;
    }

    public void setSecurityDetails (jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails) {
        this.securityDetails = securityDetails;
    }

    public jpuppeteer.cdp.client.entity.network.SecurityDetails getSecurityDetails() {
        return this.securityDetails;
    }

    public void setErrors (java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeError> errors) {
        this.errors = errors;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeError> getErrors() {
        return this.errors;
    }

    public SignedExchangeInfo(jpuppeteer.cdp.client.entity.network.Response outerResponse, jpuppeteer.cdp.client.entity.network.SignedExchangeHeader header, jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails, java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeError> errors) {
        this.outerResponse = outerResponse;
        this.header = header;
        this.securityDetails = securityDetails;
        this.errors = errors;
    }

    public SignedExchangeInfo(jpuppeteer.cdp.client.entity.network.Response outerResponse) {
        this.outerResponse = outerResponse;
        this.header = null;
        this.securityDetails = null;
        this.errors = null;
    }

    public SignedExchangeInfo() {
    }

}