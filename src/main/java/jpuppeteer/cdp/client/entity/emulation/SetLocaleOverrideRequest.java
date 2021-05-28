package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetLocaleOverrideRequest {

    /**
    * ICU style C locale (e.g. "en_US"). If not specified or empty, disables the override and restores default host system locale.
    */
    public final String locale;

    public SetLocaleOverrideRequest(String locale) {
        this.locale = locale;
    }

    public SetLocaleOverrideRequest() {
        this.locale = null;
    }

}