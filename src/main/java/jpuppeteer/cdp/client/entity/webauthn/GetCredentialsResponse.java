package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialsResponse {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.webauthn.Credential> credentials;

    public GetCredentialsResponse(java.util.List<jpuppeteer.cdp.client.entity.webauthn.Credential> credentials) {
        this.credentials = credentials;
    }

}