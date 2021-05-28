package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class ClearCredentialsRequest {

    /**
    */
    public final String authenticatorId;

    public ClearCredentialsRequest(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

}