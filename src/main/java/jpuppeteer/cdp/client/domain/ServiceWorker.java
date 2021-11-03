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
    public io.netty.util.concurrent.Future deliverPushMessage(jpuppeteer.cdp.client.entity.serviceworker.DeliverPushMessageRequest request) {
        return connection.send("ServiceWorker.deliverPushMessage", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("ServiceWorker.disable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future dispatchSyncEvent(jpuppeteer.cdp.client.entity.serviceworker.DispatchSyncEventRequest request) {
        return connection.send("ServiceWorker.dispatchSyncEvent", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future dispatchPeriodicSyncEvent(jpuppeteer.cdp.client.entity.serviceworker.DispatchPeriodicSyncEventRequest request) {
        return connection.send("ServiceWorker.dispatchPeriodicSyncEvent", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("ServiceWorker.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future inspectWorker(jpuppeteer.cdp.client.entity.serviceworker.InspectWorkerRequest request) {
        return connection.send("ServiceWorker.inspectWorker", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future setForceUpdateOnPageLoad(jpuppeteer.cdp.client.entity.serviceworker.SetForceUpdateOnPageLoadRequest request) {
        return connection.send("ServiceWorker.setForceUpdateOnPageLoad", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future skipWaiting(jpuppeteer.cdp.client.entity.serviceworker.SkipWaitingRequest request) {
        return connection.send("ServiceWorker.skipWaiting", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future startWorker(jpuppeteer.cdp.client.entity.serviceworker.StartWorkerRequest request) {
        return connection.send("ServiceWorker.startWorker", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future stopAllWorkers() {
        return connection.send("ServiceWorker.stopAllWorkers", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future stopWorker(jpuppeteer.cdp.client.entity.serviceworker.StopWorkerRequest request) {
        return connection.send("ServiceWorker.stopWorker", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future unregister(jpuppeteer.cdp.client.entity.serviceworker.UnregisterRequest request) {
        return connection.send("ServiceWorker.unregister", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future updateRegistration(jpuppeteer.cdp.client.entity.serviceworker.UpdateRegistrationRequest request) {
        return connection.send("ServiceWorker.updateRegistration", request);
    }

}