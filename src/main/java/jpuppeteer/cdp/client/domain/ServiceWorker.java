package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class ServiceWorker {

    private jpuppeteer.cdp.CDPSession session;

    public ServiceWorker(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    */
    public io.netty.util.concurrent.Future deliverPushMessage(jpuppeteer.cdp.client.entity.serviceworker.DeliverPushMessageRequest request) {
        return session.send("ServiceWorker.deliverPushMessage", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("ServiceWorker.disable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future dispatchSyncEvent(jpuppeteer.cdp.client.entity.serviceworker.DispatchSyncEventRequest request) {
        return session.send("ServiceWorker.dispatchSyncEvent", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future dispatchPeriodicSyncEvent(jpuppeteer.cdp.client.entity.serviceworker.DispatchPeriodicSyncEventRequest request) {
        return session.send("ServiceWorker.dispatchPeriodicSyncEvent", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("ServiceWorker.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future inspectWorker(jpuppeteer.cdp.client.entity.serviceworker.InspectWorkerRequest request) {
        return session.send("ServiceWorker.inspectWorker", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future setForceUpdateOnPageLoad(jpuppeteer.cdp.client.entity.serviceworker.SetForceUpdateOnPageLoadRequest request) {
        return session.send("ServiceWorker.setForceUpdateOnPageLoad", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future skipWaiting(jpuppeteer.cdp.client.entity.serviceworker.SkipWaitingRequest request) {
        return session.send("ServiceWorker.skipWaiting", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future startWorker(jpuppeteer.cdp.client.entity.serviceworker.StartWorkerRequest request) {
        return session.send("ServiceWorker.startWorker", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future stopAllWorkers() {
        return session.send("ServiceWorker.stopAllWorkers", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future stopWorker(jpuppeteer.cdp.client.entity.serviceworker.StopWorkerRequest request) {
        return session.send("ServiceWorker.stopWorker", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future unregister(jpuppeteer.cdp.client.entity.serviceworker.UnregisterRequest request) {
        return session.send("ServiceWorker.unregister", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future updateRegistration(jpuppeteer.cdp.client.entity.serviceworker.UpdateRegistrationRequest request) {
        return session.send("ServiceWorker.updateRegistration", request);
    }

}