package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointsActiveRequest {

    /**
    * New value for breakpoints active state.
    */
    public final Boolean active;

    public SetBreakpointsActiveRequest(Boolean active) {
        this.active = active;
    }

}