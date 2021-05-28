package jpuppeteer.cdp.client.entity.profiler;

/**
* Coverage data for a JavaScript function.
*/
public class FunctionCoverage {

    /**
    * JavaScript function name.
    */
    public final String functionName;

    /**
    * Source ranges inside the function with coverage data.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.CoverageRange> ranges;

    /**
    * Whether coverage data for this function has block granularity.
    */
    public final Boolean isBlockCoverage;

    public FunctionCoverage(String functionName, java.util.List<jpuppeteer.cdp.client.entity.profiler.CoverageRange> ranges, Boolean isBlockCoverage) {
        this.functionName = functionName;
        this.ranges = ranges;
        this.isBlockCoverage = isBlockCoverage;
    }

}