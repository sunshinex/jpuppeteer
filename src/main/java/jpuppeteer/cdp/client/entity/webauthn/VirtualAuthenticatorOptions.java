package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class VirtualAuthenticatorOptions {

    /**
    */
    public final jpuppeteer.cdp.client.constant.webauthn.AuthenticatorProtocol protocol;

    /**
    * Defaults to ctap2_0. Ignored if |protocol| == u2f.
    */
    public final jpuppeteer.cdp.client.constant.webauthn.Ctap2Version ctap2Version;

    /**
    */
    public final jpuppeteer.cdp.client.constant.webauthn.AuthenticatorTransport transport;

    /**
    * Defaults to false.
    */
    public final Boolean hasResidentKey;

    /**
    * Defaults to false.
    */
    public final Boolean hasUserVerification;

    /**
    * If set to true, the authenticator will support the largeBlob extension. https://w3c.github.io/webauthn#largeBlob Defaults to false.
    */
    public final Boolean hasLargeBlob;

    /**
    * If set to true, the authenticator will support the credBlob extension. https://fidoalliance.org/specs/fido-v2.1-rd-20201208/fido-client-to-authenticator-protocol-v2.1-rd-20201208.html#sctn-credBlob-extension Defaults to false.
    */
    public final Boolean hasCredBlob;

    /**
    * If set to true, tests of user presence will succeed immediately. Otherwise, they will not be resolved. Defaults to true.
    */
    public final Boolean automaticPresenceSimulation;

    /**
    * Sets whether User Verification succeeds or fails for an authenticator. Defaults to false.
    */
    public final Boolean isUserVerified;

    public VirtualAuthenticatorOptions(jpuppeteer.cdp.client.constant.webauthn.AuthenticatorProtocol protocol, jpuppeteer.cdp.client.constant.webauthn.Ctap2Version ctap2Version, jpuppeteer.cdp.client.constant.webauthn.AuthenticatorTransport transport, Boolean hasResidentKey, Boolean hasUserVerification, Boolean hasLargeBlob, Boolean hasCredBlob, Boolean automaticPresenceSimulation, Boolean isUserVerified) {
        this.protocol = protocol;
        this.ctap2Version = ctap2Version;
        this.transport = transport;
        this.hasResidentKey = hasResidentKey;
        this.hasUserVerification = hasUserVerification;
        this.hasLargeBlob = hasLargeBlob;
        this.hasCredBlob = hasCredBlob;
        this.automaticPresenceSimulation = automaticPresenceSimulation;
        this.isUserVerified = isUserVerified;
    }

    public VirtualAuthenticatorOptions(jpuppeteer.cdp.client.constant.webauthn.AuthenticatorProtocol protocol, jpuppeteer.cdp.client.constant.webauthn.AuthenticatorTransport transport) {
        this.protocol = protocol;
        this.ctap2Version = null;
        this.transport = transport;
        this.hasResidentKey = null;
        this.hasUserVerification = null;
        this.hasLargeBlob = null;
        this.hasCredBlob = null;
        this.automaticPresenceSimulation = null;
        this.isUserVerified = null;
    }

}