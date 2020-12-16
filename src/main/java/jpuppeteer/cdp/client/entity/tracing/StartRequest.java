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
    public final TraceConfig traceConfig;

    public StartRequest(String categories, String options, java.math.BigDecimal bufferUsageReportingInterval, jpuppeteer.cdp.client.constant.tracing.StartRequestTransferMode transferMode, jpuppeteer.cdp.client.constant.tracing.StreamFormat streamFormat, jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression, TraceConfig traceConfig) {
        this.categories = categories;
        this.options = options;
        this.bufferUsageReportingInterval = bufferUsageReportingInterval;
        this.transferMode = transferMode;
        this.streamFormat = streamFormat;
        this.streamCompression = streamCompression;
        this.traceConfig = traceConfig;
    }

    public StartRequest() {
        this.categories = null;
        this.options = null;
        this.bufferUsageReportingInterval = null;
        this.transferMode = null;
        this.streamFormat = null;
        this.streamCompression = null;
        this.traceConfig = null;
    }

}