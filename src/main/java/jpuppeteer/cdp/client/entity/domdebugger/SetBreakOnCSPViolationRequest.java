package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetBreakOnCSPViolationRequest {

    /**
    * CSP Violations to stop upon.
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.domdebugger.CSPViolationType> violationTypes;

    public SetBreakOnCSPViolationRequest(java.util.List<jpuppeteer.cdp.client.constant.domdebugger.CSPViolationType> violationTypes) {
        this.violationTypes = violationTypes;
    }

}