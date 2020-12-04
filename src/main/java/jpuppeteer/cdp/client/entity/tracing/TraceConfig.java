package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class TraceConfig {

    /**
    * Controls how the trace buffer stores data.
    */
    public final String recordMode;

    /**
    * Turns on JavaScript stack sampling.
    */
    public final Boolean enableSampling;

    /**
    * Turns on system tracing.
    */
    public final Boolean enableSystrace;

    /**
    * Turns on argument filter.
    */
    public final Boolean enableArgumentFilter;

    /**
    * Included category filters.
    */
    public final java.util.List<String> includedCategories;

    /**
    * Excluded category filters.
    */
    public final java.util.List<String> excludedCategories;

    /**
    * Configuration to synthesize the delays in tracing.
    */
    public final java.util.List<String> syntheticDelays;

    /**
    * Configuration for memory dump triggers. Used only when "memory-infra" category is enabled.
    */
    public final java.util.Map<String, Object> memoryDumpConfig;

    public TraceConfig(String recordMode, Boolean enableSampling, Boolean enableSystrace, Boolean enableArgumentFilter, java.util.List<String> includedCategories, java.util.List<String> excludedCategories, java.util.List<String> syntheticDelays, java.util.Map<String, Object> memoryDumpConfig) {
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