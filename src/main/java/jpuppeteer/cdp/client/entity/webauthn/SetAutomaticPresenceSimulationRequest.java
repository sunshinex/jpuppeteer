package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class SetAutomaticPresenceSimulationRequest {

    /**
    */
    private String authenticatorId;

    /**
    */
    private Boolean enabled;

    public void setAuthenticatorId (String authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public String getAuthenticatorId() {
        return this.authenticatorId;
    }

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetAutomaticPresenceSimulationRequest(String authenticatorId, Boolean enabled) {
        this.authenticatorId = authenticatorId;
        this.enabled = enabled;
    }

    public SetAutomaticPresenceSimulationRequest() {
    }

}