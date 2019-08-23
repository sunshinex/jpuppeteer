package jpuppeteer.cdp.cdp.domain;

/**
*/
public class DOM {

    private jpuppeteer.cdp.CDPSession session;

    public DOM(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Collects class names for the node with given id and all of it's child nodes.
    */
    public jpuppeteer.cdp.cdp.entity.dom.CollectClassNamesFromSubtreeResponse collectClassNamesFromSubtree(jpuppeteer.cdp.cdp.entity.dom.CollectClassNamesFromSubtreeRequest request, int timeout) throws Exception {
        return session.send("DOM.collectClassNamesFromSubtree", request, jpuppeteer.cdp.cdp.entity.dom.CollectClassNamesFromSubtreeResponse.class, timeout);
    }


    /**
    * Creates a deep copy of the specified node and places it into the target container before the given anchor.
    */
    public jpuppeteer.cdp.cdp.entity.dom.CopyToResponse copyTo(jpuppeteer.cdp.cdp.entity.dom.CopyToRequest request, int timeout) throws Exception {
        return session.send("DOM.copyTo", request, jpuppeteer.cdp.cdp.entity.dom.CopyToResponse.class, timeout);
    }


    /**
    * Describes node given its id, does not require domain to be enabled. Does not start tracking any objects, can be used for automation.
    */
    public jpuppeteer.cdp.cdp.entity.dom.DescribeNodeResponse describeNode(jpuppeteer.cdp.cdp.entity.dom.DescribeNodeRequest request, int timeout) throws Exception {
        return session.send("DOM.describeNode", request, jpuppeteer.cdp.cdp.entity.dom.DescribeNodeResponse.class, timeout);
    }


    /**
    * Disables DOM agent for the given page.
    */
    public void disable(int timeout) throws Exception {
        session.send("DOM.disable", null, timeout);
    }


    /**
    * Discards search results from the session with the given id. `getSearchResults` should no longer be called for that search.
    */
    public void discardSearchResults(jpuppeteer.cdp.cdp.entity.dom.DiscardSearchResultsRequest request, int timeout) throws Exception {
        session.send("DOM.discardSearchResults", request, timeout);
    }


    /**
    * Enables DOM agent for the given page.
    */
    public void enable(int timeout) throws Exception {
        session.send("DOM.enable", null, timeout);
    }


    /**
    * Focuses the given element.
    */
    public void focus(jpuppeteer.cdp.cdp.entity.dom.FocusRequest request, int timeout) throws Exception {
        session.send("DOM.focus", request, timeout);
    }


    /**
    * Returns attributes for the specified node.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetAttributesResponse getAttributes(jpuppeteer.cdp.cdp.entity.dom.GetAttributesRequest request, int timeout) throws Exception {
        return session.send("DOM.getAttributes", request, jpuppeteer.cdp.cdp.entity.dom.GetAttributesResponse.class, timeout);
    }


    /**
    * Returns boxes for the given node.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetBoxModelResponse getBoxModel(jpuppeteer.cdp.cdp.entity.dom.GetBoxModelRequest request, int timeout) throws Exception {
        return session.send("DOM.getBoxModel", request, jpuppeteer.cdp.cdp.entity.dom.GetBoxModelResponse.class, timeout);
    }


    /**
    * Returns quads that describe node position on the page. This method might return multiple quads for inline nodes.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetContentQuadsResponse getContentQuads(jpuppeteer.cdp.cdp.entity.dom.GetContentQuadsRequest request, int timeout) throws Exception {
        return session.send("DOM.getContentQuads", request, jpuppeteer.cdp.cdp.entity.dom.GetContentQuadsResponse.class, timeout);
    }


    /**
    * Returns the root DOM node (and optionally the subtree) to the caller.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetDocumentResponse getDocument(jpuppeteer.cdp.cdp.entity.dom.GetDocumentRequest request, int timeout) throws Exception {
        return session.send("DOM.getDocument", request, jpuppeteer.cdp.cdp.entity.dom.GetDocumentResponse.class, timeout);
    }


    /**
    * Returns the root DOM node (and optionally the subtree) to the caller.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetFlattenedDocumentResponse getFlattenedDocument(jpuppeteer.cdp.cdp.entity.dom.GetFlattenedDocumentRequest request, int timeout) throws Exception {
        return session.send("DOM.getFlattenedDocument", request, jpuppeteer.cdp.cdp.entity.dom.GetFlattenedDocumentResponse.class, timeout);
    }


    /**
    * Returns node id at given location. Depending on whether DOM domain is enabled, nodeId is either returned or not.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetNodeForLocationResponse getNodeForLocation(jpuppeteer.cdp.cdp.entity.dom.GetNodeForLocationRequest request, int timeout) throws Exception {
        return session.send("DOM.getNodeForLocation", request, jpuppeteer.cdp.cdp.entity.dom.GetNodeForLocationResponse.class, timeout);
    }


    /**
    * Returns node's HTML markup.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetOuterHTMLResponse getOuterHTML(jpuppeteer.cdp.cdp.entity.dom.GetOuterHTMLRequest request, int timeout) throws Exception {
        return session.send("DOM.getOuterHTML", request, jpuppeteer.cdp.cdp.entity.dom.GetOuterHTMLResponse.class, timeout);
    }


    /**
    * Returns the id of the nearest ancestor that is a relayout boundary.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetRelayoutBoundaryResponse getRelayoutBoundary(jpuppeteer.cdp.cdp.entity.dom.GetRelayoutBoundaryRequest request, int timeout) throws Exception {
        return session.send("DOM.getRelayoutBoundary", request, jpuppeteer.cdp.cdp.entity.dom.GetRelayoutBoundaryResponse.class, timeout);
    }


    /**
    * Returns search results from given `fromIndex` to given `toIndex` from the search with the given identifier.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetSearchResultsResponse getSearchResults(jpuppeteer.cdp.cdp.entity.dom.GetSearchResultsRequest request, int timeout) throws Exception {
        return session.send("DOM.getSearchResults", request, jpuppeteer.cdp.cdp.entity.dom.GetSearchResultsResponse.class, timeout);
    }


    /**
    * Hides any highlight.
    */
    public void hideHighlight(int timeout) throws Exception {
        session.send("DOM.hideHighlight", null, timeout);
    }


    /**
    * Highlights DOM node.
    */
    public void highlightNode(int timeout) throws Exception {
        session.send("DOM.highlightNode", null, timeout);
    }


    /**
    * Highlights given rectangle.
    */
    public void highlightRect(int timeout) throws Exception {
        session.send("DOM.highlightRect", null, timeout);
    }


    /**
    * Marks last undoable state.
    */
    public void markUndoableState(int timeout) throws Exception {
        session.send("DOM.markUndoableState", null, timeout);
    }


    /**
    * Moves node into the new container, places it before the given anchor.
    */
    public jpuppeteer.cdp.cdp.entity.dom.MoveToResponse moveTo(jpuppeteer.cdp.cdp.entity.dom.MoveToRequest request, int timeout) throws Exception {
        return session.send("DOM.moveTo", request, jpuppeteer.cdp.cdp.entity.dom.MoveToResponse.class, timeout);
    }


    /**
    * Searches for a given string in the DOM tree. Use `getSearchResults` to access search results or `cancelSearch` to end this search session.
    */
    public jpuppeteer.cdp.cdp.entity.dom.PerformSearchResponse performSearch(jpuppeteer.cdp.cdp.entity.dom.PerformSearchRequest request, int timeout) throws Exception {
        return session.send("DOM.performSearch", request, jpuppeteer.cdp.cdp.entity.dom.PerformSearchResponse.class, timeout);
    }


    /**
    * Requests that the node is sent to the caller given its path. // FIXME, use XPath
    */
    public jpuppeteer.cdp.cdp.entity.dom.PushNodeByPathToFrontendResponse pushNodeByPathToFrontend(jpuppeteer.cdp.cdp.entity.dom.PushNodeByPathToFrontendRequest request, int timeout) throws Exception {
        return session.send("DOM.pushNodeByPathToFrontend", request, jpuppeteer.cdp.cdp.entity.dom.PushNodeByPathToFrontendResponse.class, timeout);
    }


    /**
    * Requests that a batch of nodes is sent to the caller given their backend node ids.
    */
    public jpuppeteer.cdp.cdp.entity.dom.PushNodesByBackendIdsToFrontendResponse pushNodesByBackendIdsToFrontend(jpuppeteer.cdp.cdp.entity.dom.PushNodesByBackendIdsToFrontendRequest request, int timeout) throws Exception {
        return session.send("DOM.pushNodesByBackendIdsToFrontend", request, jpuppeteer.cdp.cdp.entity.dom.PushNodesByBackendIdsToFrontendResponse.class, timeout);
    }


    /**
    * Executes `querySelector` on a given node.
    */
    public jpuppeteer.cdp.cdp.entity.dom.QuerySelectorResponse querySelector(jpuppeteer.cdp.cdp.entity.dom.QuerySelectorRequest request, int timeout) throws Exception {
        return session.send("DOM.querySelector", request, jpuppeteer.cdp.cdp.entity.dom.QuerySelectorResponse.class, timeout);
    }


    /**
    * Executes `querySelectorAll` on a given node.
    */
    public jpuppeteer.cdp.cdp.entity.dom.QuerySelectorAllResponse querySelectorAll(jpuppeteer.cdp.cdp.entity.dom.QuerySelectorAllRequest request, int timeout) throws Exception {
        return session.send("DOM.querySelectorAll", request, jpuppeteer.cdp.cdp.entity.dom.QuerySelectorAllResponse.class, timeout);
    }


    /**
    * Re-does the last undone action.
    */
    public void redo(int timeout) throws Exception {
        session.send("DOM.redo", null, timeout);
    }


    /**
    * Removes attribute with given name from an element with given id.
    */
    public void removeAttribute(jpuppeteer.cdp.cdp.entity.dom.RemoveAttributeRequest request, int timeout) throws Exception {
        session.send("DOM.removeAttribute", request, timeout);
    }


    /**
    * Removes node with given id.
    */
    public void removeNode(jpuppeteer.cdp.cdp.entity.dom.RemoveNodeRequest request, int timeout) throws Exception {
        session.send("DOM.removeNode", request, timeout);
    }


    /**
    * Requests that children of the node with given id are returned to the caller in form of `setChildNodes` events where not only immediate children are retrieved, but all children down to the specified depth.
    */
    public void requestChildNodes(jpuppeteer.cdp.cdp.entity.dom.RequestChildNodesRequest request, int timeout) throws Exception {
        session.send("DOM.requestChildNodes", request, timeout);
    }


    /**
    * Requests that the node is sent to the caller given the JavaScript node object reference. All nodes that form the path from the node to the root are also sent to the client as a series of `setChildNodes` notifications.
    */
    public jpuppeteer.cdp.cdp.entity.dom.RequestNodeResponse requestNode(jpuppeteer.cdp.cdp.entity.dom.RequestNodeRequest request, int timeout) throws Exception {
        return session.send("DOM.requestNode", request, jpuppeteer.cdp.cdp.entity.dom.RequestNodeResponse.class, timeout);
    }


    /**
    * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
    */
    public jpuppeteer.cdp.cdp.entity.dom.ResolveNodeResponse resolveNode(jpuppeteer.cdp.cdp.entity.dom.ResolveNodeRequest request, int timeout) throws Exception {
        return session.send("DOM.resolveNode", request, jpuppeteer.cdp.cdp.entity.dom.ResolveNodeResponse.class, timeout);
    }


    /**
    * Sets attribute for an element with given id.
    */
    public void setAttributeValue(jpuppeteer.cdp.cdp.entity.dom.SetAttributeValueRequest request, int timeout) throws Exception {
        session.send("DOM.setAttributeValue", request, timeout);
    }


    /**
    * Sets attributes on element with given id. This method is useful when user edits some existing attribute value and types in several attribute name/value pairs.
    */
    public void setAttributesAsText(jpuppeteer.cdp.cdp.entity.dom.SetAttributesAsTextRequest request, int timeout) throws Exception {
        session.send("DOM.setAttributesAsText", request, timeout);
    }


    /**
    * Sets files for the given file input element.
    */
    public void setFileInputFiles(jpuppeteer.cdp.cdp.entity.dom.SetFileInputFilesRequest request, int timeout) throws Exception {
        session.send("DOM.setFileInputFiles", request, timeout);
    }


    /**
    * Sets if stack traces should be captured for Nodes. See `Node.getNodeStackTraces`. Default is disabled.
    */
    public void setNodeStackTracesEnabled(jpuppeteer.cdp.cdp.entity.dom.SetNodeStackTracesEnabledRequest request, int timeout) throws Exception {
        session.send("DOM.setNodeStackTracesEnabled", request, timeout);
    }


    /**
    * Gets stack traces associated with a Node. As of now, only provides stack trace for Node creation.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetNodeStackTracesResponse getNodeStackTraces(jpuppeteer.cdp.cdp.entity.dom.GetNodeStackTracesRequest request, int timeout) throws Exception {
        return session.send("DOM.getNodeStackTraces", request, jpuppeteer.cdp.cdp.entity.dom.GetNodeStackTracesResponse.class, timeout);
    }


    /**
    * Returns file information for the given File wrapper.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetFileInfoResponse getFileInfo(jpuppeteer.cdp.cdp.entity.dom.GetFileInfoRequest request, int timeout) throws Exception {
        return session.send("DOM.getFileInfo", request, jpuppeteer.cdp.cdp.entity.dom.GetFileInfoResponse.class, timeout);
    }


    /**
    * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
    */
    public void setInspectedNode(jpuppeteer.cdp.cdp.entity.dom.SetInspectedNodeRequest request, int timeout) throws Exception {
        session.send("DOM.setInspectedNode", request, timeout);
    }


    /**
    * Sets node name for a node with given id.
    */
    public jpuppeteer.cdp.cdp.entity.dom.SetNodeNameResponse setNodeName(jpuppeteer.cdp.cdp.entity.dom.SetNodeNameRequest request, int timeout) throws Exception {
        return session.send("DOM.setNodeName", request, jpuppeteer.cdp.cdp.entity.dom.SetNodeNameResponse.class, timeout);
    }


    /**
    * Sets node value for a node with given id.
    */
    public void setNodeValue(jpuppeteer.cdp.cdp.entity.dom.SetNodeValueRequest request, int timeout) throws Exception {
        session.send("DOM.setNodeValue", request, timeout);
    }


    /**
    * Sets node HTML markup, returns new node id.
    */
    public void setOuterHTML(jpuppeteer.cdp.cdp.entity.dom.SetOuterHTMLRequest request, int timeout) throws Exception {
        session.send("DOM.setOuterHTML", request, timeout);
    }


    /**
    * Undoes the last performed action.
    */
    public void undo(int timeout) throws Exception {
        session.send("DOM.undo", null, timeout);
    }


    /**
    * Returns iframe node that owns iframe with the given domain.
    */
    public jpuppeteer.cdp.cdp.entity.dom.GetFrameOwnerResponse getFrameOwner(jpuppeteer.cdp.cdp.entity.dom.GetFrameOwnerRequest request, int timeout) throws Exception {
        return session.send("DOM.getFrameOwner", request, jpuppeteer.cdp.cdp.entity.dom.GetFrameOwnerResponse.class, timeout);
    }

}