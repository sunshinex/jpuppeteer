package jpuppeteer.cdp.cdp;

public enum CDPEventType {

    /**
    * Event for when an animation has been cancelled.
    * @see jpuppeteer.cdp.cdp.entity.animation.AnimationCanceledEvent
    */
    ANIMATION_ANIMATIONCANCELED("Animation.animationCanceled"),

    /**
    * Event for each animation that has been created.
    * @see jpuppeteer.cdp.cdp.entity.animation.AnimationCreatedEvent
    */
    ANIMATION_ANIMATIONCREATED("Animation.animationCreated"),

    /**
    * Event for animation that has been started.
    * @see jpuppeteer.cdp.cdp.entity.animation.AnimationStartedEvent
    */
    ANIMATION_ANIMATIONSTARTED("Animation.animationStarted"),

    APPLICATIONCACHE_APPLICATIONCACHESTATUSUPDATED("ApplicationCache.applicationCacheStatusUpdated"),

    APPLICATIONCACHE_NETWORKSTATEUPDATED("ApplicationCache.networkStateUpdated"),

    /**
    * Called when the recording state for the service has been updated.
    * @see jpuppeteer.cdp.cdp.entity.backgroundservice.RecordingStateChangedEvent
    */
    BACKGROUNDSERVICE_RECORDINGSTATECHANGED("BackgroundService.recordingStateChanged"),

    /**
    * Called with all existing backgroundServiceEvents when enabled, and all new events afterwards if enabled and recording.
    * @see jpuppeteer.cdp.cdp.entity.backgroundservice.BackgroundServiceEventReceivedEvent
    */
    BACKGROUNDSERVICE_BACKGROUNDSERVICEEVENTRECEIVED("BackgroundService.backgroundServiceEventReceived"),

    /**
    * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded web font
    * @see jpuppeteer.cdp.cdp.entity.css.FontsUpdatedEvent
    */
    CSS_FONTSUPDATED("CSS.fontsUpdated"),

    CSS_MEDIAQUERYRESULTCHANGED("CSS.mediaQueryResultChanged"),

    /**
    * Fired whenever an active document stylesheet is added.
    * @see jpuppeteer.cdp.cdp.entity.css.StyleSheetAddedEvent
    */
    CSS_STYLESHEETADDED("CSS.styleSheetAdded"),

    /**
    * Fired whenever a stylesheet is changed as a result of the client operation.
    * @see jpuppeteer.cdp.cdp.entity.css.StyleSheetChangedEvent
    */
    CSS_STYLESHEETCHANGED("CSS.styleSheetChanged"),

    /**
    * Fired whenever an active document stylesheet is removed.
    * @see jpuppeteer.cdp.cdp.entity.css.StyleSheetRemovedEvent
    */
    CSS_STYLESHEETREMOVED("CSS.styleSheetRemoved"),

    /**
    * This is fired whenever the list of available sinks changes. A sink is a device or a software surface that you can cast to.
    * @see jpuppeteer.cdp.cdp.entity.cast.SinksUpdatedEvent
    */
    CAST_SINKSUPDATED("Cast.sinksUpdated"),

    /**
    * This is fired whenever the outstanding issue/error message changes. |issueMessage| is empty if there is no issue.
    * @see jpuppeteer.cdp.cdp.entity.cast.IssueUpdatedEvent
    */
    CAST_ISSUEUPDATED("Cast.issueUpdated"),

    /**
    * Fired when `Element`'s attribute is modified.
    * @see jpuppeteer.cdp.cdp.entity.dom.AttributeModifiedEvent
    */
    DOM_ATTRIBUTEMODIFIED("DOM.attributeModified"),

    /**
    * Fired when `Element`'s attribute is removed.
    * @see jpuppeteer.cdp.cdp.entity.dom.AttributeRemovedEvent
    */
    DOM_ATTRIBUTEREMOVED("DOM.attributeRemoved"),

    /**
    * Mirrors `DOMCharacterDataModified` event.
    * @see jpuppeteer.cdp.cdp.entity.dom.CharacterDataModifiedEvent
    */
    DOM_CHARACTERDATAMODIFIED("DOM.characterDataModified"),

    /**
    * Fired when `Container`'s child node count has changed.
    * @see jpuppeteer.cdp.cdp.entity.dom.ChildNodeCountUpdatedEvent
    */
    DOM_CHILDNODECOUNTUPDATED("DOM.childNodeCountUpdated"),

    /**
    * Mirrors `DOMNodeInserted` event.
    * @see jpuppeteer.cdp.cdp.entity.dom.ChildNodeInsertedEvent
    */
    DOM_CHILDNODEINSERTED("DOM.childNodeInserted"),

    /**
    * Mirrors `DOMNodeRemoved` event.
    * @see jpuppeteer.cdp.cdp.entity.dom.ChildNodeRemovedEvent
    */
    DOM_CHILDNODEREMOVED("DOM.childNodeRemoved"),

    /**
    * Called when distrubution is changed.
    * @see jpuppeteer.cdp.cdp.entity.dom.DistributedNodesUpdatedEvent
    */
    DOM_DISTRIBUTEDNODESUPDATED("DOM.distributedNodesUpdated"),

    DOM_DOCUMENTUPDATED("DOM.documentUpdated"),

    /**
    * Fired when `Element`'s inline style is modified via a CSS property modification.
    * @see jpuppeteer.cdp.cdp.entity.dom.InlineStyleInvalidatedEvent
    */
    DOM_INLINESTYLEINVALIDATED("DOM.inlineStyleInvalidated"),

    /**
    * Called when a pseudo element is added to an element.
    * @see jpuppeteer.cdp.cdp.entity.dom.PseudoElementAddedEvent
    */
    DOM_PSEUDOELEMENTADDED("DOM.pseudoElementAdded"),

    /**
    * Called when a pseudo element is removed from an element.
    * @see jpuppeteer.cdp.cdp.entity.dom.PseudoElementRemovedEvent
    */
    DOM_PSEUDOELEMENTREMOVED("DOM.pseudoElementRemoved"),

    /**
    * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
    * @see jpuppeteer.cdp.cdp.entity.dom.SetChildNodesEvent
    */
    DOM_SETCHILDNODES("DOM.setChildNodes"),

    /**
    * Called when shadow root is popped from the element.
    * @see jpuppeteer.cdp.cdp.entity.dom.ShadowRootPoppedEvent
    */
    DOM_SHADOWROOTPOPPED("DOM.shadowRootPopped"),

    /**
    * Called when shadow root is pushed into the element.
    * @see jpuppeteer.cdp.cdp.entity.dom.ShadowRootPushedEvent
    */
    DOM_SHADOWROOTPUSHED("DOM.shadowRootPushed"),

    DOMSTORAGE_DOMSTORAGEITEMADDED("DOMStorage.domStorageItemAdded"),

    DOMSTORAGE_DOMSTORAGEITEMREMOVED("DOMStorage.domStorageItemRemoved"),

    DOMSTORAGE_DOMSTORAGEITEMUPDATED("DOMStorage.domStorageItemUpdated"),

    DOMSTORAGE_DOMSTORAGEITEMSCLEARED("DOMStorage.domStorageItemsCleared"),

    DATABASE_ADDDATABASE("Database.addDatabase"),

    EMULATION_VIRTUALTIMEBUDGETEXPIRED("Emulation.virtualTimeBudgetExpired"),

    /**
    * Issued when the target starts or stops needing BeginFrames.
    * @see jpuppeteer.cdp.cdp.entity.headlessexperimental.NeedsBeginFramesChangedEvent
    */
    HEADLESSEXPERIMENTAL_NEEDSBEGINFRAMESCHANGED("HeadlessExperimental.needsBeginFramesChanged"),

    /**
    * Fired when remote debugging connection is about to be terminated. Contains detach reason.
    * @see jpuppeteer.cdp.cdp.entity.inspector.DetachedEvent
    */
    INSPECTOR_DETACHED("Inspector.detached"),

    INSPECTOR_TARGETCRASHED("Inspector.targetCrashed"),

    INSPECTOR_TARGETRELOADEDAFTERCRASH("Inspector.targetReloadedAfterCrash"),

    LAYERTREE_LAYERPAINTED("LayerTree.layerPainted"),

    LAYERTREE_LAYERTREEDIDCHANGE("LayerTree.layerTreeDidChange"),

    /**
    * Issued when new message was logged.
    * @see jpuppeteer.cdp.cdp.entity.log.EntryAddedEvent
    */
    LOG_ENTRYADDED("Log.entryAdded"),

    /**
    * Fired when data chunk was received over the network.
    * @see jpuppeteer.cdp.cdp.entity.network.DataReceivedEvent
    */
    NETWORK_DATARECEIVED("Network.dataReceived"),

    /**
    * Fired when EventSource message is received.
    * @see jpuppeteer.cdp.cdp.entity.network.EventSourceMessageReceivedEvent
    */
    NETWORK_EVENTSOURCEMESSAGERECEIVED("Network.eventSourceMessageReceived"),

    /**
    * Fired when HTTP request has failed to load.
    * @see jpuppeteer.cdp.cdp.entity.network.LoadingFailedEvent
    */
    NETWORK_LOADINGFAILED("Network.loadingFailed"),

    /**
    * Fired when HTTP request has finished loading.
    * @see jpuppeteer.cdp.cdp.entity.network.LoadingFinishedEvent
    */
    NETWORK_LOADINGFINISHED("Network.loadingFinished"),

    /**
    * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or mocked. Deprecated, use Fetch.requestPaused instead.
    * @see jpuppeteer.cdp.cdp.entity.network.RequestInterceptedEvent
    */
    NETWORK_REQUESTINTERCEPTED("Network.requestIntercepted"),

    /**
    * Fired if request ended up loading from cache.
    * @see jpuppeteer.cdp.cdp.entity.network.RequestServedFromCacheEvent
    */
    NETWORK_REQUESTSERVEDFROMCACHE("Network.requestServedFromCache"),

    /**
    * Fired when page is about to send HTTP request.
    * @see jpuppeteer.cdp.cdp.entity.network.RequestWillBeSentEvent
    */
    NETWORK_REQUESTWILLBESENT("Network.requestWillBeSent"),

    /**
    * Fired when resource loading priority is changed
    * @see jpuppeteer.cdp.cdp.entity.network.ResourceChangedPriorityEvent
    */
    NETWORK_RESOURCECHANGEDPRIORITY("Network.resourceChangedPriority"),

    /**
    * Fired when a signed exchange was received over the network
    * @see jpuppeteer.cdp.cdp.entity.network.SignedExchangeReceivedEvent
    */
    NETWORK_SIGNEDEXCHANGERECEIVED("Network.signedExchangeReceived"),

    /**
    * Fired when HTTP response is available.
    * @see jpuppeteer.cdp.cdp.entity.network.ResponseReceivedEvent
    */
    NETWORK_RESPONSERECEIVED("Network.responseReceived"),

    /**
    * Fired when WebSocket is closed.
    * @see jpuppeteer.cdp.cdp.entity.network.WebSocketClosedEvent
    */
    NETWORK_WEBSOCKETCLOSED("Network.webSocketClosed"),

    /**
    * Fired upon WebSocket creation.
    * @see jpuppeteer.cdp.cdp.entity.network.WebSocketCreatedEvent
    */
    NETWORK_WEBSOCKETCREATED("Network.webSocketCreated"),

    /**
    * Fired when WebSocket message error occurs.
    * @see jpuppeteer.cdp.cdp.entity.network.WebSocketFrameErrorEvent
    */
    NETWORK_WEBSOCKETFRAMEERROR("Network.webSocketFrameError"),

    /**
    * Fired when WebSocket message is received.
    * @see jpuppeteer.cdp.cdp.entity.network.WebSocketFrameReceivedEvent
    */
    NETWORK_WEBSOCKETFRAMERECEIVED("Network.webSocketFrameReceived"),

    /**
    * Fired when WebSocket message is sent.
    * @see jpuppeteer.cdp.cdp.entity.network.WebSocketFrameSentEvent
    */
    NETWORK_WEBSOCKETFRAMESENT("Network.webSocketFrameSent"),

    /**
    * Fired when WebSocket handshake response becomes available.
    * @see jpuppeteer.cdp.cdp.entity.network.WebSocketHandshakeResponseReceivedEvent
    */
    NETWORK_WEBSOCKETHANDSHAKERESPONSERECEIVED("Network.webSocketHandshakeResponseReceived"),

    /**
    * Fired when WebSocket is about to initiate handshake.
    * @see jpuppeteer.cdp.cdp.entity.network.WebSocketWillSendHandshakeRequestEvent
    */
    NETWORK_WEBSOCKETWILLSENDHANDSHAKEREQUEST("Network.webSocketWillSendHandshakeRequest"),

    /**
    * Fired when additional information about a requestWillBeSent event is available from the network stack. Not every requestWillBeSent event will have an additional requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent or requestWillBeSentExtraInfo will be fired first for the same request.
    * @see jpuppeteer.cdp.cdp.entity.network.RequestWillBeSentExtraInfoEvent
    */
    NETWORK_REQUESTWILLBESENTEXTRAINFO("Network.requestWillBeSentExtraInfo"),

    /**
    * Fired when additional information about a responseReceived event is available from the network stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for it, and responseReceivedExtraInfo may be fired before or after responseReceived.
    * @see jpuppeteer.cdp.cdp.entity.network.ResponseReceivedExtraInfoEvent
    */
    NETWORK_RESPONSERECEIVEDEXTRAINFO("Network.responseReceivedExtraInfo"),

    /**
    * Fired when the node should be inspected. This happens after call to `setInspectMode` or when user manually inspects an element.
    * @see jpuppeteer.cdp.cdp.entity.overlay.InspectNodeRequestedEvent
    */
    OVERLAY_INSPECTNODEREQUESTED("Overlay.inspectNodeRequested"),

    /**
    * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
    * @see jpuppeteer.cdp.cdp.entity.overlay.NodeHighlightRequestedEvent
    */
    OVERLAY_NODEHIGHLIGHTREQUESTED("Overlay.nodeHighlightRequested"),

    /**
    * Fired when user asks to capture screenshot of some area on the page.
    * @see jpuppeteer.cdp.cdp.entity.overlay.ScreenshotRequestedEvent
    */
    OVERLAY_SCREENSHOTREQUESTED("Overlay.screenshotRequested"),

    OVERLAY_INSPECTMODECANCELED("Overlay.inspectModeCanceled"),

    PAGE_DOMCONTENTEVENTFIRED("Page.domContentEventFired"),

    /**
    * Emitted only when `page.interceptFileChooser` is enabled.
    * @see jpuppeteer.cdp.cdp.entity.page.FileChooserOpenedEvent
    */
    PAGE_FILECHOOSEROPENED("Page.fileChooserOpened"),

    /**
    * Fired when frame has been attached to its parent.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameAttachedEvent
    */
    PAGE_FRAMEATTACHED("Page.frameAttached"),

    /**
    * Fired when frame no longer has a scheduled navigation.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameClearedScheduledNavigationEvent
    */
    PAGE_FRAMECLEAREDSCHEDULEDNAVIGATION("Page.frameClearedScheduledNavigation"),

    /**
    * Fired when frame has been detached from its parent.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameDetachedEvent
    */
    PAGE_FRAMEDETACHED("Page.frameDetached"),

    /**
    * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameNavigatedEvent
    */
    PAGE_FRAMENAVIGATED("Page.frameNavigated"),

    PAGE_FRAMERESIZED("Page.frameResized"),

    /**
    * Fired when a renderer-initiated navigation is requested. Navigation may still be cancelled after the event is issued.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameRequestedNavigationEvent
    */
    PAGE_FRAMEREQUESTEDNAVIGATION("Page.frameRequestedNavigation"),

    /**
    * Fired when frame schedules a potential navigation.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameScheduledNavigationEvent
    */
    PAGE_FRAMESCHEDULEDNAVIGATION("Page.frameScheduledNavigation"),

    /**
    * Fired when frame has started loading.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameStartedLoadingEvent
    */
    PAGE_FRAMESTARTEDLOADING("Page.frameStartedLoading"),

    /**
    * Fired when frame has stopped loading.
    * @see jpuppeteer.cdp.cdp.entity.page.FrameStoppedLoadingEvent
    */
    PAGE_FRAMESTOPPEDLOADING("Page.frameStoppedLoading"),

    /**
    * Fired when page is about to start a download.
    * @see jpuppeteer.cdp.cdp.entity.page.DownloadWillBeginEvent
    */
    PAGE_DOWNLOADWILLBEGIN("Page.downloadWillBegin"),

    PAGE_INTERSTITIALHIDDEN("Page.interstitialHidden"),

    PAGE_INTERSTITIALSHOWN("Page.interstitialShown"),

    /**
    * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
    * @see jpuppeteer.cdp.cdp.entity.page.JavascriptDialogClosedEvent
    */
    PAGE_JAVASCRIPTDIALOGCLOSED("Page.javascriptDialogClosed"),

    /**
    * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
    * @see jpuppeteer.cdp.cdp.entity.page.JavascriptDialogOpeningEvent
    */
    PAGE_JAVASCRIPTDIALOGOPENING("Page.javascriptDialogOpening"),

    /**
    * Fired for top level page lifecycle events such as navigation, load, paint, etc.
    * @see jpuppeteer.cdp.cdp.entity.page.LifecycleEvent
    */
    PAGE_LIFECYCLEEVENT("Page.lifecycleEvent"),

    PAGE_LOADEVENTFIRED("Page.loadEventFired"),

    /**
    * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
    * @see jpuppeteer.cdp.cdp.entity.page.NavigatedWithinDocumentEvent
    */
    PAGE_NAVIGATEDWITHINDOCUMENT("Page.navigatedWithinDocument"),

    /**
    * Compressed image data requested by the `startScreencast`.
    * @see jpuppeteer.cdp.cdp.entity.page.ScreencastFrameEvent
    */
    PAGE_SCREENCASTFRAME("Page.screencastFrame"),

    /**
    * Fired when the page with currently enabled screencast was shown or hidden `.
    * @see jpuppeteer.cdp.cdp.entity.page.ScreencastVisibilityChangedEvent
    */
    PAGE_SCREENCASTVISIBILITYCHANGED("Page.screencastVisibilityChanged"),

    /**
    * Fired when a new window is going to be opened, via window.open(), link click, form submission, etc.
    * @see jpuppeteer.cdp.cdp.entity.page.WindowOpenEvent
    */
    PAGE_WINDOWOPEN("Page.windowOpen"),

    /**
    * Issued for every compilation cache generated. Is only available if Page.setGenerateCompilationCache is enabled.
    * @see jpuppeteer.cdp.cdp.entity.page.CompilationCacheProducedEvent
    */
    PAGE_COMPILATIONCACHEPRODUCED("Page.compilationCacheProduced"),

    /**
    * Current values of the metrics.
    * @see jpuppeteer.cdp.cdp.entity.performance.MetricsEvent
    */
    PERFORMANCE_METRICS("Performance.metrics"),

    /**
    * There is a certificate error. If overriding certificate errors is enabled, then it should be handled with the `handleCertificateError` command. Note: this event does not fire if the certificate error has been allowed internally. Only one client per target should override certificate errors at the same time.
    * @see jpuppeteer.cdp.cdp.entity.security.CertificateErrorEvent
    */
    SECURITY_CERTIFICATEERROR("Security.certificateError"),

    /**
    * The security state of the page changed.
    * @see jpuppeteer.cdp.cdp.entity.security.SecurityStateChangedEvent
    */
    SECURITY_SECURITYSTATECHANGED("Security.securityStateChanged"),

    SERVICEWORKER_WORKERERRORREPORTED("ServiceWorker.workerErrorReported"),

    SERVICEWORKER_WORKERREGISTRATIONUPDATED("ServiceWorker.workerRegistrationUpdated"),

    SERVICEWORKER_WORKERVERSIONUPDATED("ServiceWorker.workerVersionUpdated"),

    /**
    * A cache's contents have been modified.
    * @see jpuppeteer.cdp.cdp.entity.storage.CacheStorageContentUpdatedEvent
    */
    STORAGE_CACHESTORAGECONTENTUPDATED("Storage.cacheStorageContentUpdated"),

    /**
    * A cache has been added/deleted.
    * @see jpuppeteer.cdp.cdp.entity.storage.CacheStorageListUpdatedEvent
    */
    STORAGE_CACHESTORAGELISTUPDATED("Storage.cacheStorageListUpdated"),

    /**
    * The origin's IndexedDB object store has been modified.
    * @see jpuppeteer.cdp.cdp.entity.storage.IndexedDBContentUpdatedEvent
    */
    STORAGE_INDEXEDDBCONTENTUPDATED("Storage.indexedDBContentUpdated"),

    /**
    * The origin's IndexedDB database list has been modified.
    * @see jpuppeteer.cdp.cdp.entity.storage.IndexedDBListUpdatedEvent
    */
    STORAGE_INDEXEDDBLISTUPDATED("Storage.indexedDBListUpdated"),

    /**
    * Issued when attached to target because of auto-attach or `attachToTarget` command.
    * @see jpuppeteer.cdp.cdp.entity.target.AttachedToTargetEvent
    */
    TARGET_ATTACHEDTOTARGET("Target.attachedToTarget"),

    /**
    * Issued when detached from target for any reason (including `detachFromTarget` command). Can be issued multiple times per target if multiple sessions have been attached to it.
    * @see jpuppeteer.cdp.cdp.entity.target.DetachedFromTargetEvent
    */
    TARGET_DETACHEDFROMTARGET("Target.detachedFromTarget"),

    /**
    * Notifies about a new protocol message received from the session (as reported in `attachedToTarget` event).
    * @see jpuppeteer.cdp.cdp.entity.target.ReceivedMessageFromTargetEvent
    */
    TARGET_RECEIVEDMESSAGEFROMTARGET("Target.receivedMessageFromTarget"),

    /**
    * Issued when a possible inspection target is created.
    * @see jpuppeteer.cdp.cdp.entity.target.TargetCreatedEvent
    */
    TARGET_TARGETCREATED("Target.targetCreated"),

    /**
    * Issued when a target is destroyed.
    * @see jpuppeteer.cdp.cdp.entity.target.TargetDestroyedEvent
    */
    TARGET_TARGETDESTROYED("Target.targetDestroyed"),

    /**
    * Issued when a target has crashed.
    * @see jpuppeteer.cdp.cdp.entity.target.TargetCrashedEvent
    */
    TARGET_TARGETCRASHED("Target.targetCrashed"),

    /**
    * Issued when some information about a target has changed. This only happens between `targetCreated` and `targetDestroyed`.
    * @see jpuppeteer.cdp.cdp.entity.target.TargetInfoChangedEvent
    */
    TARGET_TARGETINFOCHANGED("Target.targetInfoChanged"),

    /**
    * Informs that port was successfully bound and got a specified connection id.
    * @see jpuppeteer.cdp.cdp.entity.tethering.AcceptedEvent
    */
    TETHERING_ACCEPTED("Tethering.accepted"),

    TRACING_BUFFERUSAGE("Tracing.bufferUsage"),

    /**
    * Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
    * @see jpuppeteer.cdp.cdp.entity.tracing.DataCollectedEvent
    */
    TRACING_DATACOLLECTED("Tracing.dataCollected"),

    /**
    * Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
    * @see jpuppeteer.cdp.cdp.entity.tracing.TracingCompleteEvent
    */
    TRACING_TRACINGCOMPLETE("Tracing.tracingComplete"),

    /**
    * Issued when the domain is enabled and the request URL matches the specified filter. The request is paused until the client responds with one of continueRequest, failRequest or fulfillRequest. The stage of the request can be determined by presence of responseErrorReason and responseStatusCode -- the request is at the response stage if either of these fields is present and in the request stage otherwise.
    * @see jpuppeteer.cdp.cdp.entity.fetch.RequestPausedEvent
    */
    FETCH_REQUESTPAUSED("Fetch.requestPaused"),

    /**
    * Issued when the domain is enabled with handleAuthRequests set to true. The request is paused until client responds with continueWithAuth.
    * @see jpuppeteer.cdp.cdp.entity.fetch.AuthRequiredEvent
    */
    FETCH_AUTHREQUIRED("Fetch.authRequired"),

    /**
    * Notifies that a new BaseAudioContext has been created.
    * @see jpuppeteer.cdp.cdp.entity.webaudio.ContextCreatedEvent
    */
    WEBAUDIO_CONTEXTCREATED("WebAudio.contextCreated"),

    /**
    * Notifies that an existing BaseAudioContext will be destroyed.
    * @see jpuppeteer.cdp.cdp.entity.webaudio.ContextWillBeDestroyedEvent
    */
    WEBAUDIO_CONTEXTWILLBEDESTROYED("WebAudio.contextWillBeDestroyed"),

    /**
    * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
    * @see jpuppeteer.cdp.cdp.entity.webaudio.ContextChangedEvent
    */
    WEBAUDIO_CONTEXTCHANGED("WebAudio.contextChanged"),

    /**
    * Issued when new console message is added.
    * @see jpuppeteer.cdp.cdp.entity.console.MessageAddedEvent
    */
    CONSOLE_MESSAGEADDED("Console.messageAdded"),

    /**
    * Fired when breakpoint is resolved to an actual script and location.
    * @see jpuppeteer.cdp.cdp.entity.debugger.BreakpointResolvedEvent
    */
    DEBUGGER_BREAKPOINTRESOLVED("Debugger.breakpointResolved"),

    /**
    * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
    * @see jpuppeteer.cdp.cdp.entity.debugger.PausedEvent
    */
    DEBUGGER_PAUSED("Debugger.paused"),

    DEBUGGER_RESUMED("Debugger.resumed"),

    /**
    * Fired when virtual machine fails to parse the script.
    * @see jpuppeteer.cdp.cdp.entity.debugger.ScriptFailedToParseEvent
    */
    DEBUGGER_SCRIPTFAILEDTOPARSE("Debugger.scriptFailedToParse"),

    /**
    * Fired when virtual machine parses script. This event is also fired for all known and uncollected scripts upon enabling debugger.
    * @see jpuppeteer.cdp.cdp.entity.debugger.ScriptParsedEvent
    */
    DEBUGGER_SCRIPTPARSED("Debugger.scriptParsed"),

    HEAPPROFILER_ADDHEAPSNAPSHOTCHUNK("HeapProfiler.addHeapSnapshotChunk"),

    /**
    * If heap objects tracking has been started then backend may send update for one or more fragments
    * @see jpuppeteer.cdp.cdp.entity.heapprofiler.HeapStatsUpdateEvent
    */
    HEAPPROFILER_HEAPSTATSUPDATE("HeapProfiler.heapStatsUpdate"),

    /**
    * If heap objects tracking has been started then backend regularly sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
    * @see jpuppeteer.cdp.cdp.entity.heapprofiler.LastSeenObjectIdEvent
    */
    HEAPPROFILER_LASTSEENOBJECTID("HeapProfiler.lastSeenObjectId"),

    HEAPPROFILER_REPORTHEAPSNAPSHOTPROGRESS("HeapProfiler.reportHeapSnapshotProgress"),

    HEAPPROFILER_RESETPROFILES("HeapProfiler.resetProfiles"),

    PROFILER_CONSOLEPROFILEFINISHED("Profiler.consoleProfileFinished"),

    /**
    * Sent when new profile recording is started using console.profile() call.
    * @see jpuppeteer.cdp.cdp.entity.profiler.ConsoleProfileStartedEvent
    */
    PROFILER_CONSOLEPROFILESTARTED("Profiler.consoleProfileStarted"),

    /**
    * Notification is issued every time when binding is called.
    * @see jpuppeteer.cdp.cdp.entity.runtime.BindingCalledEvent
    */
    RUNTIME_BINDINGCALLED("Runtime.bindingCalled"),

    /**
    * Issued when console API was called.
    * @see jpuppeteer.cdp.cdp.entity.runtime.ConsoleAPICalledEvent
    */
    RUNTIME_CONSOLEAPICALLED("Runtime.consoleAPICalled"),

    /**
    * Issued when unhandled exception was revoked.
    * @see jpuppeteer.cdp.cdp.entity.runtime.ExceptionRevokedEvent
    */
    RUNTIME_EXCEPTIONREVOKED("Runtime.exceptionRevoked"),

    /**
    * Issued when exception was thrown and unhandled.
    * @see jpuppeteer.cdp.cdp.entity.runtime.ExceptionThrownEvent
    */
    RUNTIME_EXCEPTIONTHROWN("Runtime.exceptionThrown"),

    /**
    * Issued when new execution context is created.
    * @see jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextCreatedEvent
    */
    RUNTIME_EXECUTIONCONTEXTCREATED("Runtime.executionContextCreated"),

    /**
    * Issued when execution context is destroyed.
    * @see jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextDestroyedEvent
    */
    RUNTIME_EXECUTIONCONTEXTDESTROYED("Runtime.executionContextDestroyed"),

    RUNTIME_EXECUTIONCONTEXTSCLEARED("Runtime.executionContextsCleared"),

    /**
    * Issued when object should be inspected (for example, as a result of inspect() command line API call).
    * @see jpuppeteer.cdp.cdp.entity.runtime.InspectRequestedEvent
    */
    RUNTIME_INSPECTREQUESTED("Runtime.inspectRequested"),

    ;

    private String value;

    CDPEventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
}

    public static CDPEventType findByValue(String value) {
        for(CDPEventType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}