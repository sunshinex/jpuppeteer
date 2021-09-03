package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class StartRequest {

    /**
    * Category/tag filter
    */
    public final String categories;

    /**
    * Tracing options
    */
    public final String options;

    /**
    * If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
    */
    public final java.math.BigDecimal bufferUsageReportingInterval;

    /**
    * Whether to report trace events as series of dataCollected events or to save trace to a stream (defaults to `ReportEvents`).
    */
    public final jpuppeteer.cdp.client.constant.tracing.StartRequestTransferMode transferMode;

    /**
    * Trace data format to use. This only applies when using `ReturnAsStream` transfer mode (defaults to `json`).
    */
    public final jpuppeteer.cdp.client.constant.tracing.StreamFormat streamFormat;

    /**
    * Compression format to use. This only applies when using `ReturnAsStream` transfer mode (defaults to `none`)
    */
    public final jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression;

    /**
    */
    public final jpuppeteer.cdp.client.entity.tracing.TraceConfig traceConfig;

    /**
    * Base64-encoded serialized perfetto.protos.TraceConfig protobuf message When specified, the parameters `categories`, `options`, `traceConfig` are ignored. (Encoded as a base64 string when passed over JSON)
    */
    public final String perfettoConfig;

    /**
    * Backend type (defaults to `auto`)
    */
    public final jpuppeteer.cdp.client.constant.tracing.TracingBackend tracingBackend;

    public StartRequest(String categories, String options, java.math.BigDecimal bufferUsageReportingInterval, jpuppeteer.cdp.client.constant.tracing.StartRequestTransferMode transferMode, jpuppeteer.cdp.client.constant.tracing.StreamFormat streamFormat, jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression, jpuppeteer.cdp.client.entity.tracing.TraceConfig traceConfig, String perfettoConfig, jpuppeteer.cdp.client.constant.tracing.TracingBackend tracingBackend) {
        this.categories = categories;
        this.options = options;
        this.bufferUsageReportingInterval = bufferUsageReportingInterval;
        this.transferMode = transferMode;
        this.streamFormat = streamFormat;
        this.streamCompression = streamCompression;
        this.traceConfig = traceConfig;
        this.perfettoConfig = perfettoConfig;
        this.tracingBackend = tracingBackend;
    }

    public StartRequest() {
        this.categories = null;
        this.options = null;
        this.bufferUsageReportingInterval = null;
        this.transferMode = null;
        this.streamFormat = null;
        this.streamCompression = null;
        this.traceConfig = null;
        this.perfettoConfig = null;
        this.tracingBackend = null;
    }

}