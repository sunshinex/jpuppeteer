package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetSkipAllPausesRequest {

    /**
    * New value for skip pauses state.
    */
    public final Boolean skip;

    public SetSkipAllPausesRequest(Boolean skip) {
        this.skip = skip;
    }

}