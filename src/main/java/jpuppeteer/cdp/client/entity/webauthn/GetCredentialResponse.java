package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialResponse {

    /**
    */
    public final Credential credential;

    public GetCredentialResponse(Credential credential) {
        this.credential = credential;
    }

}