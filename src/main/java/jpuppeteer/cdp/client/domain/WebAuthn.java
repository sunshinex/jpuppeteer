package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class WebAuthn {

    private jpuppeteer.cdp.CDPSession session;

    public WebAuthn(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Enable the WebAuthn domain and start intercepting credential storage and retrieval with a virtual authenticator.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("WebAuthn.enable", null);
    }


    /**
    * Disable the WebAuthn domain.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("WebAuthn.disable", null);
    }


    /**
    * Creates and adds a virtual authenticator.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webauthn.AddVirtualAuthenticatorResponse> addVirtualAuthenticator(jpuppeteer.cdp.client.entity.webauthn.AddVirtualAuthenticatorRequest request) {
        return session.send("WebAuthn.addVirtualAuthenticator", request, jpuppeteer.cdp.client.entity.webauthn.AddVirtualAuthenticatorResponse.class);
    }


    /**
    * Removes the given authenticator.
    */
    public io.netty.util.concurrent.Future removeVirtualAuthenticator(jpuppeteer.cdp.client.entity.webauthn.RemoveVirtualAuthenticatorRequest request) {
        return session.send("WebAuthn.removeVirtualAuthenticator", request);
    }


    /**
    * Adds the credential to the specified authenticator.
    */
    public io.netty.util.concurrent.Future addCredential(jpuppeteer.cdp.client.entity.webauthn.AddCredentialRequest request) {
        return session.send("WebAuthn.addCredential", request);
    }


    /**
    * Returns a single credential stored in the given virtual authenticator that matches the credential ID.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webauthn.GetCredentialResponse> getCredential(jpuppeteer.cdp.client.entity.webauthn.GetCredentialRequest request) {
        return session.send("WebAuthn.getCredential", request, jpuppeteer.cdp.client.entity.webauthn.GetCredentialResponse.class);
    }


    /**
    * Returns all the credentials stored in the given virtual authenticator.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webauthn.GetCredentialsResponse> getCredentials(jpuppeteer.cdp.client.entity.webauthn.GetCredentialsRequest request) {
        return session.send("WebAuthn.getCredentials", request, jpuppeteer.cdp.client.entity.webauthn.GetCredentialsResponse.class);
    }


    /**
    * Removes a credential from the authenticator.
    */
    public io.netty.util.concurrent.Future removeCredential(jpuppeteer.cdp.client.entity.webauthn.RemoveCredentialRequest request) {
        return session.send("WebAuthn.removeCredential", request);
    }


    /**
    * Clears all the credentials from the specified device.
    */
    public io.netty.util.concurrent.Future clearCredentials(jpuppeteer.cdp.client.entity.webauthn.ClearCredentialsRequest request) {
        return session.send("WebAuthn.clearCredentials", request);
    }


    /**
    * Sets whether User Verification succeeds or fails for an authenticator. The default is true.
    */
    public io.netty.util.concurrent.Future setUserVerified(jpuppeteer.cdp.client.entity.webauthn.SetUserVerifiedRequest request) {
        return session.send("WebAuthn.setUserVerified", request);
    }

}