package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class AddCredentialRequest {

    /**
    */
    public final String authenticatorId;

    /**
    */
    public final jpuppeteer.cdp.client.entity.webauthn.Credential credential;

    public AddCredentialRequest(String authenticatorId, jpuppeteer.cdp.client.entity.webauthn.Credential credential) {
        this.authenticatorId = authenticatorId;
        this.credential = credential;
    }

}