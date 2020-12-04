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
    public final String transferMode;

    /**
    * Trace data format to use. This only applies when using `ReturnAsStream` transfer mode (defaults to `json`).
    */
    public final String streamFormat;

    /**
    * Compression format to use. This only applies when using `ReturnAsStream` transfer mode (defaults to `none`)
    */
    public final String streamCompression;

    /**
    */
    public final jpuppeteer.cdp.client.entity.tracing.TraceConfig traceConfig;

    public StartRequest(String categories, String options, java.math.BigDecimal bufferUsageReportingInterval, String transferMode, String streamFormat, String streamCompression, jpuppeteer.cdp.client.entity.tracing.TraceConfig traceConfig) {
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