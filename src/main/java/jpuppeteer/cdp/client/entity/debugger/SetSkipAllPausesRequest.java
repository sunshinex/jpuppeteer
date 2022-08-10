package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetSkipAllPausesRequest {

    /**
    * New value for skip pauses state.
    */
    private Boolean skip;

    public void setSkip (Boolean skip) {
        this.skip = skip;
    }

    public Boolean getSkip() {
        return this.skip;
    }

    public SetSkipAllPausesRequest(Boolean skip) {
        this.skip = skip;
    }

    public SetSkipAllPausesRequest() {
    }

}