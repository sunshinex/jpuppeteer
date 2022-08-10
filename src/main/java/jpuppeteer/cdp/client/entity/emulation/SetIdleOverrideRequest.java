package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetIdleOverrideRequest {

    /**
    * Mock isUserActive
    */
    private Boolean isUserActive;

    /**
    * Mock isScreenUnlocked
    */
    private Boolean isScreenUnlocked;

    public void setIsUserActive (Boolean isUserActive) {
        this.isUserActive = isUserActive;
    }

    public Boolean getIsUserActive() {
        return this.isUserActive;
    }

    public void setIsScreenUnlocked (Boolean isScreenUnlocked) {
        this.isScreenUnlocked = isScreenUnlocked;
    }

    public Boolean getIsScreenUnlocked() {
        return this.isScreenUnlocked;
    }

    public SetIdleOverrideRequest(Boolean isUserActive, Boolean isScreenUnlocked) {
        this.isUserActive = isUserActive;
        this.isScreenUnlocked = isScreenUnlocked;
    }

    public SetIdleOverrideRequest() {
    }

}