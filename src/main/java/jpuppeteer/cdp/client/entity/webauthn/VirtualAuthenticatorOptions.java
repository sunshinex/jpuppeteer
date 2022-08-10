package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class VirtualAuthenticatorOptions {

    /**
    */
    private jpuppeteer.cdp.client.constant.webauthn.AuthenticatorProtocol protocol;

    /**
    * Defaults to ctap2_0. Ignored if |protocol| == u2f.
    */
    private jpuppeteer.cdp.client.constant.webauthn.Ctap2Version ctap2Version;

    /**
    */
    private jpuppeteer.cdp.client.constant.webauthn.AuthenticatorTransport transport;

    /**
    * Defaults to false.
    */
    private Boolean hasResidentKey;

    /**
    * Defaults to false.
    */
    private Boolean hasUserVerification;

    /**
    * If set to true, the authenticator will support the largeBlob extension. https://w3c.github.io/webauthn#largeBlob Defaults to false.
    */
    private Boolean hasLargeBlob;

    /**
    * If set to true, the authenticator will support the credBlob extension. https://fidoalliance.org/specs/fido-v2.1-rd-20201208/fido-client-to-authenticator-protocol-v2.1-rd-20201208.html#sctn-credBlob-extension Defaults to false.
    */
    private Boolean hasCredBlob;

    /**
    * If set to true, tests of user presence will succeed immediately. Otherwise, they will not be resolved. Defaults to true.
    */
    private Boolean automaticPresenceSimulation;

    /**
    * Sets whether User Verification succeeds or fails for an authenticator. Defaults to false.
    */
    private Boolean isUserVerified;

    public void setProtocol (jpuppeteer.cdp.client.constant.webauthn.AuthenticatorProtocol protocol) {
        this.protocol = protocol;
    }

    public jpuppeteer.cdp.client.constant.webauthn.AuthenticatorProtocol getProtocol() {
        return this.protocol;
    }

    public void setCtap2Version (jpuppeteer.cdp.client.constant.webauthn.Ctap2Version ctap2Version) {
        this.ctap2Version = ctap2Version;
    }

    public jpuppeteer.cdp.client.constant.webauthn.Ctap2Version getCtap2Version() {
        return this.ctap2Version;
    }

    public void setTransport (jpuppeteer.cdp.client.constant.webauthn.AuthenticatorTransport transport) {
        this.transport = transport;
    }

    public jpuppeteer.cdp.client.constant.webauthn.AuthenticatorTransport getTransport() {
        return this.transport;
    }

    public void setHasResidentKey (Boolean hasResidentKey) {
        this.hasResidentKey = hasResidentKey;
    }

    public Boolean getHasResidentKey() {
        return this.hasResidentKey;
    }

    public void setHasUserVerification (Boolean hasUserVerification) {
        this.hasUserVerification = hasUserVerification;
    }

    public Boolean getHasUserVerification() {
        return this.hasUserVerification;
    }

    public void setHasLargeBlob (Boolean hasLargeBlob) {
        this.hasLargeBlob = hasLargeBlob;
    }

    public Boolean getHasLargeBlob() {
        return this.hasLargeBlob;
    }

    public void setHasCredBlob (Boolean hasCredBlob) {
        this.hasCredBlob = hasCredBlob;
    }

    public Boolean getHasCredBlob() {
        return this.hasCredBlob;
    }

    public void setAutomaticPresenceSimulation (Boolean automaticPresenceSimulation) {
        this.automaticPresenceSimulation = automaticPresenceSimulation;
    }

    public Boolean getAutomaticPresenceSimulation() {
        return this.automaticPresenceSimulation;
    }

    public void setIsUserVerified (Boolean isUserVerified) {
        this.isUserVerified = isUserVerified;
    }

    public Boolean getIsUserVerified() {
        return this.isUserVerified;
    }

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

    public VirtualAuthenticatorOptions() {
    }

}