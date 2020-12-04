package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange response.
*/
public class SignedExchangeError {

    /**
    * Error message.
    */
    public final String message;

    /**
    * The index of the signature which caused the error.
    */
    public final Integer signatureIndex;

    /**
    * The field which caused the error.
    */
    public final String errorField;

    public SignedExchangeError(String message, Integer signatureIndex, String errorField) {
        this.message = message;
        this.signatureIndex = signatureIndex;
        this.errorField = errorField;
    }

    public SignedExchangeError(String message) {
        this.message = message;
        this.signatureIndex = null;
        this.errorField = null;
    }

}