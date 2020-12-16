package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class RemoveVirtualAuthenticatorRequest {

    /**
    */
    public final String authenticatorId;

    public RemoveVirtualAuthenticatorRequest(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

}