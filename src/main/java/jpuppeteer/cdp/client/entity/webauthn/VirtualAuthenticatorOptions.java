package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class VirtualAuthenticatorOptions {

    /**
    */
    public final String protocol;

    /**
    */
    public final String transport;

    /**
    * Defaults to false.
    */
    public final Boolean hasResidentKey;

    /**
    * Defaults to false.
    */
    public final Boolean hasUserVerification;

    /**
    * If set to true, tests of user presence will succeed immediately. Otherwise, they will not be resolved. Defaults to true.
    */
    public final Boolean automaticPresenceSimulation;

    /**
    * Sets whether User Verification succeeds or fails for an authenticator. Defaults to false.
    */
    public final Boolean isUserVerified;

    public VirtualAuthenticatorOptions(String protocol, String transport, Boolean hasResidentKey, Boolean hasUserVerification, Boolean automaticPresenceSimulation, Boolean isUserVerified) {
        this.protocol = protocol;
        this.transport = transport;
        this.hasResidentKey = hasResidentKey;
        this.hasUserVerification = hasUserVerification;
        this.automaticPresenceSimulation = automaticPresenceSimulation;
        this.isUserVerified = isUserVerified;
    }

    public VirtualAuthenticatorOptions(String protocol, String transport) {
        this.protocol = protocol;
        this.transport = transport;
        this.hasResidentKey = null;
        this.hasUserVerification = null;
        this.automaticPresenceSimulation = null;
        this.isUserVerified = null;
    }

}