package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialsRequest {

    /**
    */
    public final String authenticatorId;

    public GetCredentialsRequest(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

}