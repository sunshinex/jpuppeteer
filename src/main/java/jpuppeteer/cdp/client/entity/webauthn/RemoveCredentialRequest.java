package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class RemoveCredentialRequest {

    /**
    */
    public final String authenticatorId;

    /**
    */
    public final String credentialId;

    public RemoveCredentialRequest(String authenticatorId, String credentialId) {
        this.authenticatorId = authenticatorId;
        this.credentialId = credentialId;
    }

}