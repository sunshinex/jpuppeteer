package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class StartRequest {

    /**
    * Category/tag filter
    */
    private String categories;

    /**
    * Tracing options
    */
    private String options;

    /**
    * If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
    */
    private java.math.BigDecimal bufferUsageReportingInterval;

    /**
    * Whether to report trace events as series of dataCollected events or to save trace to a stream (defaults to `ReportEvents`).
    */
    private jpuppeteer.cdp.client.constant.tracing.StartRequestTransferMode transferMode;

    /**
    * Trace data format to use. This only applies when using `ReturnAsStream` transfer mode (defaults to `json`).
    */
    private jpuppeteer.cdp.client.constant.tracing.StreamFormat streamFormat;

    /**
    * Compression format to use. This only applies when using `ReturnAsStream` transfer mode (defaults to `none`)
    */
    private jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression;

    /**
    */
    private jpuppeteer.cdp.client.entity.tracing.TraceConfig traceConfig;

    /**
    * Base64-encoded serialized perfetto.protos.TraceConfig protobuf message When specified, the parameters `categories`, `options`, `traceConfig` are ignored. (Encoded as a base64 string when passed over JSON)
    */
    private String perfettoConfig;

    /**
    * Backend type (defaults to `auto`)
    */
    private jpuppeteer.cdp.client.constant.tracing.TracingBackend tracingBackend;

    public void setCategories (String categories) {
        this.categories = categories;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setOptions (String options) {
        this.options = options;
    }

    public String getOptions() {
        return this.options;
    }

    public void setBufferUsageReportingInterval (java.math.BigDecimal bufferUsageReportingInterval) {
        this.bufferUsageReportingInterval = bufferUsageReportingInterval;
    }

    public java.math.BigDecimal getBufferUsageReportingInterval() {
        return this.bufferUsageReportingInterval;
    }

    public void setTransferMode (jpuppeteer.cdp.client.constant.tracing.StartRequestTransferMode transferMode) {
        this.transferMode = transferMode;
    }

    public jpuppeteer.cdp.client.constant.tracing.StartRequestTransferMode getTransferMode() {
        return this.transferMode;
    }

    public void setStreamFormat (jpuppeteer.cdp.client.constant.tracing.StreamFormat streamFormat) {
        this.streamFormat = streamFormat;
    }

    public jpuppeteer.cdp.client.constant.tracing.StreamFormat getStreamFormat() {
        return this.streamFormat;
    }

    public void setStreamCompression (jpuppeteer.cdp.client.constant.tracing.StreamCompression streamCompression) {
        this.streamCompression = streamCompression;
    }

    public jpuppeteer.cdp.client.constant.tracing.StreamCompression getStreamCompression() {
        return this.streamCompression;
    }

    public void setTraceConfig (jpuppeteer.cdp.client.entity.tracing.TraceConfig traceConfig) {
        this.traceConfig = traceConfig;
    }

    public jpuppeteer.cdp.client.entity.tracing.TraceConfig getTraceConfig() {
        return this.traceConfig;
    }

    public void setPerfettoConfig (String perfettoConfig) {
        this.perfettoConfig = perfettoConfig;
    }

    public String getPerfettoConfig() {
        return this.perfettoConfig;
    }

    public void setTracingBackend (jpuppeteer.cdp.client.constant.tracing.TracingBackend tracingBackend) {
        this.tracingBackend = tracingBackend;
    }

    public jpuppeteer.cdp.client.constant.tracing.TracingBackend getTracingBackend() {
        return this.tracingBackend;
    }

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