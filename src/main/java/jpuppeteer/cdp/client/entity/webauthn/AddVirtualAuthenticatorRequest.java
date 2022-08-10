package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class AddVirtualAuthenticatorRequest {

    /**
    */
    private jpuppeteer.cdp.client.entity.webauthn.VirtualAuthenticatorOptions options;

    public void setOptions (jpuppeteer.cdp.client.entity.webauthn.VirtualAuthenticatorOptions options) {
        this.options = options;
    }

    public jpuppeteer.cdp.client.entity.webauthn.VirtualAuthenticatorOptions getOptions() {
        return this.options;
    }

    public AddVirtualAuthenticatorRequest(jpuppeteer.cdp.client.entity.webauthn.VirtualAuthenticatorOptions options) {
        this.options = options;
    }

    public AddVirtualAuthenticatorRequest() {
    }

}