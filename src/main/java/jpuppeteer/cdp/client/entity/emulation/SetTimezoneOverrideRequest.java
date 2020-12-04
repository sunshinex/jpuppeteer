package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetTimezoneOverrideRequest {

    /**
    * The timezone identifier. If empty, disables the override and restores default host system timezone.
    */
    public final String timezoneId;

    public SetTimezoneOverrideRequest(String timezoneId) {
        this.timezoneId = timezoneId;
    }

}