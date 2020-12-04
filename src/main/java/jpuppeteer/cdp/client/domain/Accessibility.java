package jpuppeteer.cdp.client.domain;

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
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Accessibility.disable", null);
    }


    /**
    * Enables the accessibility domain which causes `AXNodeId`s to remain consistent between method calls. This turns on accessibility for the page, which can impact performance until accessibility is disabled.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Accessibility.enable", null);
    }


    /**
    * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.accessibility.GetPartialAXTreeResponse> getPartialAXTree(jpuppeteer.cdp.client.entity.accessibility.GetPartialAXTreeRequest request) {
        return session.send("Accessibility.getPartialAXTree", request, jpuppeteer.cdp.client.entity.accessibility.GetPartialAXTreeResponse.class);
    }


    /**
    * Fetches the entire accessibility tree
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.accessibility.GetFullAXTreeResponse> getFullAXTree() {
        return session.send("Accessibility.getFullAXTree", null, jpuppeteer.cdp.client.entity.accessibility.GetFullAXTreeResponse.class);
    }

}