package jpuppeteer.cdp.client;

public enum CDPEventType {

    /**
    * Event for when an animation has been cancelled.
    * @see jpuppeteer.cdp.client.entity.animation.AnimationCanceledEvent
    */
    ANIMATION_ANIMATIONCANCELED("Animation.animationCanceled", jpuppeteer.cdp.client.entity.animation.AnimationCanceledEvent.class),

    /**
    * Event for each animation that has been created.
    * @see jpuppeteer.cdp.client.entity.animation.AnimationCreatedEvent
    */
    ANIMATION_ANIMATIONCREATED("Animation.animationCreated", jpuppeteer.cdp.client.entity.animation.AnimationCreatedEvent.class),

    /**
    * Event for animation that has been started.
    * @see jpuppeteer.cdp.client.entity.animation.AnimationStartedEvent
    */
    ANIMATION_ANIMATIONSTARTED("Animation.animationStarted", jpuppeteer.cdp.client.entity.animation.AnimationStartedEvent.class),

    APPLICATIONCACHE_APPLICATIONCACHESTATUSUPDATED("ApplicationCache.applicationCacheStatusUpdated", jpuppeteer.cdp.client.entity.applicationcache.ApplicationCacheStatusUpdatedEvent.class),

    APPLICATIONCACHE_NETWORKSTATEUPDATED("ApplicationCache.networkStateUpdated", jpuppeteer.cdp.client.entity.applicationcache.NetworkStateUpdatedEvent.class),

    AUDITS_ISSUEADDED("Audits.issueAdded", jpuppeteer.cdp.client.entity.audits.IssueAddedEvent.class),

    /**
    * Called when the recording state for the service has been updated.
    * @see jpuppeteer.cdp.client.entity.backgroundservice.RecordingStateChangedEvent
    */
    BACKGROUNDSERVICE_RECORDINGSTATECHANGED("BackgroundService.recordingStateChanged", jpuppeteer.cdp.client.entity.backgroundservice.RecordingStateChangedEvent.class),

    /**
    * Called with all existing backgroundServiceEvents when enabled, and all new events afterwards if enabled and recording.
    * @see jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEventReceivedEvent
    */
    BACKGROUNDSERVICE_BACKGROUNDSERVICEEVENTRECEIVED("BackgroundService.backgroundServiceEventReceived", jpuppeteer.cdp.client.entity.backgroundservice.BackgroundServiceEventReceivedEvent.class),

    /**
    * Fired when page is about to start a download.
    * @see jpuppeteer.cdp.client.entity.browser.DownloadWillBeginEvent
    */
    BROWSER_DOWNLOADWILLBEGIN("Browser.downloadWillBegin", jpuppeteer.cdp.client.entity.browser.DownloadWillBeginEvent.class),

    /**
    * Fired when download makes progress. Last call has |done| == true.
    * @see jpuppeteer.cdp.client.entity.browser.DownloadProgressEvent
    */
    BROWSER_DOWNLOADPROGRESS("Browser.downloadProgress", jpuppeteer.cdp.client.entity.browser.DownloadProgressEvent.class),

    /**
    * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded web font
    * @see jpuppeteer.cdp.client.entity.css.FontsUpdatedEvent
    */
    CSS_FONTSUPDATED("CSS.fontsUpdated", jpuppeteer.cdp.client.entity.css.FontsUpdatedEvent.class),

    CSS_MEDIAQUERYRESULTCHANGED("CSS.mediaQueryResultChanged", null),

    /**
    * Fired whenever an active document stylesheet is added.
    * @see jpuppeteer.cdp.client.entity.css.StyleSheetAddedEvent
    */
    CSS_STYLESHEETADDED("CSS.styleSheetAdded", jpuppeteer.cdp.client.entity.css.StyleSheetAddedEvent.class),

    /**
    * Fired whenever a stylesheet is changed as a result of the client operation.
    * @see jpuppeteer.cdp.client.entity.css.StyleSheetChangedEvent
    */
    CSS_STYLESHEETCHANGED("CSS.styleSheetChanged", jpuppeteer.cdp.client.entity.css.StyleSheetChangedEvent.class),

    /**
    * Fired whenever an active document stylesheet is removed.
    * @see jpuppeteer.cdp.client.entity.css.StyleSheetRemovedEvent
    */
    CSS_STYLESHEETREMOVED("CSS.styleSheetRemoved", jpuppeteer.cdp.client.entity.css.StyleSheetRemovedEvent.class),

    /**
    * This is fired whenever the list of available sinks changes. A sink is a device or a software surface that you can cast to.
    * @see jpuppeteer.cdp.client.entity.cast.SinksUpdatedEvent
    */
    CAST_SINKSUPDATED("Cast.sinksUpdated", jpuppeteer.cdp.client.entity.cast.SinksUpdatedEvent.class),

    /**
    * This is fired whenever the outstanding issue/error message changes. |issueMessage| is empty if there is no issue.
    * @see jpuppeteer.cdp.client.entity.cast.IssueUpdatedEvent
    */
    CAST_ISSUEUPDATED("Cast.issueUpdated", jpuppeteer.cdp.client.entity.cast.IssueUpdatedEvent.class),

    /**
    * Fired when `Element`'s attribute is modified.
    * @see jpuppeteer.cdp.client.entity.dom.AttributeModifiedEvent
    */
    DOM_ATTRIBUTEMODIFIED("DOM.attributeModified", jpuppeteer.cdp.client.entity.dom.AttributeModifiedEvent.class),

    /**
    * Fired when `Element`'s attribute is removed.
    * @see jpuppeteer.cdp.client.entity.dom.AttributeRemovedEvent
    */
    DOM_ATTRIBUTEREMOVED("DOM.attributeRemoved", jpuppeteer.cdp.client.entity.dom.AttributeRemovedEvent.class),

    /**
    * Mirrors `DOMCharacterDataModified` event.
    * @see jpuppeteer.cdp.client.entity.dom.CharacterDataModifiedEvent
    */
    DOM_CHARACTERDATAMODIFIED("DOM.characterDataModified", jpuppeteer.cdp.client.entity.dom.CharacterDataModifiedEvent.class),

    /**
    * Fired when `Container`'s child node count has changed.
    * @see jpuppeteer.cdp.client.entity.dom.ChildNodeCountUpdatedEvent
    */
    DOM_CHILDNODECOUNTUPDATED("DOM.childNodeCountUpdated", jpuppeteer.cdp.client.entity.dom.ChildNodeCountUpdatedEvent.class),

    /**
    * Mirrors `DOMNodeInserted` event.
    * @see jpuppeteer.cdp.client.entity.dom.ChildNodeInsertedEvent
    */
    DOM_CHILDNODEINSERTED("DOM.childNodeInserted", jpuppeteer.cdp.client.entity.dom.ChildNodeInsertedEvent.class),

    /**
    * Mirrors `DOMNodeRemoved` event.
    * @see jpuppeteer.cdp.client.entity.dom.ChildNodeRemovedEvent
    */
    DOM_CHILDNODEREMOVED("DOM.childNodeRemoved", jpuppeteer.cdp.client.entity.dom.ChildNodeRemovedEvent.class),

    /**
    * Called when distribution is changed.
    * @see jpuppeteer.cdp.client.entity.dom.DistributedNodesUpdatedEvent
    */
    DOM_DISTRIBUTEDNODESUPDATED("DOM.distributedNodesUpdated", jpuppeteer.cdp.client.entity.dom.DistributedNodesUpdatedEvent.class),

    DOM_DOCUMENTUPDATED("DOM.documentUpdated", null),

    /**
    * Fired when `Element`'s inline style is modified via a CSS property modification.
    * @see jpuppeteer.cdp.client.entity.dom.InlineStyleInvalidatedEvent
    */
    DOM_INLINESTYLEINVALIDATED("DOM.inlineStyleInvalidated", jpuppeteer.cdp.client.entity.dom.InlineStyleInvalidatedEvent.class),

    /**
    * Called when a pseudo element is added to an element.
    * @see jpuppeteer.cdp.client.entity.dom.PseudoElementAddedEvent
    */
    DOM_PSEUDOELEMENTADDED("DOM.pseudoElementAdded", jpuppeteer.cdp.client.entity.dom.PseudoElementAddedEvent.class),

    /**
    * Called when a pseudo element is removed from an element.
    * @see jpuppeteer.cdp.client.entity.dom.PseudoElementRemovedEvent
    */
    DOM_PSEUDOELEMENTREMOVED("DOM.pseudoElementRemoved", jpuppeteer.cdp.client.entity.dom.PseudoElementRemovedEvent.class),

    /**
    * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
    * @see jpuppeteer.cdp.client.entity.dom.SetChildNodesEvent
    */
    DOM_SETCHILDNODES("DOM.setChildNodes", jpuppeteer.cdp.client.entity.dom.SetChildNodesEvent.class),

    /**
    * Called when shadow root is popped from the element.
    * @see jpuppeteer.cdp.client.entity.dom.ShadowRootPoppedEvent
    */
    DOM_SHADOWROOTPOPPED("DOM.shadowRootPopped", jpuppeteer.cdp.client.entity.dom.ShadowRootPoppedEvent.class),

    /**
    * Called when shadow root is pushed into the element.
    * @see jpuppeteer.cdp.client.entity.dom.ShadowRootPushedEvent
    */
    DOM_SHADOWROOTPUSHED("DOM.shadowRootPushed", jpuppeteer.cdp.client.entity.dom.ShadowRootPushedEvent.class),

    DOMSTORAGE_DOMSTORAGEITEMADDED("DOMStorage.domStorageItemAdded", jpuppeteer.cdp.client.entity.domstorage.DomStorageItemAddedEvent.class),

    DOMSTORAGE_DOMSTORAGEITEMREMOVED("DOMStorage.domStorageItemRemoved", jpuppeteer.cdp.client.entity.domstorage.DomStorageItemRemovedEvent.class),

    DOMSTORAGE_DOMSTORAGEITEMUPDATED("DOMStorage.domStorageItemUpdated", jpuppeteer.cdp.client.entity.domstorage.DomStorageItemUpdatedEvent.class),

    DOMSTORAGE_DOMSTORAGEITEMSCLEARED("DOMStorage.domStorageItemsCleared", jpuppeteer.cdp.client.entity.domstorage.DomStorageItemsClearedEvent.class),

    DATABASE_ADDDATABASE("Database.addDatabase", jpuppeteer.cdp.client.entity.database.AddDatabaseEvent.class),

    EMULATION_VIRTUALTIMEBUDGETEXPIRED("Emulation.virtualTimeBudgetExpired", null),

    /**
    * Issued when the target starts or stops needing BeginFrames. Deprecated. Issue beginFrame unconditionally instead and use result from beginFrame to detect whether the frames were suppressed.
    * @see jpuppeteer.cdp.client.entity.headlessexperimental.NeedsBeginFramesChangedEvent
    */
    HEADLESSEXPERIMENTAL_NEEDSBEGINFRAMESCHANGED("HeadlessExperimental.needsBeginFramesChanged", jpuppeteer.cdp.client.entity.headlessexperimental.NeedsBeginFramesChangedEvent.class),

    /**
    * Emitted only when `Input.setInterceptDrags` is enabled. Use this data with `Input.dispatchDragEvent` to restore normal drag and drop behavior.
    * @see jpuppeteer.cdp.client.entity.input.DragInterceptedEvent
    */
    INPUT_DRAGINTERCEPTED("Input.dragIntercepted", jpuppeteer.cdp.client.entity.input.DragInterceptedEvent.class),

    /**
    * Fired when remote debugging connection is about to be terminated. Contains detach reason.
    * @see jpuppeteer.cdp.client.entity.inspector.DetachedEvent
    */
    INSPECTOR_DETACHED("Inspector.detached", jpuppeteer.cdp.client.entity.inspector.DetachedEvent.class),

    INSPECTOR_TARGETCRASHED("Inspector.targetCrashed", null),

    INSPECTOR_TARGETRELOADEDAFTERCRASH("Inspector.targetReloadedAfterCrash", null),

    LAYERTREE_LAYERPAINTED("LayerTree.layerPainted", jpuppeteer.cdp.client.entity.layertree.LayerPaintedEvent.class),

    LAYERTREE_LAYERTREEDIDCHANGE("LayerTree.layerTreeDidChange", jpuppeteer.cdp.client.entity.layertree.LayerTreeDidChangeEvent.class),

    /**
    * Issued when new message was logged.
    * @see jpuppeteer.cdp.client.entity.log.EntryAddedEvent
    */
    LOG_ENTRYADDED("Log.entryAdded", jpuppeteer.cdp.client.entity.log.EntryAddedEvent.class),

    /**
    * Fired when data chunk was received over the network.
    * @see jpuppeteer.cdp.client.entity.network.DataReceivedEvent
    */
    NETWORK_DATARECEIVED("Network.dataReceived", jpuppeteer.cdp.client.entity.network.DataReceivedEvent.class),

    /**
    * Fired when EventSource message is received.
    * @see jpuppeteer.cdp.client.entity.network.EventSourceMessageReceivedEvent
    */
    NETWORK_EVENTSOURCEMESSAGERECEIVED("Network.eventSourceMessageReceived", jpuppeteer.cdp.client.entity.network.EventSourceMessageReceivedEvent.class),

    /**
    * Fired when HTTP request has failed to load.
    * @see jpuppeteer.cdp.client.entity.network.LoadingFailedEvent
    */
    NETWORK_LOADINGFAILED("Network.loadingFailed", jpuppeteer.cdp.client.entity.network.LoadingFailedEvent.class),

    /**
    * Fired when HTTP request has finished loading.
    * @see jpuppeteer.cdp.client.entity.network.LoadingFinishedEvent
    */
    NETWORK_LOADINGFINISHED("Network.loadingFinished", jpuppeteer.cdp.client.entity.network.LoadingFinishedEvent.class),

    /**
    * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or mocked. Deprecated, use Fetch.requestPaused instead.
    * @see jpuppeteer.cdp.client.entity.network.RequestInterceptedEvent
    */
    NETWORK_REQUESTINTERCEPTED("Network.requestIntercepted", jpuppeteer.cdp.client.entity.network.RequestInterceptedEvent.class),

    /**
    * Fired if request ended up loading from cache.
    * @see jpuppeteer.cdp.client.entity.network.RequestServedFromCacheEvent
    */
    NETWORK_REQUESTSERVEDFROMCACHE("Network.requestServedFromCache", jpuppeteer.cdp.client.entity.network.RequestServedFromCacheEvent.class),

    /**
    * Fired when page is about to send HTTP request.
    * @see jpuppeteer.cdp.client.entity.network.RequestWillBeSentEvent
    */
    NETWORK_REQUESTWILLBESENT("Network.requestWillBeSent", jpuppeteer.cdp.client.entity.network.RequestWillBeSentEvent.class),

    /**
    * Fired when resource loading priority is changed
    * @see jpuppeteer.cdp.client.entity.network.ResourceChangedPriorityEvent
    */
    NETWORK_RESOURCECHANGEDPRIORITY("Network.resourceChangedPriority", jpuppeteer.cdp.client.entity.network.ResourceChangedPriorityEvent.class),

    /**
    * Fired when a signed exchange was received over the network
    * @see jpuppeteer.cdp.client.entity.network.SignedExchangeReceivedEvent
    */
    NETWORK_SIGNEDEXCHANGERECEIVED("Network.signedExchangeReceived", jpuppeteer.cdp.client.entity.network.SignedExchangeReceivedEvent.class),

    /**
    * Fired when HTTP response is available.
    * @see jpuppeteer.cdp.client.entity.network.ResponseReceivedEvent
    */
    NETWORK_RESPONSERECEIVED("Network.responseReceived", jpuppeteer.cdp.client.entity.network.ResponseReceivedEvent.class),

    /**
    * Fired when WebSocket is closed.
    * @see jpuppeteer.cdp.client.entity.network.WebSocketClosedEvent
    */
    NETWORK_WEBSOCKETCLOSED("Network.webSocketClosed", jpuppeteer.cdp.client.entity.network.WebSocketClosedEvent.class),

    /**
    * Fired upon WebSocket creation.
    * @see jpuppeteer.cdp.client.entity.network.WebSocketCreatedEvent
    */
    NETWORK_WEBSOCKETCREATED("Network.webSocketCreated", jpuppeteer.cdp.client.entity.network.WebSocketCreatedEvent.class),

    /**
    * Fired when WebSocket message error occurs.
    * @see jpuppeteer.cdp.client.entity.network.WebSocketFrameErrorEvent
    */
    NETWORK_WEBSOCKETFRAMEERROR("Network.webSocketFrameError", jpuppeteer.cdp.client.entity.network.WebSocketFrameErrorEvent.class),

    /**
    * Fired when WebSocket message is received.
    * @see jpuppeteer.cdp.client.entity.network.WebSocketFrameReceivedEvent
    */
    NETWORK_WEBSOCKETFRAMERECEIVED("Network.webSocketFrameReceived", jpuppeteer.cdp.client.entity.network.WebSocketFrameReceivedEvent.class),

    /**
    * Fired when WebSocket message is sent.
    * @see jpuppeteer.cdp.client.entity.network.WebSocketFrameSentEvent
    */
    NETWORK_WEBSOCKETFRAMESENT("Network.webSocketFrameSent", jpuppeteer.cdp.client.entity.network.WebSocketFrameSentEvent.class),

    /**
    * Fired when WebSocket handshake response becomes available.
    * @see jpuppeteer.cdp.client.entity.network.WebSocketHandshakeResponseReceivedEvent
    */
    NETWORK_WEBSOCKETHANDSHAKERESPONSERECEIVED("Network.webSocketHandshakeResponseReceived", jpuppeteer.cdp.client.entity.network.WebSocketHandshakeResponseReceivedEvent.class),

    /**
    * Fired when WebSocket is about to initiate handshake.
    * @see jpuppeteer.cdp.client.entity.network.WebSocketWillSendHandshakeRequestEvent
    */
    NETWORK_WEBSOCKETWILLSENDHANDSHAKEREQUEST("Network.webSocketWillSendHandshakeRequest", jpuppeteer.cdp.client.entity.network.WebSocketWillSendHandshakeRequestEvent.class),

    /**
    * Fired upon WebTransport creation.
    * @see jpuppeteer.cdp.client.entity.network.WebTransportCreatedEvent
    */
    NETWORK_WEBTRANSPORTCREATED("Network.webTransportCreated", jpuppeteer.cdp.client.entity.network.WebTransportCreatedEvent.class),

    /**
    * Fired when WebTransport handshake is finished.
    * @see jpuppeteer.cdp.client.entity.network.WebTransportConnectionEstablishedEvent
    */
    NETWORK_WEBTRANSPORTCONNECTIONESTABLISHED("Network.webTransportConnectionEstablished", jpuppeteer.cdp.client.entity.network.WebTransportConnectionEstablishedEvent.class),

    /**
    * Fired when WebTransport is disposed.
    * @see jpuppeteer.cdp.client.entity.network.WebTransportClosedEvent
    */
    NETWORK_WEBTRANSPORTCLOSED("Network.webTransportClosed", jpuppeteer.cdp.client.entity.network.WebTransportClosedEvent.class),

    /**
    * Fired when additional information about a requestWillBeSent event is available from the network stack. Not every requestWillBeSent event will have an additional requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent or requestWillBeSentExtraInfo will be fired first for the same request.
    * @see jpuppeteer.cdp.client.entity.network.RequestWillBeSentExtraInfoEvent
    */
    NETWORK_REQUESTWILLBESENTEXTRAINFO("Network.requestWillBeSentExtraInfo", jpuppeteer.cdp.client.entity.network.RequestWillBeSentExtraInfoEvent.class),

    /**
    * Fired when additional information about a responseReceived event is available from the network stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for it, and responseReceivedExtraInfo may be fired before or after responseReceived.
    * @see jpuppeteer.cdp.client.entity.network.ResponseReceivedExtraInfoEvent
    */
    NETWORK_RESPONSERECEIVEDEXTRAINFO("Network.responseReceivedExtraInfo", jpuppeteer.cdp.client.entity.network.ResponseReceivedExtraInfoEvent.class),

    /**
    * Fired exactly once for each Trust Token operation. Depending on the type of the operation and whether the operation succeeded or failed, the event is fired before the corresponding request was sent or after the response was received.
    * @see jpuppeteer.cdp.client.entity.network.TrustTokenOperationDoneEvent
    */
    NETWORK_TRUSTTOKENOPERATIONDONE("Network.trustTokenOperationDone", jpuppeteer.cdp.client.entity.network.TrustTokenOperationDoneEvent.class),

    /**
    * Fired once when parsing the .wbn file has succeeded. The event contains the information about the web bundle contents.
    * @see jpuppeteer.cdp.client.entity.network.SubresourceWebBundleMetadataReceivedEvent
    */
    NETWORK_SUBRESOURCEWEBBUNDLEMETADATARECEIVED("Network.subresourceWebBundleMetadataReceived", jpuppeteer.cdp.client.entity.network.SubresourceWebBundleMetadataReceivedEvent.class),

    /**
    * Fired once when parsing the .wbn file has failed.
    * @see jpuppeteer.cdp.client.entity.network.SubresourceWebBundleMetadataErrorEvent
    */
    NETWORK_SUBRESOURCEWEBBUNDLEMETADATAERROR("Network.subresourceWebBundleMetadataError", jpuppeteer.cdp.client.entity.network.SubresourceWebBundleMetadataErrorEvent.class),

    /**
    * Fired when handling requests for resources within a .wbn file. Note: this will only be fired for resources that are requested by the webpage.
    * @see jpuppeteer.cdp.client.entity.network.SubresourceWebBundleInnerResponseParsedEvent
    */
    NETWORK_SUBRESOURCEWEBBUNDLEINNERRESPONSEPARSED("Network.subresourceWebBundleInnerResponseParsed", jpuppeteer.cdp.client.entity.network.SubresourceWebBundleInnerResponseParsedEvent.class),

    /**
    * Fired when request for resources within a .wbn file failed.
    * @see jpuppeteer.cdp.client.entity.network.SubresourceWebBundleInnerResponseErrorEvent
    */
    NETWORK_SUBRESOURCEWEBBUNDLEINNERRESPONSEERROR("Network.subresourceWebBundleInnerResponseError", jpuppeteer.cdp.client.entity.network.SubresourceWebBundleInnerResponseErrorEvent.class),

    /**
    * Fired when the node should be inspected. This happens after call to `setInspectMode` or when user manually inspects an element.
    * @see jpuppeteer.cdp.client.entity.overlay.InspectNodeRequestedEvent
    */
    OVERLAY_INSPECTNODEREQUESTED("Overlay.inspectNodeRequested", jpuppeteer.cdp.client.entity.overlay.InspectNodeRequestedEvent.class),

    /**
    * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
    * @see jpuppeteer.cdp.client.entity.overlay.NodeHighlightRequestedEvent
    */
    OVERLAY_NODEHIGHLIGHTREQUESTED("Overlay.nodeHighlightRequested", jpuppeteer.cdp.client.entity.overlay.NodeHighlightRequestedEvent.class),

    /**
    * Fired when user asks to capture screenshot of some area on the page.
    * @see jpuppeteer.cdp.client.entity.overlay.ScreenshotRequestedEvent
    */
    OVERLAY_SCREENSHOTREQUESTED("Overlay.screenshotRequested", jpuppeteer.cdp.client.entity.overlay.ScreenshotRequestedEvent.class),

    OVERLAY_INSPECTMODECANCELED("Overlay.inspectModeCanceled", null),

    PAGE_DOMCONTENTEVENTFIRED("Page.domContentEventFired", jpuppeteer.cdp.client.entity.page.DomContentEventFiredEvent.class),

    /**
    * Emitted only when `page.interceptFileChooser` is enabled.
    * @see jpuppeteer.cdp.client.entity.page.FileChooserOpenedEvent
    */
    PAGE_FILECHOOSEROPENED("Page.fileChooserOpened", jpuppeteer.cdp.client.entity.page.FileChooserOpenedEvent.class),

    /**
    * Fired when frame has been attached to its parent.
    * @see jpuppeteer.cdp.client.entity.page.FrameAttachedEvent
    */
    PAGE_FRAMEATTACHED("Page.frameAttached", jpuppeteer.cdp.client.entity.page.FrameAttachedEvent.class),

    /**
    * Fired when frame no longer has a scheduled navigation.
    * @see jpuppeteer.cdp.client.entity.page.FrameClearedScheduledNavigationEvent
    */
    PAGE_FRAMECLEAREDSCHEDULEDNAVIGATION("Page.frameClearedScheduledNavigation", jpuppeteer.cdp.client.entity.page.FrameClearedScheduledNavigationEvent.class),

    /**
    * Fired when frame has been detached from its parent.
    * @see jpuppeteer.cdp.client.entity.page.FrameDetachedEvent
    */
    PAGE_FRAMEDETACHED("Page.frameDetached", jpuppeteer.cdp.client.entity.page.FrameDetachedEvent.class),

    /**
    * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
    * @see jpuppeteer.cdp.client.entity.page.FrameNavigatedEvent
    */
    PAGE_FRAMENAVIGATED("Page.frameNavigated", jpuppeteer.cdp.client.entity.page.FrameNavigatedEvent.class),

    /**
    * Fired when opening document to write to.
    * @see jpuppeteer.cdp.client.entity.page.DocumentOpenedEvent
    */
    PAGE_DOCUMENTOPENED("Page.documentOpened", jpuppeteer.cdp.client.entity.page.DocumentOpenedEvent.class),

    PAGE_FRAMERESIZED("Page.frameResized", null),

    /**
    * Fired when a renderer-initiated navigation is requested. Navigation may still be cancelled after the event is issued.
    * @see jpuppeteer.cdp.client.entity.page.FrameRequestedNavigationEvent
    */
    PAGE_FRAMEREQUESTEDNAVIGATION("Page.frameRequestedNavigation", jpuppeteer.cdp.client.entity.page.FrameRequestedNavigationEvent.class),

    /**
    * Fired when frame schedules a potential navigation.
    * @see jpuppeteer.cdp.client.entity.page.FrameScheduledNavigationEvent
    */
    PAGE_FRAMESCHEDULEDNAVIGATION("Page.frameScheduledNavigation", jpuppeteer.cdp.client.entity.page.FrameScheduledNavigationEvent.class),

    /**
    * Fired when frame has started loading.
    * @see jpuppeteer.cdp.client.entity.page.FrameStartedLoadingEvent
    */
    PAGE_FRAMESTARTEDLOADING("Page.frameStartedLoading", jpuppeteer.cdp.client.entity.page.FrameStartedLoadingEvent.class),

    /**
    * Fired when frame has stopped loading.
    * @see jpuppeteer.cdp.client.entity.page.FrameStoppedLoadingEvent
    */
    PAGE_FRAMESTOPPEDLOADING("Page.frameStoppedLoading", jpuppeteer.cdp.client.entity.page.FrameStoppedLoadingEvent.class),

    /**
    * Fired when page is about to start a download. Deprecated. Use Browser.downloadWillBegin instead.
    * @see jpuppeteer.cdp.client.entity.page.DownloadWillBeginEvent
    */
    PAGE_DOWNLOADWILLBEGIN("Page.downloadWillBegin", jpuppeteer.cdp.client.entity.page.DownloadWillBeginEvent.class),

    /**
    * Fired when download makes progress. Last call has |done| == true. Deprecated. Use Browser.downloadProgress instead.
    * @see jpuppeteer.cdp.client.entity.page.DownloadProgressEvent
    */
    PAGE_DOWNLOADPROGRESS("Page.downloadProgress", jpuppeteer.cdp.client.entity.page.DownloadProgressEvent.class),

    PAGE_INTERSTITIALHIDDEN("Page.interstitialHidden", null),

    PAGE_INTERSTITIALSHOWN("Page.interstitialShown", null),

    /**
    * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
    * @see jpuppeteer.cdp.client.entity.page.JavascriptDialogClosedEvent
    */
    PAGE_JAVASCRIPTDIALOGCLOSED("Page.javascriptDialogClosed", jpuppeteer.cdp.client.entity.page.JavascriptDialogClosedEvent.class),

    /**
    * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
    * @see jpuppeteer.cdp.client.entity.page.JavascriptDialogOpeningEvent
    */
    PAGE_JAVASCRIPTDIALOGOPENING("Page.javascriptDialogOpening", jpuppeteer.cdp.client.entity.page.JavascriptDialogOpeningEvent.class),

    /**
    * Fired for top level page lifecycle events such as navigation, load, paint, etc.
    * @see jpuppeteer.cdp.client.entity.page.LifecycleEvent
    */
    PAGE_LIFECYCLEEVENT("Page.lifecycleEvent", jpuppeteer.cdp.client.entity.page.LifecycleEvent.class),

    /**
    * Fired for failed bfcache history navigations if BackForwardCache feature is enabled. Do not assume any ordering with the Page.frameNavigated event. This event is fired only for main-frame history navigation where the document changes (non-same-document navigations), when bfcache navigation fails.
    * @see jpuppeteer.cdp.client.entity.page.BackForwardCacheNotUsedEvent
    */
    PAGE_BACKFORWARDCACHENOTUSED("Page.backForwardCacheNotUsed", jpuppeteer.cdp.client.entity.page.BackForwardCacheNotUsedEvent.class),

    PAGE_LOADEVENTFIRED("Page.loadEventFired", jpuppeteer.cdp.client.entity.page.LoadEventFiredEvent.class),

    /**
    * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
    * @see jpuppeteer.cdp.client.entity.page.NavigatedWithinDocumentEvent
    */
    PAGE_NAVIGATEDWITHINDOCUMENT("Page.navigatedWithinDocument", jpuppeteer.cdp.client.entity.page.NavigatedWithinDocumentEvent.class),

    /**
    * Compressed image data requested by the `startScreencast`.
    * @see jpuppeteer.cdp.client.entity.page.ScreencastFrameEvent
    */
    PAGE_SCREENCASTFRAME("Page.screencastFrame", jpuppeteer.cdp.client.entity.page.ScreencastFrameEvent.class),

    /**
    * Fired when the page with currently enabled screencast was shown or hidden `.
    * @see jpuppeteer.cdp.client.entity.page.ScreencastVisibilityChangedEvent
    */
    PAGE_SCREENCASTVISIBILITYCHANGED("Page.screencastVisibilityChanged", jpuppeteer.cdp.client.entity.page.ScreencastVisibilityChangedEvent.class),

    /**
    * Fired when a new window is going to be opened, via window.open(), link click, form submission, etc.
    * @see jpuppeteer.cdp.client.entity.page.WindowOpenEvent
    */
    PAGE_WINDOWOPEN("Page.windowOpen", jpuppeteer.cdp.client.entity.page.WindowOpenEvent.class),

    /**
    * Issued for every compilation cache generated. Is only available if Page.setGenerateCompilationCache is enabled.
    * @see jpuppeteer.cdp.client.entity.page.CompilationCacheProducedEvent
    */
    PAGE_COMPILATIONCACHEPRODUCED("Page.compilationCacheProduced", jpuppeteer.cdp.client.entity.page.CompilationCacheProducedEvent.class),

    /**
    * Current values of the metrics.
    * @see jpuppeteer.cdp.client.entity.performance.MetricsEvent
    */
    PERFORMANCE_METRICS("Performance.metrics", jpuppeteer.cdp.client.entity.performance.MetricsEvent.class),

    /**
    * Sent when a performance timeline event is added. See reportPerformanceTimeline method.
    * @see jpuppeteer.cdp.client.entity.performancetimeline.TimelineEventAddedEvent
    */
    PERFORMANCETIMELINE_TIMELINEEVENTADDED("PerformanceTimeline.timelineEventAdded", jpuppeteer.cdp.client.entity.performancetimeline.TimelineEventAddedEvent.class),

    /**
    * There is a certificate error. If overriding certificate errors is enabled, then it should be handled with the `handleCertificateError` command. Note: this event does not fire if the certificate error has been allowed internally. Only one client per target should override certificate errors at the same time.
    * @see jpuppeteer.cdp.client.entity.security.CertificateErrorEvent
    */
    SECURITY_CERTIFICATEERROR("Security.certificateError", jpuppeteer.cdp.client.entity.security.CertificateErrorEvent.class),

    /**
    * The security state of the page changed.
    * @see jpuppeteer.cdp.client.entity.security.VisibleSecurityStateChangedEvent
    */
    SECURITY_VISIBLESECURITYSTATECHANGED("Security.visibleSecurityStateChanged", jpuppeteer.cdp.client.entity.security.VisibleSecurityStateChangedEvent.class),

    /**
    * The security state of the page changed.
    * @see jpuppeteer.cdp.client.entity.security.SecurityStateChangedEvent
    */
    SECURITY_SECURITYSTATECHANGED("Security.securityStateChanged", jpuppeteer.cdp.client.entity.security.SecurityStateChangedEvent.class),

    SERVICEWORKER_WORKERERRORREPORTED("ServiceWorker.workerErrorReported", jpuppeteer.cdp.client.entity.serviceworker.WorkerErrorReportedEvent.class),

    SERVICEWORKER_WORKERREGISTRATIONUPDATED("ServiceWorker.workerRegistrationUpdated", jpuppeteer.cdp.client.entity.serviceworker.WorkerRegistrationUpdatedEvent.class),

    SERVICEWORKER_WORKERVERSIONUPDATED("ServiceWorker.workerVersionUpdated", jpuppeteer.cdp.client.entity.serviceworker.WorkerVersionUpdatedEvent.class),

    /**
    * A cache's contents have been modified.
    * @see jpuppeteer.cdp.client.entity.storage.CacheStorageContentUpdatedEvent
    */
    STORAGE_CACHESTORAGECONTENTUPDATED("Storage.cacheStorageContentUpdated", jpuppeteer.cdp.client.entity.storage.CacheStorageContentUpdatedEvent.class),

    /**
    * A cache has been added/deleted.
    * @see jpuppeteer.cdp.client.entity.storage.CacheStorageListUpdatedEvent
    */
    STORAGE_CACHESTORAGELISTUPDATED("Storage.cacheStorageListUpdated", jpuppeteer.cdp.client.entity.storage.CacheStorageListUpdatedEvent.class),

    /**
    * The origin's IndexedDB object store has been modified.
    * @see jpuppeteer.cdp.client.entity.storage.IndexedDBContentUpdatedEvent
    */
    STORAGE_INDEXEDDBCONTENTUPDATED("Storage.indexedDBContentUpdated", jpuppeteer.cdp.client.entity.storage.IndexedDBContentUpdatedEvent.class),

    /**
    * The origin's IndexedDB database list has been modified.
    * @see jpuppeteer.cdp.client.entity.storage.IndexedDBListUpdatedEvent
    */
    STORAGE_INDEXEDDBLISTUPDATED("Storage.indexedDBListUpdated", jpuppeteer.cdp.client.entity.storage.IndexedDBListUpdatedEvent.class),

    /**
    * Issued when attached to target because of auto-attach or `attachToTarget` command.
    * @see jpuppeteer.cdp.client.entity.target.AttachedToTargetEvent
    */
    TARGET_ATTACHEDTOTARGET("Target.attachedToTarget", jpuppeteer.cdp.client.entity.target.AttachedToTargetEvent.class),

    /**
    * Issued when detached from target for any reason (including `detachFromTarget` command). Can be issued multiple times per target if multiple sessions have been attached to it.
    * @see jpuppeteer.cdp.client.entity.target.DetachedFromTargetEvent
    */
    TARGET_DETACHEDFROMTARGET("Target.detachedFromTarget", jpuppeteer.cdp.client.entity.target.DetachedFromTargetEvent.class),

    /**
    * Notifies about a new protocol message received from the session (as reported in `attachedToTarget` event).
    * @see jpuppeteer.cdp.client.entity.target.ReceivedMessageFromTargetEvent
    */
    TARGET_RECEIVEDMESSAGEFROMTARGET("Target.receivedMessageFromTarget", jpuppeteer.cdp.client.entity.target.ReceivedMessageFromTargetEvent.class),

    /**
    * Issued when a possible inspection target is created.
    * @see jpuppeteer.cdp.client.entity.target.TargetCreatedEvent
    */
    TARGET_TARGETCREATED("Target.targetCreated", jpuppeteer.cdp.client.entity.target.TargetCreatedEvent.class),

    /**
    * Issued when a target is destroyed.
    * @see jpuppeteer.cdp.client.entity.target.TargetDestroyedEvent
    */
    TARGET_TARGETDESTROYED("Target.targetDestroyed", jpuppeteer.cdp.client.entity.target.TargetDestroyedEvent.class),

    /**
    * Issued when a target has crashed.
    * @see jpuppeteer.cdp.client.entity.target.TargetCrashedEvent
    */
    TARGET_TARGETCRASHED("Target.targetCrashed", jpuppeteer.cdp.client.entity.target.TargetCrashedEvent.class),

    /**
    * Issued when some information about a target has changed. This only happens between `targetCreated` and `targetDestroyed`.
    * @see jpuppeteer.cdp.client.entity.target.TargetInfoChangedEvent
    */
    TARGET_TARGETINFOCHANGED("Target.targetInfoChanged", jpuppeteer.cdp.client.entity.target.TargetInfoChangedEvent.class),

    /**
    * Informs that port was successfully bound and got a specified connection id.
    * @see jpuppeteer.cdp.client.entity.tethering.AcceptedEvent
    */
    TETHERING_ACCEPTED("Tethering.accepted", jpuppeteer.cdp.client.entity.tethering.AcceptedEvent.class),

    TRACING_BUFFERUSAGE("Tracing.bufferUsage", jpuppeteer.cdp.client.entity.tracing.BufferUsageEvent.class),

    /**
    * Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
    * @see jpuppeteer.cdp.client.entity.tracing.DataCollectedEvent
    */
    TRACING_DATACOLLECTED("Tracing.dataCollected", jpuppeteer.cdp.client.entity.tracing.DataCollectedEvent.class),

    /**
    * Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
    * @see jpuppeteer.cdp.client.entity.tracing.TracingCompleteEvent
    */
    TRACING_TRACINGCOMPLETE("Tracing.tracingComplete", jpuppeteer.cdp.client.entity.tracing.TracingCompleteEvent.class),

    /**
    * Issued when the domain is enabled and the request URL matches the specified filter. The request is paused until the client responds with one of continueRequest, failRequest or fulfillRequest. The stage of the request can be determined by presence of responseErrorReason and responseStatusCode -- the request is at the response stage if either of these fields is present and in the request stage otherwise.
    * @see jpuppeteer.cdp.client.entity.fetch.RequestPausedEvent
    */
    FETCH_REQUESTPAUSED("Fetch.requestPaused", jpuppeteer.cdp.client.entity.fetch.RequestPausedEvent.class),

    /**
    * Issued when the domain is enabled with handleAuthRequests set to true. The request is paused until client responds with continueWithAuth.
    * @see jpuppeteer.cdp.client.entity.fetch.AuthRequiredEvent
    */
    FETCH_AUTHREQUIRED("Fetch.authRequired", jpuppeteer.cdp.client.entity.fetch.AuthRequiredEvent.class),

    /**
    * Notifies that a new BaseAudioContext has been created.
    * @see jpuppeteer.cdp.client.entity.webaudio.ContextCreatedEvent
    */
    WEBAUDIO_CONTEXTCREATED("WebAudio.contextCreated", jpuppeteer.cdp.client.entity.webaudio.ContextCreatedEvent.class),

    /**
    * Notifies that an existing BaseAudioContext will be destroyed.
    * @see jpuppeteer.cdp.client.entity.webaudio.ContextWillBeDestroyedEvent
    */
    WEBAUDIO_CONTEXTWILLBEDESTROYED("WebAudio.contextWillBeDestroyed", jpuppeteer.cdp.client.entity.webaudio.ContextWillBeDestroyedEvent.class),

    /**
    * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
    * @see jpuppeteer.cdp.client.entity.webaudio.ContextChangedEvent
    */
    WEBAUDIO_CONTEXTCHANGED("WebAudio.contextChanged", jpuppeteer.cdp.client.entity.webaudio.ContextChangedEvent.class),

    /**
    * Notifies that the construction of an AudioListener has finished.
    * @see jpuppeteer.cdp.client.entity.webaudio.AudioListenerCreatedEvent
    */
    WEBAUDIO_AUDIOLISTENERCREATED("WebAudio.audioListenerCreated", jpuppeteer.cdp.client.entity.webaudio.AudioListenerCreatedEvent.class),

    /**
    * Notifies that a new AudioListener has been created.
    * @see jpuppeteer.cdp.client.entity.webaudio.AudioListenerWillBeDestroyedEvent
    */
    WEBAUDIO_AUDIOLISTENERWILLBEDESTROYED("WebAudio.audioListenerWillBeDestroyed", jpuppeteer.cdp.client.entity.webaudio.AudioListenerWillBeDestroyedEvent.class),

    /**
    * Notifies that a new AudioNode has been created.
    * @see jpuppeteer.cdp.client.entity.webaudio.AudioNodeCreatedEvent
    */
    WEBAUDIO_AUDIONODECREATED("WebAudio.audioNodeCreated", jpuppeteer.cdp.client.entity.webaudio.AudioNodeCreatedEvent.class),

    /**
    * Notifies that an existing AudioNode has been destroyed.
    * @see jpuppeteer.cdp.client.entity.webaudio.AudioNodeWillBeDestroyedEvent
    */
    WEBAUDIO_AUDIONODEWILLBEDESTROYED("WebAudio.audioNodeWillBeDestroyed", jpuppeteer.cdp.client.entity.webaudio.AudioNodeWillBeDestroyedEvent.class),

    /**
    * Notifies that a new AudioParam has been created.
    * @see jpuppeteer.cdp.client.entity.webaudio.AudioParamCreatedEvent
    */
    WEBAUDIO_AUDIOPARAMCREATED("WebAudio.audioParamCreated", jpuppeteer.cdp.client.entity.webaudio.AudioParamCreatedEvent.class),

    /**
    * Notifies that an existing AudioParam has been destroyed.
    * @see jpuppeteer.cdp.client.entity.webaudio.AudioParamWillBeDestroyedEvent
    */
    WEBAUDIO_AUDIOPARAMWILLBEDESTROYED("WebAudio.audioParamWillBeDestroyed", jpuppeteer.cdp.client.entity.webaudio.AudioParamWillBeDestroyedEvent.class),

    /**
    * Notifies that two AudioNodes are connected.
    * @see jpuppeteer.cdp.client.entity.webaudio.NodesConnectedEvent
    */
    WEBAUDIO_NODESCONNECTED("WebAudio.nodesConnected", jpuppeteer.cdp.client.entity.webaudio.NodesConnectedEvent.class),

    /**
    * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
    * @see jpuppeteer.cdp.client.entity.webaudio.NodesDisconnectedEvent
    */
    WEBAUDIO_NODESDISCONNECTED("WebAudio.nodesDisconnected", jpuppeteer.cdp.client.entity.webaudio.NodesDisconnectedEvent.class),

    /**
    * Notifies that an AudioNode is connected to an AudioParam.
    * @see jpuppeteer.cdp.client.entity.webaudio.NodeParamConnectedEvent
    */
    WEBAUDIO_NODEPARAMCONNECTED("WebAudio.nodeParamConnected", jpuppeteer.cdp.client.entity.webaudio.NodeParamConnectedEvent.class),

    /**
    * Notifies that an AudioNode is disconnected to an AudioParam.
    * @see jpuppeteer.cdp.client.entity.webaudio.NodeParamDisconnectedEvent
    */
    WEBAUDIO_NODEPARAMDISCONNECTED("WebAudio.nodeParamDisconnected", jpuppeteer.cdp.client.entity.webaudio.NodeParamDisconnectedEvent.class),

    /**
    * This can be called multiple times, and can be used to set / override / remove player properties. A null propValue indicates removal.
    * @see jpuppeteer.cdp.client.entity.media.PlayerPropertiesChangedEvent
    */
    MEDIA_PLAYERPROPERTIESCHANGED("Media.playerPropertiesChanged", jpuppeteer.cdp.client.entity.media.PlayerPropertiesChangedEvent.class),

    /**
    * Send events as a list, allowing them to be batched on the browser for less congestion. If batched, events must ALWAYS be in chronological order.
    * @see jpuppeteer.cdp.client.entity.media.PlayerEventsAddedEvent
    */
    MEDIA_PLAYEREVENTSADDED("Media.playerEventsAdded", jpuppeteer.cdp.client.entity.media.PlayerEventsAddedEvent.class),

    /**
    * Send a list of any messages that need to be delivered.
    * @see jpuppeteer.cdp.client.entity.media.PlayerMessagesLoggedEvent
    */
    MEDIA_PLAYERMESSAGESLOGGED("Media.playerMessagesLogged", jpuppeteer.cdp.client.entity.media.PlayerMessagesLoggedEvent.class),

    /**
    * Send a list of any errors that need to be delivered.
    * @see jpuppeteer.cdp.client.entity.media.PlayerErrorsRaisedEvent
    */
    MEDIA_PLAYERERRORSRAISED("Media.playerErrorsRaised", jpuppeteer.cdp.client.entity.media.PlayerErrorsRaisedEvent.class),

    /**
    * Called whenever a player is created, or when a new agent joins and receives a list of active players. If an agent is restored, it will receive the full list of player ids and all events again.
    * @see jpuppeteer.cdp.client.entity.media.PlayersCreatedEvent
    */
    MEDIA_PLAYERSCREATED("Media.playersCreated", jpuppeteer.cdp.client.entity.media.PlayersCreatedEvent.class),

    /**
    * Issued when new console message is added.
    * @see jpuppeteer.cdp.client.entity.console.MessageAddedEvent
    */
    CONSOLE_MESSAGEADDED("Console.messageAdded", jpuppeteer.cdp.client.entity.console.MessageAddedEvent.class),

    /**
    * Fired when breakpoint is resolved to an actual script and location.
    * @see jpuppeteer.cdp.client.entity.debugger.BreakpointResolvedEvent
    */
    DEBUGGER_BREAKPOINTRESOLVED("Debugger.breakpointResolved", jpuppeteer.cdp.client.entity.debugger.BreakpointResolvedEvent.class),

    /**
    * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
    * @see jpuppeteer.cdp.client.entity.debugger.PausedEvent
    */
    DEBUGGER_PAUSED("Debugger.paused", jpuppeteer.cdp.client.entity.debugger.PausedEvent.class),

    DEBUGGER_RESUMED("Debugger.resumed", null),

    /**
    * Fired when virtual machine fails to parse the script.
    * @see jpuppeteer.cdp.client.entity.debugger.ScriptFailedToParseEvent
    */
    DEBUGGER_SCRIPTFAILEDTOPARSE("Debugger.scriptFailedToParse", jpuppeteer.cdp.client.entity.debugger.ScriptFailedToParseEvent.class),

    /**
    * Fired when virtual machine parses script. This event is also fired for all known and uncollected scripts upon enabling debugger.
    * @see jpuppeteer.cdp.client.entity.debugger.ScriptParsedEvent
    */
    DEBUGGER_SCRIPTPARSED("Debugger.scriptParsed", jpuppeteer.cdp.client.entity.debugger.ScriptParsedEvent.class),

    HEAPPROFILER_ADDHEAPSNAPSHOTCHUNK("HeapProfiler.addHeapSnapshotChunk", jpuppeteer.cdp.client.entity.heapprofiler.AddHeapSnapshotChunkEvent.class),

    /**
    * If heap objects tracking has been started then backend may send update for one or more fragments
    * @see jpuppeteer.cdp.client.entity.heapprofiler.HeapStatsUpdateEvent
    */
    HEAPPROFILER_HEAPSTATSUPDATE("HeapProfiler.heapStatsUpdate", jpuppeteer.cdp.client.entity.heapprofiler.HeapStatsUpdateEvent.class),

    /**
    * If heap objects tracking has been started then backend regularly sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
    * @see jpuppeteer.cdp.client.entity.heapprofiler.LastSeenObjectIdEvent
    */
    HEAPPROFILER_LASTSEENOBJECTID("HeapProfiler.lastSeenObjectId", jpuppeteer.cdp.client.entity.heapprofiler.LastSeenObjectIdEvent.class),

    HEAPPROFILER_REPORTHEAPSNAPSHOTPROGRESS("HeapProfiler.reportHeapSnapshotProgress", jpuppeteer.cdp.client.entity.heapprofiler.ReportHeapSnapshotProgressEvent.class),

    HEAPPROFILER_RESETPROFILES("HeapProfiler.resetProfiles", null),

    PROFILER_CONSOLEPROFILEFINISHED("Profiler.consoleProfileFinished", jpuppeteer.cdp.client.entity.profiler.ConsoleProfileFinishedEvent.class),

    /**
    * Sent when new profile recording is started using console.profile() call.
    * @see jpuppeteer.cdp.client.entity.profiler.ConsoleProfileStartedEvent
    */
    PROFILER_CONSOLEPROFILESTARTED("Profiler.consoleProfileStarted", jpuppeteer.cdp.client.entity.profiler.ConsoleProfileStartedEvent.class),

    /**
    * Reports coverage delta since the last poll (either from an event like this, or from `takePreciseCoverage` for the current isolate. May only be sent if precise code coverage has been started. This event can be trigged by the embedder to, for example, trigger collection of coverage data immediatelly at a certain point in time.
    * @see jpuppeteer.cdp.client.entity.profiler.PreciseCoverageDeltaUpdateEvent
    */
    PROFILER_PRECISECOVERAGEDELTAUPDATE("Profiler.preciseCoverageDeltaUpdate", jpuppeteer.cdp.client.entity.profiler.PreciseCoverageDeltaUpdateEvent.class),

    /**
    * Notification is issued every time when binding is called.
    * @see jpuppeteer.cdp.client.entity.runtime.BindingCalledEvent
    */
    RUNTIME_BINDINGCALLED("Runtime.bindingCalled", jpuppeteer.cdp.client.entity.runtime.BindingCalledEvent.class),

    /**
    * Issued when console API was called.
    * @see jpuppeteer.cdp.client.entity.runtime.ConsoleAPICalledEvent
    */
    RUNTIME_CONSOLEAPICALLED("Runtime.consoleAPICalled", jpuppeteer.cdp.client.entity.runtime.ConsoleAPICalledEvent.class),

    /**
    * Issued when unhandled exception was revoked.
    * @see jpuppeteer.cdp.client.entity.runtime.ExceptionRevokedEvent
    */
    RUNTIME_EXCEPTIONREVOKED("Runtime.exceptionRevoked", jpuppeteer.cdp.client.entity.runtime.ExceptionRevokedEvent.class),

    /**
    * Issued when exception was thrown and unhandled.
    * @see jpuppeteer.cdp.client.entity.runtime.ExceptionThrownEvent
    */
    RUNTIME_EXCEPTIONTHROWN("Runtime.exceptionThrown", jpuppeteer.cdp.client.entity.runtime.ExceptionThrownEvent.class),

    /**
    * Issued when new execution context is created.
    * @see jpuppeteer.cdp.client.entity.runtime.ExecutionContextCreatedEvent
    */
    RUNTIME_EXECUTIONCONTEXTCREATED("Runtime.executionContextCreated", jpuppeteer.cdp.client.entity.runtime.ExecutionContextCreatedEvent.class),

    /**
    * Issued when execution context is destroyed.
    * @see jpuppeteer.cdp.client.entity.runtime.ExecutionContextDestroyedEvent
    */
    RUNTIME_EXECUTIONCONTEXTDESTROYED("Runtime.executionContextDestroyed", jpuppeteer.cdp.client.entity.runtime.ExecutionContextDestroyedEvent.class),

    RUNTIME_EXECUTIONCONTEXTSCLEARED("Runtime.executionContextsCleared", null),

    /**
    * Issued when object should be inspected (for example, as a result of inspect() command line API call).
    * @see jpuppeteer.cdp.client.entity.runtime.InspectRequestedEvent
    */
    RUNTIME_INSPECTREQUESTED("Runtime.inspectRequested", jpuppeteer.cdp.client.entity.runtime.InspectRequestedEvent.class),

    ;

    private String name;

    private Class clazz;

    CDPEventType(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Class getClazz() {
        return clazz;
    }

    public static CDPEventType findByName(String name) {
        for(CDPEventType val : values()) {
            if (val.name.equals(name)) return val;
        }
        return null;
    }
}