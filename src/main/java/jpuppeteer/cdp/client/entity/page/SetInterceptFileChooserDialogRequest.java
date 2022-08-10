package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetInterceptFileChooserDialogRequest {

    /**
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetInterceptFileChooserDialogRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetInterceptFileChooserDialogRequest() {
    }

}