package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("WebAuthn.enable", null, timeout);
    }


    /**
    * Disable the WebAuthn domain.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("WebAuthn.disable", null, timeout);
    }


    /**
    * Creates and adds a virtual authenticator.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.webauthn.AddVirtualAuthenticatorResponse addVirtualAuthenticator(jpuppeteer.cdp.cdp.entity.webauthn.AddVirtualAuthenticatorRequest request, int timeout) throws Exception {
        return session.send("WebAuthn.addVirtualAuthenticator", request, jpuppeteer.cdp.cdp.entity.webauthn.AddVirtualAuthenticatorResponse.class, timeout);
    }


    /**
    * Removes the given authenticator.
    * experimental
    */
    public void removeVirtualAuthenticator(jpuppeteer.cdp.cdp.entity.webauthn.RemoveVirtualAuthenticatorRequest request, int timeout) throws Exception {
        session.send("WebAuthn.removeVirtualAuthenticator", request, timeout);
    }


    /**
    * Adds the credential to the specified authenticator.
    * experimental
    */
    public void addCredential(jpuppeteer.cdp.cdp.entity.webauthn.AddCredentialRequest request, int timeout) throws Exception {
        session.send("WebAuthn.addCredential", request, timeout);
    }


    /**
    * Returns all the credentials stored in the given virtual authenticator.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.webauthn.GetCredentialsResponse getCredentials(jpuppeteer.cdp.cdp.entity.webauthn.GetCredentialsRequest request, int timeout) throws Exception {
        return session.send("WebAuthn.getCredentials", request, jpuppeteer.cdp.cdp.entity.webauthn.GetCredentialsResponse.class, timeout);
    }


    /**
    * Clears all the credentials from the specified device.
    * experimental
    */
    public void clearCredentials(jpuppeteer.cdp.cdp.entity.webauthn.ClearCredentialsRequest request, int timeout) throws Exception {
        session.send("WebAuthn.clearCredentials", request, timeout);
    }


    /**
    * Sets whether User Verification succeeds or fails for an authenticator. The default is true.
    * experimental
    */
    public void setUserVerified(jpuppeteer.cdp.cdp.entity.webauthn.SetUserVerifiedRequest request, int timeout) throws Exception {
        session.send("WebAuthn.setUserVerified", request, timeout);
    }

}