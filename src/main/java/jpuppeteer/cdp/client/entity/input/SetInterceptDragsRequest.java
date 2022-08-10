package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SetInterceptDragsRequest {

    /**
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetInterceptDragsRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetInterceptDragsRequest() {
    }

}