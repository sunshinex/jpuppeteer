package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetTimezoneOverrideRequest {

    /**
    * The timezone identifier. If empty, disables the override and restores default host system timezone.
    */
    private String timezoneId;

    public void setTimezoneId (String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getTimezoneId() {
        return this.timezoneId;
    }

    public SetTimezoneOverrideRequest(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public SetTimezoneOverrideRequest() {
    }

}