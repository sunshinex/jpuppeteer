package jpuppeteer.cdp.client.entity.tracing;

/**
* Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
* experimental
*/
public class TracingCompleteEvent {

    /**
    * Indicates whether some trace data is known to have been lost, e.g. because the trace ring buffer wrapped around.
    */
    public final Boolean dataLossOccurred;

    /**
    * A handle of the stream that holds resulting trace data.
    */
    public final String stream;

    /**
    * Trace data format of returned stream.
    */
    public final String traceFormat;

    /**
    * Compression format of returned stream.
    */
    public final String streamCompression;

    public TracingCompleteEvent(Boolean dataLossOccurred, String stream, String traceFormat, String streamCompression) {
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

}