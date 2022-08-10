package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetScrollbarsHiddenRequest {

    /**
    * Whether scrollbars should be always hidden.
    */
    private Boolean hidden;

    public void setHidden (Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getHidden() {
        return this.hidden;
    }

    public SetScrollbarsHiddenRequest(Boolean hidden) {
        this.hidden = hidden;
    }

    public SetScrollbarsHiddenRequest() {
    }

}