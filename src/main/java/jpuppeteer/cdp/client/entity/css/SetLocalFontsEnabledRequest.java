package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetLocalFontsEnabledRequest {

    /**
    * Whether rendering of local fonts is enabled.
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetLocalFontsEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetLocalFontsEnabledRequest() {
    }

}