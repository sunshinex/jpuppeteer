package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointsActiveRequest {

    /**
    * New value for breakpoints active state.
    */
    private Boolean active;

    public void setActive (Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return this.active;
    }

    public SetBreakpointsActiveRequest(Boolean active) {
        this.active = active;
    }

    public SetBreakpointsActiveRequest() {
    }

}