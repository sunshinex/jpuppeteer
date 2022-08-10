package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialsResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.webauthn.Credential> credentials;

    public void setCredentials (java.util.List<jpuppeteer.cdp.client.entity.webauthn.Credential> credentials) {
        this.credentials = credentials;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.webauthn.Credential> getCredentials() {
        return this.credentials;
    }

    public GetCredentialsResponse(java.util.List<jpuppeteer.cdp.client.entity.webauthn.Credential> credentials) {
        this.credentials = credentials;
    }

    public GetCredentialsResponse() {
    }

}