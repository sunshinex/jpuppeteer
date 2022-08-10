package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange response.
*/
public class SignedExchangeError {

    /**
    * Error message.
    */
    private String message;

    /**
    * The index of the signature which caused the error.
    */
    private Integer signatureIndex;

    /**
    * The field which caused the error.
    */
    private jpuppeteer.cdp.client.constant.network.SignedExchangeErrorField errorField;

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setSignatureIndex (Integer signatureIndex) {
        this.signatureIndex = signatureIndex;
    }

    public Integer getSignatureIndex() {
        return this.signatureIndex;
    }

    public void setErrorField (jpuppeteer.cdp.client.constant.network.SignedExchangeErrorField errorField) {
        this.errorField = errorField;
    }

    public jpuppeteer.cdp.client.constant.network.SignedExchangeErrorField getErrorField() {
        return this.errorField;
    }

    public SignedExchangeError(String message, Integer signatureIndex, jpuppeteer.cdp.client.constant.network.SignedExchangeErrorField errorField) {
        this.message = message;
        this.signatureIndex = signatureIndex;
        this.errorField = errorField;
    }

    public SignedExchangeError(String message) {
        this.message = message;
        this.signatureIndex = null;
        this.errorField = null;
    }

    public SignedExchangeError() {
    }

}