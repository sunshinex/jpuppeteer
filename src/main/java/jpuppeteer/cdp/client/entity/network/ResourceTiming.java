package jpuppeteer.cdp.client.entity.network;

/**
* Timing information for the request.
*/
public class ResourceTiming {

    /**
    * Timing's requestTime is a baseline in seconds, while the other numbers are ticks in milliseconds relatively to this requestTime.
    */
    public final java.math.BigDecimal requestTime;

    /**
    * Started resolving proxy.
    */
    public final java.math.BigDecimal proxyStart;

    /**
    * Finished resolving proxy.
    */
    public final java.math.BigDecimal proxyEnd;

    /**
    * Started DNS address resolve.
    */
    public final java.math.BigDecimal dnsStart;

    /**
    * Finished DNS address resolve.
    */
    public final java.math.BigDecimal dnsEnd;

    /**
    * Started connecting to the remote host.
    */
    public final java.math.BigDecimal connectStart;

    /**
    * Connected to the remote host.
    */
    public final java.math.BigDecimal connectEnd;

    /**
    * Started SSL handshake.
    */
    public final java.math.BigDecimal sslStart;

    /**
    * Finished SSL handshake.
    */
    public final java.math.BigDecimal sslEnd;

    /**
    * Started running ServiceWorker.
    */
    public final java.math.BigDecimal workerStart;

    /**
    * Finished Starting ServiceWorker.
    */
    public final java.math.BigDecimal workerReady;

    /**
    * Started fetch event.
    */
    public final java.math.BigDecimal workerFetchStart;

    /**
    * Settled fetch event respondWith promise.
    */
    public final java.math.BigDecimal workerRespondWithSettled;

    /**
    * Started sending request.
    */
    public final java.math.BigDecimal sendStart;

    /**
    * Finished sending request.
    */
    public final java.math.BigDecimal sendEnd;

    /**
    * Time the server started pushing request.
    */
    public final java.math.BigDecimal pushStart;

    /**
    * Time the server finished pushing request.
    */
    public final java.math.BigDecimal pushEnd;

    /**
    * Finished receiving response headers.
    */
    public final java.math.BigDecimal receiveHeadersEnd;

    public ResourceTiming(java.math.BigDecimal requestTime, java.math.BigDecimal proxyStart, java.math.BigDecimal proxyEnd, java.math.BigDecimal dnsStart, java.math.BigDecimal dnsEnd, java.math.BigDecimal connectStart, java.math.BigDecimal connectEnd, java.math.BigDecimal sslStart, java.math.BigDecimal sslEnd, java.math.BigDecimal workerStart, java.math.BigDecimal workerReady, java.math.BigDecimal workerFetchStart, java.math.BigDecimal workerRespondWithSettled, java.math.BigDecimal sendStart, java.math.BigDecimal sendEnd, java.math.BigDecimal pushStart, java.math.BigDecimal pushEnd, java.math.BigDecimal receiveHeadersEnd) {
        this.requestTime = requestTime;
        this.proxyStart = proxyStart;
        this.proxyEnd = proxyEnd;
        this.dnsStart = dnsStart;
        this.dnsEnd = dnsEnd;
        this.connectStart = connectStart;
        this.connectEnd = connectEnd;
        this.sslStart = sslStart;
        this.sslEnd = sslEnd;
        this.workerStart = workerStart;
        this.workerReady = workerReady;
        this.workerFetchStart = workerFetchStart;
        this.workerRespondWithSettled = workerRespondWithSettled;
        this.sendStart = sendStart;
        this.sendEnd = sendEnd;
        this.pushStart = pushStart;
        this.pushEnd = pushEnd;
        this.receiveHeadersEnd = receiveHeadersEnd;
    }

}