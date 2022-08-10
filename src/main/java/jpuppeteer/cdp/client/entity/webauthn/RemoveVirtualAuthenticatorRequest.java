package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class RemoveVirtualAuthenticatorRequest {

    /**
    */
    private String authenticatorId;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public RemoveVirtualAuthenticatorRequest(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public RemoveVirtualAuthenticatorRequest() {
    }

}