package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class SetUserVerifiedRequest {

    /**
    */
    private String authenticatorId;

    /**
    */
    private Boolean isUserVerified;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public void setIsUserVerified (Boolean isUserVerified) {
        this.isUserVerified = isUserVerified;
    }

    public Boolean getIsUserVerified() {
        return this.isUserVerified;
    }

    public SetUserVerifiedRequest(String authenticatorId, Boolean isUserVerified) {
        this.authenticatorId = authenticatorId;
        this.isUserVerified = isUserVerified;
    }

    public SetUserVerifiedRequest() {
    }

}