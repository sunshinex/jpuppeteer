package jpuppeteer.cdp.client.entity.network;

/**
* Timing information for the request.
*/
public class ResourceTiming {

    /**
    * Timing's requestTime is a baseline in seconds, while the other numbers are ticks in milliseconds relatively to this requestTime.
    */
    private java.math.BigDecimal requestTime;

    /**
    * Started resolving proxy.
    */
    private java.math.BigDecimal proxyStart;

    /**
    * Finished resolving proxy.
    */
    private java.math.BigDecimal proxyEnd;

    /**
    * Started DNS address resolve.
    */
    private java.math.BigDecimal dnsStart;

    /**
    * Finished DNS address resolve.
    */
    private java.math.BigDecimal dnsEnd;

    /**
    * Started connecting to the remote host.
    */
    private java.math.BigDecimal connectStart;

    /**
    * Connected to the remote host.
    */
    private java.math.BigDecimal connectEnd;

    /**
    * Started SSL handshake.
    */
    private java.math.BigDecimal sslStart;

    /**
    * Finished SSL handshake.
    */
    private java.math.BigDecimal sslEnd;

    /**
    * Started running ServiceWorker.
    */
    private java.math.BigDecimal workerStart;

    /**
    * Finished Starting ServiceWorker.
    */
    private java.math.BigDecimal workerReady;

    /**
    * Started fetch event.
    */
    private java.math.BigDecimal workerFetchStart;

    /**
    * Settled fetch event respondWith promise.
    */
    private java.math.BigDecimal workerRespondWithSettled;

    /**
    * Started sending request.
    */
    private java.math.BigDecimal sendStart;

    /**
    * Finished sending request.
    */
    private java.math.BigDecimal sendEnd;

    /**
    * Time the server started pushing request.
    */
    private java.math.BigDecimal pushStart;

    /**
    * Time the server finished pushing request.
    */
    private java.math.BigDecimal pushEnd;

    /**
    * Finished receiving response headers.
    */
    private java.math.BigDecimal receiveHeadersEnd;

    public void setRequestTime (java.math.BigDecimal requestTime) {
        this.requestTime = requestTime;
    }

    public java.math.BigDecimal getRequestTime() {
        return this.requestTime;
    }

    public void setProxyStart (java.math.BigDecimal proxyStart) {
        this.proxyStart = proxyStart;
    }

    public java.math.BigDecimal getProxyStart() {
        return this.proxyStart;
    }

    public void setProxyEnd (java.math.BigDecimal proxyEnd) {
        this.proxyEnd = proxyEnd;
    }

    public java.math.BigDecimal getProxyEnd() {
        return this.proxyEnd;
    }

    public void setDnsStart (java.math.BigDecimal dnsStart) {
        this.dnsStart = dnsStart;
    }

    public java.math.BigDecimal getDnsStart() {
        return this.dnsStart;
    }

    public void setDnsEnd (java.math.BigDecimal dnsEnd) {
        this.dnsEnd = dnsEnd;
    }

    public java.math.BigDecimal getDnsEnd() {
        return this.dnsEnd;
    }

    public void setConnectStart (java.math.BigDecimal connectStart) {
        this.connectStart = connectStart;
    }

    public java.math.BigDecimal getConnectStart() {
        return this.connectStart;
    }

    public void setConnectEnd (java.math.BigDecimal connectEnd) {
        this.connectEnd = connectEnd;
    }

    public java.math.BigDecimal getConnectEnd() {
        return this.connectEnd;
    }

    public void setSslStart (java.math.BigDecimal sslStart) {
        this.sslStart = sslStart;
    }

    public java.math.BigDecimal getSslStart() {
        return this.sslStart;
    }

    public void setSslEnd (java.math.BigDecimal sslEnd) {
        this.sslEnd = sslEnd;
    }

    public java.math.BigDecimal getSslEnd() {
        return this.sslEnd;
    }

    public void setWorkerStart (java.math.BigDecimal workerStart) {
        this.workerStart = workerStart;
    }

    public java.math.BigDecimal getWorkerStart() {
        return this.workerStart;
    }

    public void setWorkerReady (java.math.BigDecimal workerReady) {
        this.workerReady = workerReady;
    }

    public java.math.BigDecimal getWorkerReady() {
        return this.workerReady;
    }

    public void setWorkerFetchStart (java.math.BigDecimal workerFetchStart) {
        this.workerFetchStart = workerFetchStart;
    }

    public java.math.BigDecimal getWorkerFetchStart() {
        return this.workerFetchStart;
    }

    public void setWorkerRespondWithSettled (java.math.BigDecimal workerRespondWithSettled) {
        this.workerRespondWithSettled = workerRespondWithSettled;
    }

    public java.math.BigDecimal getWorkerRespondWithSettled() {
        return this.workerRespondWithSettled;
    }

    public void setSendStart (java.math.BigDecimal sendStart) {
        this.sendStart = sendStart;
    }

    public java.math.BigDecimal getSendStart() {
        return this.sendStart;
    }

    public void setSendEnd (java.math.BigDecimal sendEnd) {
        this.sendEnd = sendEnd;
    }

    public java.math.BigDecimal getSendEnd() {
        return this.sendEnd;
    }

    public void setPushStart (java.math.BigDecimal pushStart) {
        this.pushStart = pushStart;
    }

    public java.math.BigDecimal getPushStart() {
        return this.pushStart;
    }

    public void setPushEnd (java.math.BigDecimal pushEnd) {
        this.pushEnd = pushEnd;
    }

    public java.math.BigDecimal getPushEnd() {
        return this.pushEnd;
    }

    public void setReceiveHeadersEnd (java.math.BigDecimal receiveHeadersEnd) {
        this.receiveHeadersEnd = receiveHeadersEnd;
    }

    public java.math.BigDecimal getReceiveHeadersEnd() {
        return this.receiveHeadersEnd;
    }

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

    public ResourceTiming() {
    }

}