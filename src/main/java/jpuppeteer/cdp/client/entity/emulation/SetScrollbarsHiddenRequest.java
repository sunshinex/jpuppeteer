package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetScrollbarsHiddenRequest {

    /**
    * Whether scrollbars should be always hidden.
    */
    public final Boolean hidden;

    public SetScrollbarsHiddenRequest(Boolean hidden) {
        this.hidden = hidden;
    }

}