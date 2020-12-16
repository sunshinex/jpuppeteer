package jpuppeteer.cdp.client.entity.css;

/**
* Text range within a resource. All numbers are zero-based.
* experimental
*/
public class SourceRange {

    /**
    * Start line of range.
    */
    public final Integer startLine;

    /**
    * Start column of range (inclusive).
    */
    public final Integer startColumn;

    /**
    * End line of range
    */
    public final Integer endLine;

    /**
    * End column of range (exclusive).
    */
    public final Integer endColumn;

    public SourceRange(Integer startLine, Integer startColumn, Integer endLine, Integer endColumn) {
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

}