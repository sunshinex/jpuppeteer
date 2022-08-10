package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class ServiceWorker {

    private jpuppeteer.cdp.CDPConnection connection;

    public ServiceWorker(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    */
    public jpuppeteer.util.XFuture<?> deliverPushMessage(jpuppeteer.cdp.client.entity.serviceworker.DeliverPushMessageRequest request) {
        return connection.send("ServiceWorker.deliverPushMessage", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("ServiceWorker.disable", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> dispatchSyncEvent(jpuppeteer.cdp.client.entity.serviceworker.DispatchSyncEventRequest request) {
        return connection.send("ServiceWorker.dispatchSyncEvent", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> dispatchPeriodicSyncEvent(jpuppeteer.cdp.client.entity.serviceworker.DispatchPeriodicSyncEventRequest request) {
        return connection.send("ServiceWorker.dispatchPeriodicSyncEvent", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("ServiceWorker.enable", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> inspectWorker(jpuppeteer.cdp.client.entity.serviceworker.InspectWorkerRequest request) {
        return connection.send("ServiceWorker.inspectWorker", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> setForceUpdateOnPageLoad(jpuppeteer.cdp.client.entity.serviceworker.SetForceUpdateOnPageLoadRequest request) {
        return connection.send("ServiceWorker.setForceUpdateOnPageLoad", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> skipWaiting(jpuppeteer.cdp.client.entity.serviceworker.SkipWaitingRequest request) {
        return connection.send("ServiceWorker.skipWaiting", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> startWorker(jpuppeteer.cdp.client.entity.serviceworker.StartWorkerRequest request) {
        return connection.send("ServiceWorker.startWorker", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> stopAllWorkers() {
        return connection.send("ServiceWorker.stopAllWorkers", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> stopWorker(jpuppeteer.cdp.client.entity.serviceworker.StopWorkerRequest request) {
        return connection.send("ServiceWorker.stopWorker", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> unregister(jpuppeteer.cdp.client.entity.serviceworker.UnregisterRequest request) {
        return connection.send("ServiceWorker.unregister", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> updateRegistration(jpuppeteer.cdp.client.entity.serviceworker.UpdateRegistrationRequest request) {
        return connection.send("ServiceWorker.updateRegistration", request);
    }

}