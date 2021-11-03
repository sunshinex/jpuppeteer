package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class WebAuthn {

    private jpuppeteer.cdp.CDPConnection connection;

    public WebAuthn(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Enable the WebAuthn domain and start intercepting credential storage and retrieval with a virtual authenticator.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("WebAuthn.enable", null);
    }


    /**
    * Disable the WebAuthn domain.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("WebAuthn.disable", null);
    }


    /**
    * Creates and adds a virtual authenticator.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webauthn.AddVirtualAuthenticatorResponse> addVirtualAuthenticator(jpuppeteer.cdp.client.entity.webauthn.AddVirtualAuthenticatorRequest request) {
        return connection.send("WebAuthn.addVirtualAuthenticator", request, jpuppeteer.cdp.client.entity.webauthn.AddVirtualAuthenticatorResponse.class);
    }


    /**
    * Removes the given authenticator.
    */
    public io.netty.util.concurrent.Future removeVirtualAuthenticator(jpuppeteer.cdp.client.entity.webauthn.RemoveVirtualAuthenticatorRequest request) {
        return connection.send("WebAuthn.removeVirtualAuthenticator", request);
    }


    /**
    * Adds the credential to the specified authenticator.
    */
    public io.netty.util.concurrent.Future addCredential(jpuppeteer.cdp.client.entity.webauthn.AddCredentialRequest request) {
        return connection.send("WebAuthn.addCredential", request);
    }


    /**
    * Returns a single credential stored in the given virtual authenticator that matches the credential ID.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webauthn.GetCredentialResponse> getCredential(jpuppeteer.cdp.client.entity.webauthn.GetCredentialRequest request) {
        return connection.send("WebAuthn.getCredential", request, jpuppeteer.cdp.client.entity.webauthn.GetCredentialResponse.class);
    }


    /**
    * Returns all the credentials stored in the given virtual authenticator.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.webauthn.GetCredentialsResponse> getCredentials(jpuppeteer.cdp.client.entity.webauthn.GetCredentialsRequest request) {
        return connection.send("WebAuthn.getCredentials", request, jpuppeteer.cdp.client.entity.webauthn.GetCredentialsResponse.class);
    }


    /**
    * Removes a credential from the authenticator.
    */
    public io.netty.util.concurrent.Future removeCredential(jpuppeteer.cdp.client.entity.webauthn.RemoveCredentialRequest request) {
        return connection.send("WebAuthn.removeCredential", request);
    }


    /**
    * Clears all the credentials from the specified device.
    */
    public io.netty.util.concurrent.Future clearCredentials(jpuppeteer.cdp.client.entity.webauthn.ClearCredentialsRequest request) {
        return connection.send("WebAuthn.clearCredentials", request);
    }


    /**
    * Sets whether User Verification succeeds or fails for an authenticator. The default is true.
    */
    public io.netty.util.concurrent.Future setUserVerified(jpuppeteer.cdp.client.entity.webauthn.SetUserVerifiedRequest request) {
        return connection.send("WebAuthn.setUserVerified", request);
    }


    /**
    * Sets whether tests of user presence will succeed immediately (if true) or fail to resolve (if false) for an authenticator. The default is true.
    */
    public io.netty.util.concurrent.Future setAutomaticPresenceSimulation(jpuppeteer.cdp.client.entity.webauthn.SetAutomaticPresenceSimulationRequest request) {
        return connection.send("WebAuthn.setAutomaticPresenceSimulation", request);
    }

}