package jpuppeteer.cdp.client.entity.profiler;

/**
* Coverage data for a JavaScript function.
*/
public class FunctionCoverage {

    /**
    * JavaScript function name.
    */
    private String functionName;

    /**
    * Source ranges inside the function with coverage data.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.CoverageRange> ranges;

    /**
    * Whether coverage data for this function has block granularity.
    */
    private Boolean isBlockCoverage;

    public void setFunctionName (String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setRanges (java.util.List<jpuppeteer.cdp.client.entity.profiler.CoverageRange> ranges) {
        this.ranges = ranges;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.CoverageRange> getRanges() {
        return this.ranges;
    }

    public void setIsBlockCoverage (Boolean isBlockCoverage) {
        this.isBlockCoverage = isBlockCoverage;
    }

    public Boolean getIsBlockCoverage() {
        return this.isBlockCoverage;
    }

    public FunctionCoverage(String functionName, java.util.List<jpuppeteer.cdp.client.entity.profiler.CoverageRange> ranges, Boolean isBlockCoverage) {
        this.functionName = functionName;
        this.ranges = ranges;
        this.isBlockCoverage = isBlockCoverage;
    }

    public FunctionCoverage() {
    }

}