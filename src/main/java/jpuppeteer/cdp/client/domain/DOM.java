package jpuppeteer.cdp.client.domain;

/**
*/
public class DOM {

    private jpuppeteer.cdp.CDPConnection connection;

    public DOM(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Collects class names for the node with given id and all of it's child nodes.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.CollectClassNamesFromSubtreeResponse> collectClassNamesFromSubtree(jpuppeteer.cdp.client.entity.dom.CollectClassNamesFromSubtreeRequest request) {
        return connection.send("DOM.collectClassNamesFromSubtree", request, jpuppeteer.cdp.client.entity.dom.CollectClassNamesFromSubtreeResponse.class);
    }


    /**
    * Creates a deep copy of the specified node and places it into the target container before the given anchor.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.CopyToResponse> copyTo(jpuppeteer.cdp.client.entity.dom.CopyToRequest request) {
        return connection.send("DOM.copyTo", request, jpuppeteer.cdp.client.entity.dom.CopyToResponse.class);
    }


    /**
    * Describes node given its id, does not require domain to be enabled. Does not start tracking any objects, can be used for automation.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.DescribeNodeResponse> describeNode(jpuppeteer.cdp.client.entity.dom.DescribeNodeRequest request) {
        return connection.send("DOM.describeNode", request, jpuppeteer.cdp.client.entity.dom.DescribeNodeResponse.class);
    }


    /**
    * Scrolls the specified rect of the given node into view if not already visible. Note: exactly one between nodeId, backendNodeId and objectId should be passed to identify the node.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> scrollIntoViewIfNeeded(jpuppeteer.cdp.client.entity.dom.ScrollIntoViewIfNeededRequest request) {
        return connection.send("DOM.scrollIntoViewIfNeeded", request);
    }


    /**
    * Disables DOM agent for the given page.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("DOM.disable", null);
    }


    /**
    * Discards search results from the session with the given id. `getSearchResults` should no longer be called for that search.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> discardSearchResults(jpuppeteer.cdp.client.entity.dom.DiscardSearchResultsRequest request) {
        return connection.send("DOM.discardSearchResults", request);
    }


    /**
    * Enables DOM agent for the given page.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("DOM.enable", null);
    }


    /**
    * Focuses the given element.
    */
    public jpuppeteer.util.XFuture<?> focus(jpuppeteer.cdp.client.entity.dom.FocusRequest request) {
        return connection.send("DOM.focus", request);
    }


    /**
    * Returns attributes for the specified node.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetAttributesResponse> getAttributes(jpuppeteer.cdp.client.entity.dom.GetAttributesRequest request) {
        return connection.send("DOM.getAttributes", request, jpuppeteer.cdp.client.entity.dom.GetAttributesResponse.class);
    }


    /**
    * Returns boxes for the given node.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetBoxModelResponse> getBoxModel(jpuppeteer.cdp.client.entity.dom.GetBoxModelRequest request) {
        return connection.send("DOM.getBoxModel", request, jpuppeteer.cdp.client.entity.dom.GetBoxModelResponse.class);
    }


    /**
    * Returns quads that describe node position on the page. This method might return multiple quads for inline nodes.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetContentQuadsResponse> getContentQuads(jpuppeteer.cdp.client.entity.dom.GetContentQuadsRequest request) {
        return connection.send("DOM.getContentQuads", request, jpuppeteer.cdp.client.entity.dom.GetContentQuadsResponse.class);
    }


    /**
    * Returns the root DOM node (and optionally the subtree) to the caller.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetDocumentResponse> getDocument(jpuppeteer.cdp.client.entity.dom.GetDocumentRequest request) {
        return connection.send("DOM.getDocument", request, jpuppeteer.cdp.client.entity.dom.GetDocumentResponse.class);
    }


    /**
    * Returns the root DOM node (and optionally the subtree) to the caller. Deprecated, as it is not designed to work well with the rest of the DOM agent. Use DOMSnapshot.captureSnapshot instead.
    */
    @java.lang.Deprecated
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetFlattenedDocumentResponse> getFlattenedDocument(jpuppeteer.cdp.client.entity.dom.GetFlattenedDocumentRequest request) {
        return connection.send("DOM.getFlattenedDocument", request, jpuppeteer.cdp.client.entity.dom.GetFlattenedDocumentResponse.class);
    }


    /**
    * Finds nodes with a given computed style in a subtree.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetNodesForSubtreeByStyleResponse> getNodesForSubtreeByStyle(jpuppeteer.cdp.client.entity.dom.GetNodesForSubtreeByStyleRequest request) {
        return connection.send("DOM.getNodesForSubtreeByStyle", request, jpuppeteer.cdp.client.entity.dom.GetNodesForSubtreeByStyleResponse.class);
    }


    /**
    * Returns node id at given location. Depending on whether DOM domain is enabled, nodeId is either returned or not.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetNodeForLocationResponse> getNodeForLocation(jpuppeteer.cdp.client.entity.dom.GetNodeForLocationRequest request) {
        return connection.send("DOM.getNodeForLocation", request, jpuppeteer.cdp.client.entity.dom.GetNodeForLocationResponse.class);
    }


    /**
    * Returns node's HTML markup.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetOuterHTMLResponse> getOuterHTML(jpuppeteer.cdp.client.entity.dom.GetOuterHTMLRequest request) {
        return connection.send("DOM.getOuterHTML", request, jpuppeteer.cdp.client.entity.dom.GetOuterHTMLResponse.class);
    }


    /**
    * Returns the id of the nearest ancestor that is a relayout boundary.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetRelayoutBoundaryResponse> getRelayoutBoundary(jpuppeteer.cdp.client.entity.dom.GetRelayoutBoundaryRequest request) {
        return connection.send("DOM.getRelayoutBoundary", request, jpuppeteer.cdp.client.entity.dom.GetRelayoutBoundaryResponse.class);
    }


    /**
    * Returns search results from given `fromIndex` to given `toIndex` from the search with the given identifier.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetSearchResultsResponse> getSearchResults(jpuppeteer.cdp.client.entity.dom.GetSearchResultsRequest request) {
        return connection.send("DOM.getSearchResults", request, jpuppeteer.cdp.client.entity.dom.GetSearchResultsResponse.class);
    }


    /**
    * Hides any highlight.
    */
    public jpuppeteer.util.XFuture<?> hideHighlight() {
        return connection.send("DOM.hideHighlight", null);
    }


    /**
    * Highlights DOM node.
    */
    public jpuppeteer.util.XFuture<?> highlightNode() {
        return connection.send("DOM.highlightNode", null);
    }


    /**
    * Highlights given rectangle.
    */
    public jpuppeteer.util.XFuture<?> highlightRect() {
        return connection.send("DOM.highlightRect", null);
    }


    /**
    * Marks last undoable state.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> markUndoableState() {
        return connection.send("DOM.markUndoableState", null);
    }


    /**
    * Moves node into the new container, places it before the given anchor.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.MoveToResponse> moveTo(jpuppeteer.cdp.client.entity.dom.MoveToRequest request) {
        return connection.send("DOM.moveTo", request, jpuppeteer.cdp.client.entity.dom.MoveToResponse.class);
    }


    /**
    * Searches for a given string in the DOM tree. Use `getSearchResults` to access search results or `cancelSearch` to end this search session.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.PerformSearchResponse> performSearch(jpuppeteer.cdp.client.entity.dom.PerformSearchRequest request) {
        return connection.send("DOM.performSearch", request, jpuppeteer.cdp.client.entity.dom.PerformSearchResponse.class);
    }


    /**
    * Requests that the node is sent to the caller given its path. // FIXME, use XPath
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.PushNodeByPathToFrontendResponse> pushNodeByPathToFrontend(jpuppeteer.cdp.client.entity.dom.PushNodeByPathToFrontendRequest request) {
        return connection.send("DOM.pushNodeByPathToFrontend", request, jpuppeteer.cdp.client.entity.dom.PushNodeByPathToFrontendResponse.class);
    }


    /**
    * Requests that a batch of nodes is sent to the caller given their backend node ids.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.PushNodesByBackendIdsToFrontendResponse> pushNodesByBackendIdsToFrontend(jpuppeteer.cdp.client.entity.dom.PushNodesByBackendIdsToFrontendRequest request) {
        return connection.send("DOM.pushNodesByBackendIdsToFrontend", request, jpuppeteer.cdp.client.entity.dom.PushNodesByBackendIdsToFrontendResponse.class);
    }


    /**
    * Executes `querySelector` on a given node.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.QuerySelectorResponse> querySelector(jpuppeteer.cdp.client.entity.dom.QuerySelectorRequest request) {
        return connection.send("DOM.querySelector", request, jpuppeteer.cdp.client.entity.dom.QuerySelectorResponse.class);
    }


    /**
    * Executes `querySelectorAll` on a given node.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.QuerySelectorAllResponse> querySelectorAll(jpuppeteer.cdp.client.entity.dom.QuerySelectorAllRequest request) {
        return connection.send("DOM.querySelectorAll", request, jpuppeteer.cdp.client.entity.dom.QuerySelectorAllResponse.class);
    }


    /**
    * Re-does the last undone action.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> redo() {
        return connection.send("DOM.redo", null);
    }


    /**
    * Removes attribute with given name from an element with given id.
    */
    public jpuppeteer.util.XFuture<?> removeAttribute(jpuppeteer.cdp.client.entity.dom.RemoveAttributeRequest request) {
        return connection.send("DOM.removeAttribute", request);
    }


    /**
    * Removes node with given id.
    */
    public jpuppeteer.util.XFuture<?> removeNode(jpuppeteer.cdp.client.entity.dom.RemoveNodeRequest request) {
        return connection.send("DOM.removeNode", request);
    }


    /**
    * Requests that children of the node with given id are returned to the caller in form of `setChildNodes` events where not only immediate children are retrieved, but all children down to the specified depth.
    */
    public jpuppeteer.util.XFuture<?> requestChildNodes(jpuppeteer.cdp.client.entity.dom.RequestChildNodesRequest request) {
        return connection.send("DOM.requestChildNodes", request);
    }


    /**
    * Requests that the node is sent to the caller given the JavaScript node object reference. All nodes that form the path from the node to the root are also sent to the client as a series of `setChildNodes` notifications.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.RequestNodeResponse> requestNode(jpuppeteer.cdp.client.entity.dom.RequestNodeRequest request) {
        return connection.send("DOM.requestNode", request, jpuppeteer.cdp.client.entity.dom.RequestNodeResponse.class);
    }


    /**
    * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.ResolveNodeResponse> resolveNode(jpuppeteer.cdp.client.entity.dom.ResolveNodeRequest request) {
        return connection.send("DOM.resolveNode", request, jpuppeteer.cdp.client.entity.dom.ResolveNodeResponse.class);
    }


    /**
    * Sets attribute for an element with given id.
    */
    public jpuppeteer.util.XFuture<?> setAttributeValue(jpuppeteer.cdp.client.entity.dom.SetAttributeValueRequest request) {
        return connection.send("DOM.setAttributeValue", request);
    }


    /**
    * Sets attributes on element with given id. This method is useful when user edits some existing attribute value and types in several attribute name/value pairs.
    */
    public jpuppeteer.util.XFuture<?> setAttributesAsText(jpuppeteer.cdp.client.entity.dom.SetAttributesAsTextRequest request) {
        return connection.send("DOM.setAttributesAsText", request);
    }


    /**
    * Sets files for the given file input element.
    */
    public jpuppeteer.util.XFuture<?> setFileInputFiles(jpuppeteer.cdp.client.entity.dom.SetFileInputFilesRequest request) {
        return connection.send("DOM.setFileInputFiles", request);
    }


    /**
    * Sets if stack traces should be captured for Nodes. See `Node.getNodeStackTraces`. Default is disabled.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setNodeStackTracesEnabled(jpuppeteer.cdp.client.entity.dom.SetNodeStackTracesEnabledRequest request) {
        return connection.send("DOM.setNodeStackTracesEnabled", request);
    }


    /**
    * Gets stack traces associated with a Node. As of now, only provides stack trace for Node creation.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetNodeStackTracesResponse> getNodeStackTraces(jpuppeteer.cdp.client.entity.dom.GetNodeStackTracesRequest request) {
        return connection.send("DOM.getNodeStackTraces", request, jpuppeteer.cdp.client.entity.dom.GetNodeStackTracesResponse.class);
    }


    /**
    * Returns file information for the given File wrapper.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetFileInfoResponse> getFileInfo(jpuppeteer.cdp.client.entity.dom.GetFileInfoRequest request) {
        return connection.send("DOM.getFileInfo", request, jpuppeteer.cdp.client.entity.dom.GetFileInfoResponse.class);
    }


    /**
    * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setInspectedNode(jpuppeteer.cdp.client.entity.dom.SetInspectedNodeRequest request) {
        return connection.send("DOM.setInspectedNode", request);
    }


    /**
    * Sets node name for a node with given id.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.SetNodeNameResponse> setNodeName(jpuppeteer.cdp.client.entity.dom.SetNodeNameRequest request) {
        return connection.send("DOM.setNodeName", request, jpuppeteer.cdp.client.entity.dom.SetNodeNameResponse.class);
    }


    /**
    * Sets node value for a node with given id.
    */
    public jpuppeteer.util.XFuture<?> setNodeValue(jpuppeteer.cdp.client.entity.dom.SetNodeValueRequest request) {
        return connection.send("DOM.setNodeValue", request);
    }


    /**
    * Sets node HTML markup, returns new node id.
    */
    public jpuppeteer.util.XFuture<?> setOuterHTML(jpuppeteer.cdp.client.entity.dom.SetOuterHTMLRequest request) {
        return connection.send("DOM.setOuterHTML", request);
    }


    /**
    * Undoes the last performed action.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> undo() {
        return connection.send("DOM.undo", null);
    }


    /**
    * Returns iframe node that owns iframe with the given domain.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.dom.GetFrameOwnerResponse> getFrameOwner(jpuppeteer.cdp.client.entity.dom.GetFrameOwnerRequest request) {
        return connection.send("DOM.getFrameOwner", request, jpuppeteer.cdp.client.entity.dom.GetFrameOwnerResponse.class);
    }

}