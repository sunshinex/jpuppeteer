package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class Accessibility {

    private jpuppeteer.cdp.CDPSession session;

    public Accessibility(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disables the accessibility domain.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("Accessibility.disable", null, timeout);
    }


    /**
    * Enables the accessibility domain which causes `AXNodeId`s to remain consistent between method calls. This turns on accessibility for the page, which can impact performance until accessibility is disabled.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("Accessibility.enable", null, timeout);
    }


    /**
    * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.accessibility.GetPartialAXTreeResponse getPartialAXTree(jpuppeteer.cdp.cdp.entity.accessibility.GetPartialAXTreeRequest request, int timeout) throws Exception {
        return session.send("Accessibility.getPartialAXTree", request, jpuppeteer.cdp.cdp.entity.accessibility.GetPartialAXTreeResponse.class, timeout);
    }


    /**
    * Fetches the entire accessibility tree
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.accessibility.GetFullAXTreeResponse getFullAXTree(int timeout) throws Exception {
        return session.send("Accessibility.getFullAXTree", null, jpuppeteer.cdp.cdp.entity.accessibility.GetFullAXTreeResponse.class, timeout);
    }

}