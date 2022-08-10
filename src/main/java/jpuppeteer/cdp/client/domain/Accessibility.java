package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Accessibility {

    private jpuppeteer.cdp.CDPConnection connection;

    public Accessibility(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables the accessibility domain.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Accessibility.disable", null);
    }


    /**
    * Enables the accessibility domain which causes `AXNodeId`s to remain consistent between method calls. This turns on accessibility for the page, which can impact performance until accessibility is disabled.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("Accessibility.enable", null);
    }


    /**
    * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.accessibility.GetPartialAXTreeResponse> getPartialAXTree(jpuppeteer.cdp.client.entity.accessibility.GetPartialAXTreeRequest request) {
        return connection.send("Accessibility.getPartialAXTree", request, jpuppeteer.cdp.client.entity.accessibility.GetPartialAXTreeResponse.class);
    }


    /**
    * Fetches the entire accessibility tree for the root Document
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.accessibility.GetFullAXTreeResponse> getFullAXTree(jpuppeteer.cdp.client.entity.accessibility.GetFullAXTreeRequest request) {
        return connection.send("Accessibility.getFullAXTree", request, jpuppeteer.cdp.client.entity.accessibility.GetFullAXTreeResponse.class);
    }


    /**
    * Fetches a particular accessibility node by AXNodeId. Requires `enable()` to have been called previously.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.accessibility.GetChildAXNodesResponse> getChildAXNodes(jpuppeteer.cdp.client.entity.accessibility.GetChildAXNodesRequest request) {
        return connection.send("Accessibility.getChildAXNodes", request, jpuppeteer.cdp.client.entity.accessibility.GetChildAXNodesResponse.class);
    }


    /**
    * Query a DOM node's accessibility subtree for accessible name and role. This command computes the name and role for all nodes in the subtree, including those that are ignored for accessibility, and returns those that mactch the specified name and role. If no DOM node is specified, or the DOM node does not exist, the command returns an error. If neither `accessibleName` or `role` is specified, it returns all the accessibility nodes in the subtree.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.accessibility.QueryAXTreeResponse> queryAXTree(jpuppeteer.cdp.client.entity.accessibility.QueryAXTreeRequest request) {
        return connection.send("Accessibility.queryAXTree", request, jpuppeteer.cdp.client.entity.accessibility.QueryAXTreeResponse.class);
    }

}