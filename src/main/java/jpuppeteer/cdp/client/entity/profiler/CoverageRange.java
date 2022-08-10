package jpuppeteer.cdp.client.entity.profiler;

/**
* Coverage data for a source range.
*/
public class CoverageRange {

    /**
    * JavaScript script source offset for the range start.
    */
    private Integer startOffset;

    /**
    * JavaScript script source offset for the range end.
    */
    private Integer endOffset;

    /**
    * Collected execution count of the source range.
    */
    private Integer count;

    public void setStartOffset (Integer startOffset) {
        this.startOffset = startOffset;
    }

    public Integer getStartOffset() {
        return this.startOffset;
    }

    public void setEndOffset (Integer endOffset) {
        this.endOffset = endOffset;
    }

    public Integer getEndOffset() {
        return this.endOffset;
    }

    public void setCount (Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return this.count;
    }

    public CoverageRange(Integer startOffset, Integer endOffset, Integer count) {
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.count = count;
    }

    public CoverageRange() {
    }

}