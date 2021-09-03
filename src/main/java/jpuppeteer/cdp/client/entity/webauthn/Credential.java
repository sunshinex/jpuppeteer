package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class Credential {

    /**
    */
    public final String credentialId;

    /**
    */
    public final Boolean isResidentCredential;

    /**
    * Relying Party ID the credential is scoped to. Must be set when adding a credential.
    */
    public final String rpId;

    /**
    * The ECDSA P-256 private key in PKCS#8 format. (Encoded as a base64 string when passed over JSON)
    */
    public final String privateKey;

    /**
    * An opaque byte sequence with a maximum size of 64 bytes mapping the credential to a specific user. (Encoded as a base64 string when passed over JSON)
    */
    public final String userHandle;

    /**
    * Signature counter. This is incremented by one for each successful assertion. See https://w3c.github.io/webauthn/#signature-counter
    */
    public final Integer signCount;

    /**
    * The large blob associated with the credential. See https://w3c.github.io/webauthn/#sctn-large-blob-extension (Encoded as a base64 string when passed over JSON)
    */
    public final String largeBlob;

    public Credential(String credentialId, Boolean isResidentCredential, String rpId, String privateKey, String userHandle, Integer signCount, String largeBlob) {
        this.credentialId = credentialId;
        this.isResidentCredential = isResidentCredential;
        this.rpId = rpId;
        this.privateKey = privateKey;
        this.userHandle = userHandle;
        this.signCount = signCount;
        this.largeBlob = largeBlob;
    }

    public Credential(String credentialId, Boolean isResidentCredential, String privateKey, Integer signCount) {
        this.credentialId = credentialId;
        this.isResidentCredential = isResidentCredential;
        this.rpId = null;
        this.privateKey = privateKey;
        this.userHandle = null;
        this.signCount = signCount;
        this.largeBlob = null;
    }

}