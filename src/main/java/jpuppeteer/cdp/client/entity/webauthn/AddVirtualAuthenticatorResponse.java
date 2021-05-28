package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class AddVirtualAuthenticatorResponse {

    /**
    */
    public final String authenticatorId;

    public AddVirtualAuthenticatorResponse(String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

}