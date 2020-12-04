package jpuppeteer.cdp.client.entity.profiler;

/**
* Coverage data for a source range.
*/
public class CoverageRange {

    /**
    * JavaScript script source offset for the range start.
    */
    public final Integer startOffset;

    /**
    * JavaScript script source offset for the range end.
    */
    public final Integer endOffset;

    /**
    * Collected execution count of the source range.
    */
    public final Integer count;

    public CoverageRange(Integer startOffset, Integer endOffset, Integer count) {
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.count = count;
    }

}