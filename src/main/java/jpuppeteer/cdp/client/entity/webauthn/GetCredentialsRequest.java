package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialsRequest {

    /**
    */
    private String authenticatorId;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public GetCredentialsRequest(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public GetCredentialsRequest() {
    }

}