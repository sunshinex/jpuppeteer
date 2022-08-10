package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetBreakOnCSPViolationRequest {

    /**
    * CSP Violations to stop upon.
    */
    private java.util.List<jpuppeteer.cdp.client.constant.domdebugger.CSPViolationType> violationTypes;

    public void setViolationTypes (java.util.List<jpuppeteer.cdp.client.constant.domdebugger.CSPViolationType> violationTypes) {
        this.violationTypes = violationTypes;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.domdebugger.CSPViolationType> getViolationTypes() {
        return this.violationTypes;
    }

    public SetBreakOnCSPViolationRequest(java.util.List<jpuppeteer.cdp.client.constant.domdebugger.CSPViolationType> violationTypes) {
        this.violationTypes = violationTypes;
    }

    public SetBreakOnCSPViolationRequest() {
    }

}