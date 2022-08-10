package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class TraceConfig {

    /**
    * Controls how the trace buffer stores data.
    */
    private jpuppeteer.cdp.client.constant.tracing.TraceConfigRecordMode recordMode;

    /**
    * Turns on JavaScript stack sampling.
    */
    private Boolean enableSampling;

    /**
    * Turns on system tracing.
    */
    private Boolean enableSystrace;

    /**
    * Turns on argument filter.
    */
    private Boolean enableArgumentFilter;

    /**
    * Included category filters.
    */
    private java.util.List<String> includedCategories;

    /**
    * Excluded category filters.
    */
    private java.util.List<String> excludedCategories;

    /**
    * Configuration to synthesize the delays in tracing.
    */
    private java.util.List<String> syntheticDelays;

    /**
    * Configuration for memory dump triggers. Used only when "memory-infra" category is enabled.
    */
    private java.util.Map<String, Object> memoryDumpConfig;

    public void setRecordMode (jpuppeteer.cdp.client.constant.tracing.TraceConfigRecordMode recordMode) {
        this.recordMode = recordMode;
    }

    public jpuppeteer.cdp.client.constant.tracing.TraceConfigRecordMode getRecordMode() {
        return this.recordMode;
    }

    public void setEnableSampling (Boolean enableSampling) {
        this.enableSampling = enableSampling;
    }

    public Boolean getEnableSampling() {
        return this.enableSampling;
    }

    public void setEnableSystrace (Boolean enableSystrace) {
        this.enableSystrace = enableSystrace;
    }

    public Boolean getEnableSystrace() {
        return this.enableSystrace;
    }

    public void setEnableArgumentFilter (Boolean enableArgumentFilter) {
        this.enableArgumentFilter = enableArgumentFilter;
    }

    public Boolean getEnableArgumentFilter() {
        return this.enableArgumentFilter;
    }

    public void setIncludedCategories (java.util.List<String> includedCategories) {
        this.includedCategories = includedCategories;
    }

    public java.util.List<String> getIncludedCategories() {
        return this.includedCategories;
    }

    public void setExcludedCategories (java.util.List<String> excludedCategories) {
        this.excludedCategories = excludedCategories;
    }

    public java.util.List<String> getExcludedCategories() {
        return this.excludedCategories;
    }

    public void setSyntheticDelays (java.util.List<String> syntheticDelays) {
        this.syntheticDelays = syntheticDelays;
    }

    public java.util.List<String> getSyntheticDelays() {
        return this.syntheticDelays;
    }

    public void setMemoryDumpConfig (java.util.Map<String, Object> memoryDumpConfig) {
        this.memoryDumpConfig = memoryDumpConfig;
    }

    public java.util.Map<String, Object> getMemoryDumpConfig() {
        return this.memoryDumpConfig;
    }

    public TraceConfig(jpuppeteer.cdp.client.constant.tracing.TraceConfigRecordMode recordMode, Boolean enableSampling, Boolean enableSystrace, Boolean enableArgumentFilter, java.util.List<String> includedCategories, java.util.List<String> excludedCategories, java.util.List<String> syntheticDelays, java.util.Map<String, Object> memoryDumpConfig) {
        this.recordMode = recordMode;
        this.enableSampling = enableSampling;
        this.enableSystrace = enableSystrace;
        this.enableArgumentFilter = enableArgumentFilter;
        this.includedCategories = includedCategories;
        this.excludedCategories = excludedCategories;
        this.syntheticDelays = syntheticDelays;
        this.memoryDumpConfig = memoryDumpConfig;
    }

    public TraceConfig() {
        this.recordMode = null;
        this.enableSampling = null;
        this.enableSystrace = null;
        this.enableArgumentFilter = null;
        this.includedCategories = null;
        this.excludedCategories = null;
        this.syntheticDelays = null;
        this.memoryDumpConfig = null;
    }

}