package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class GetCredentialRequest {

    /**
    */
    public final String authenticatorId;

    /**
    */
    public final String credentialId;

    public GetCredentialRequest(String authenticatorId, String credentialId) {
        this.authenticatorId = authenticatorId;
        this.credentialId = credentialId;
    }

}