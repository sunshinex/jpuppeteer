package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialsResponse {

    /**
    */
    public final java.util.List<Credential> credentials;

    public GetCredentialsResponse(java.util.List<Credential> credentials) {
        this.credentials = credentials;
    }

}