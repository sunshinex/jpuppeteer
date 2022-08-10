package jpuppeteer.cdp.client.entity.tracing;

/**
* Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
* experimental
*/
public class TracingCompleteEvent {

    /**
    * Indicates whether some trace data is known to have been lost, e.g. because the trace ring buffer wrapped around.
    */
    private Boolean dataLossOccurred;

    /**
    * A handle of the stream that holds resulting trace data.
    */
    private String stream;

    /**
    * Trace data format of returned stream.
    */
    private jpuppeteer.cdp.client.constant.tracing.StreamFormat traceFormat;

    /**
    * Compression format of returned stream.
    */
    private jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression;

    public void setDataLossOccurred (Boolean dataLossOccurred) {
        this.dataLossOccurred = dataLossOccurred;
    }

    public Boolean getDataLossOccurred() {
        return this.dataLossOccurred;
    }

    public void setStream (String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return this.stream;
    }

    public void setTraceFormat (jpuppeteer.cdp.client.constant.tracing.StreamFormat traceFormat) {
        this.traceFormat = traceFormat;
    }

    public jpuppeteer.cdp.client.constant.tracing.StreamFormat getTraceFormat() {
        return this.traceFormat;
    }

    public void setStreamCompression (jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression) {
        this.streamCompression = streamCompression;
    }

    public jpuppeteer.cdp.client.constant.tracing.StreamCompression getStreamCompression() {
        return this.streamCompression;
    }

    public TracingCompleteEvent(Boolean dataLossOccurred, String stream, jpuppeteer.cdp.client.constant.tracing.StreamFormat traceFormat, jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression) {
        this.dataLossOccurred = dataLossOccurred;
        this.stream = stream;
        this.traceFormat = traceFormat;
        this.streamCompression = streamCompression;
    }

    public TracingCompleteEvent(Boolean dataLossOccurred) {
        this.dataLossOccurred = dataLossOccurred;
        this.stream = null;
        this.traceFormat = null;
        this.streamCompression = null;
    }

    public TracingCompleteEvent() {
    }

}