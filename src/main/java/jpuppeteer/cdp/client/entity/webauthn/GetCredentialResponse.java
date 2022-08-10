package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.webauthn.Credential credential;

    public void setCredential (jpuppeteer.cdp.client.entity.webauthn.Credential credential) {
        this.credential = credential;
    }

    public jpuppeteer.cdp.client.entity.webauthn.Credential getCredential() {
        return this.credential;
    }

    public GetCredentialResponse(jpuppeteer.cdp.client.entity.webauthn.Credential credential) {
        this.credential = credential;
    }

    public GetCredentialResponse() {
    }

}