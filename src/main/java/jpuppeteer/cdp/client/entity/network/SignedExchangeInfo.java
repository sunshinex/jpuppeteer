package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange response.
*/
public class SignedExchangeInfo {

    /**
    * The outer response of signed HTTP exchange which was received from network.
    */
    public final Response outerResponse;

    /**
    * Information about the signed exchange header.
    */
    public final SignedExchangeHeader header;

    /**
    * Security details for the signed exchange header.
    */
    public final SecurityDetails securityDetails;

    /**
    * Errors occurred while handling the signed exchagne.
    */
    public final java.util.List<SignedExchangeError> errors;

    public SignedExchangeInfo(Response outerResponse, SignedExchangeHeader header, SecurityDetails securityDetails, java.util.List<SignedExchangeError> errors) {
        this.outerResponse = outerResponse;
        this.header = header;
        this.securityDetails = securityDetails;
        this.errors = errors;
    }

    public SignedExchangeInfo(Response outerResponse) {
        this.outerResponse = outerResponse;
        this.header = null;
        this.securityDetails = null;
        this.errors = null;
    }

}