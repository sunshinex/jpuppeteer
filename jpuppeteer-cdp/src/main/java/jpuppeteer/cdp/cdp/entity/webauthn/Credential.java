package jpuppeteer.cdp.cdp.entity.webauthn;

/**
* experimental
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class Credential {

    /**
    */
    private String credentialId;

    /**
    * SHA-256 hash of the Relying Party ID the credential is scoped to. Must be 32 bytes long. See https://w3c.github.io/webauthn/#rpidhash
    */
    private String rpIdHash;

    /**
    * The private key in PKCS#8 format.
    */
    private String privateKey;

    /**
    * Signature counter. This is incremented by one for each successful assertion. See https://w3c.github.io/webauthn/#signature-counter
    */
    private Integer signCount;



}