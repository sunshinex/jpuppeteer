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
    public final Credential credential;

    public AddCredentialRequest(String authenticatorId, Credential credential) {
        this.authenticatorId = authenticatorId;
        this.credential = credential;
    }

}