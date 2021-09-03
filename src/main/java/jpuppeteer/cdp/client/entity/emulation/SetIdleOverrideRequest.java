package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetIdleOverrideRequest {

    /**
    * Mock isUserActive
    */
    public final Boolean isUserActive;

    /**
    * Mock isScreenUnlocked
    */
    public final Boolean isScreenUnlocked;

    public SetIdleOverrideRequest(Boolean isUserActive, Boolean isScreenUnlocked) {
        this.isUserActive = isUserActive;
        this.isScreenUnlocked = isScreenUnlocked;
    }

}