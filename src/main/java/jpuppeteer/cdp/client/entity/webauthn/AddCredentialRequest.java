package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class AddCredentialRequest {

    /**
    */
    private String authenticatorId;

    /**
    */
    private jpuppeteer.cdp.client.entity.webauthn.Credential credential;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public void setCredential (jpuppeteer.cdp.client.entity.webauthn.Credential credential) {
        this.credential = credential;
    }

    public jpuppeteer.cdp.client.entity.webauthn.Credential getCredential() {
        return this.credential;
    }

    public AddCredentialRequest(String authenticatorId, jpuppeteer.cdp.client.entity.webauthn.Credential credential) {
        this.authenticatorId = authenticatorId;
        this.credential = credential;
    }

    public AddCredentialRequest() {
    }

}