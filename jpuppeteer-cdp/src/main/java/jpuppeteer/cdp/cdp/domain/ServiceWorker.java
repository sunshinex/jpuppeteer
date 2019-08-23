package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class ServiceWorker {

    private jpuppeteer.cdp.CDPSession session;

    public ServiceWorker(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * experimental
    */
    public void deliverPushMessage(jpuppeteer.cdp.cdp.entity.serviceworker.DeliverPushMessageRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.deliverPushMessage", request, timeout);
    }


    /**
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("ServiceWorker.disable", null, timeout);
    }


    /**
    * experimental
    */
    public void dispatchSyncEvent(jpuppeteer.cdp.cdp.entity.serviceworker.DispatchSyncEventRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.dispatchSyncEvent", request, timeout);
    }


    /**
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("ServiceWorker.enable", null, timeout);
    }


    /**
    * experimental
    */
    public void inspectWorker(jpuppeteer.cdp.cdp.entity.serviceworker.InspectWorkerRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.inspectWorker", request, timeout);
    }


    /**
    * experimental
    */
    public void setForceUpdateOnPageLoad(jpuppeteer.cdp.cdp.entity.serviceworker.SetForceUpdateOnPageLoadRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.setForceUpdateOnPageLoad", request, timeout);
    }


    /**
    * experimental
    */
    public void skipWaiting(jpuppeteer.cdp.cdp.entity.serviceworker.SkipWaitingRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.skipWaiting", request, timeout);
    }


    /**
    * experimental
    */
    public void startWorker(jpuppeteer.cdp.cdp.entity.serviceworker.StartWorkerRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.startWorker", request, timeout);
    }


    /**
    * experimental
    */
    public void stopAllWorkers(int timeout) throws Exception {
        session.send("ServiceWorker.stopAllWorkers", null, timeout);
    }


    /**
    * experimental
    */
    public void stopWorker(jpuppeteer.cdp.cdp.entity.serviceworker.StopWorkerRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.stopWorker", request, timeout);
    }


    /**
    * experimental
    */
    public void unregister(jpuppeteer.cdp.cdp.entity.serviceworker.UnregisterRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.unregister", request, timeout);
    }


    /**
    * experimental
    */
    public void updateRegistration(jpuppeteer.cdp.cdp.entity.serviceworker.UpdateRegistrationRequest request, int timeout) throws Exception {
        session.send("ServiceWorker.updateRegistration", request, timeout);
    }

}