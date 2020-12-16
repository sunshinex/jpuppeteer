package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class AddVirtualAuthenticatorRequest {

    /**
    */
    public final VirtualAuthenticatorOptions options;

    public AddVirtualAuthenticatorRequest(VirtualAuthenticatorOptions options) {
        this.options = options;
    }

}