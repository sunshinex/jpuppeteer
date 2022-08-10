package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class ClearCredentialsRequest {

    /**
    */
    private String authenticatorId;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public ClearCredentialsRequest(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public ClearCredentialsRequest() {
    }

}