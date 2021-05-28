package jpuppeteer.cdp.client.entity.webauthn;

/**
* experimental
*/
public class SetAutomaticPresenceSimulationRequest {

    /**
    */
    public final String authenticatorId;

    /**
    */
    public final Boolean enabled;

    public SetAutomaticPresenceSimulationRequest(String authenticatorId, Boolean enabled) {
        this.authenticatorId = authenticatorId;
        this.enabled = enabled;
    }

}