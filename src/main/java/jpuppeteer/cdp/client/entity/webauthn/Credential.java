package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class Credential {

    /**
    */
    private String credentialId;

    /**
    */
    private Boolean isResidentCredential;

    /**
    * Relying Party ID the credential is scoped to. Must be set when adding a credential.
    */
    private String rpId;

    /**
    * The ECDSA P-256 private key in PKCS#8 format. (Encoded as a base64 string when passed over JSON)
    */
    private String privateKey;

    /**
    * An opaque byte sequence with a maximum size of 64 bytes mapping the credential to a specific user. (Encoded as a base64 string when passed over JSON)
    */
    private String userHandle;

    /**
    * Signature counter. This is incremented by one for each successful assertion. See https://w3c.github.io/webauthn/#signature-counter
    */
    private Integer signCount;

    /**
    * The large blob associated with the credential. See https://w3c.github.io/webauthn/#sctn-large-blob-extension (Encoded as a base64 string when passed over JSON)
    */
    private String largeBlob;

    public void setCredentialId (String credentialId) {
        this.credentialId = credentialId;
    }

    public String getCredentialId() {
        return this.credentialId;
    }

    public void setIsResidentCredential (Boolean isResidentCredential) {
        this.isResidentCredential = isResidentCredential;
    }

    public Boolean getIsResidentCredential() {
        return this.isResidentCredential;
    }

    public void setRpId (String rpId) {
        this.rpId = rpId;
    }

    public String getRpId() {
        return this.rpId;
    }

    public void setPrivateKey (String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

    public void setUserHandle (String userHandle) {
        this.userHandle = userHandle;
    }

    public String getUserHandle() {
        return this.userHandle;
    }

    public void setSignCount (Integer signCount) {
        this.signCount = signCount;
    }

    public Integer getSignCount() {
        return this.signCount;
    }

    public void setLargeBlob (String largeBlob) {
        this.largeBlob = largeBlob;
    }

    public String getLargeBlob() {
        return this.largeBlob;
    }

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

    public Credential() {
    }

}