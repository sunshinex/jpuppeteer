package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class SetUserVerifiedRequest {

    /**
    */
    public final String authenticatorId;

    /**
    */
    public final Boolean isUserVerified;

    public SetUserVerifiedRequest(String authenticatorId, Boolean isUserVerified) {
        this.authenticatorId = authenticatorId;
        this.isUserVerified = isUserVerified;
    }

}