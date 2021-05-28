package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange response.
*/
public class SignedExchangeInfo {

    /**
    * The outer response of signed HTTP exchange which was received from network.
    */
    public final jpuppeteer.cdp.client.entity.network.Response outerResponse;

    /**
    * Information about the signed exchange header.
    */
    public final jpuppeteer.cdp.client.entity.network.SignedExchangeHeader header;

    /**
    * Security details for the signed exchange header.
    */
    public final jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails;

    /**
    * Errors occurred while handling the signed exchagne.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeError> errors;

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

}