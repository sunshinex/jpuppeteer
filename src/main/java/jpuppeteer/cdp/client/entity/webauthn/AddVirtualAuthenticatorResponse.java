package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class AddVirtualAuthenticatorResponse {

    /**
    */
    private String authenticatorId;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public AddVirtualAuthenticatorResponse(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public AddVirtualAuthenticatorResponse() {
    }

}