package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class RemoveCredentialRequest {

    /**
    */
    private String authenticatorId;

    /**
    */
    private String credentialId;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public void setCredentialId (String credentialId) {
        this.credentialId = credentialId;
    }

    public String getCredentialId() {
        return this.credentialId;
    }

    public RemoveCredentialRequest(String authenticatorId, String credentialId) {
        this.authenticatorId = authenticatorId;
        this.credentialId = credentialId;
    }

    public RemoveCredentialRequest() {
    }

}