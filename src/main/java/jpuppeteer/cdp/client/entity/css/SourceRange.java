package jpuppeteer.cdp.client.entity.css;

/**
* Text range within a resource. All numbers are zero-based.
* experimental
*/
public class SourceRange {

    /**
    * Start line of range.
    */
    private Integer startLine;

    /**
    * Start column of range (inclusive).
    */
    private Integer startColumn;

    /**
    * End line of range
    */
    private Integer endLine;

    /**
    * End column of range (exclusive).
    */
    private Integer endColumn;

    public void setStartLine (Integer startLine) {
        this.startLine = startLine;
    }

    public Integer getStartLine() {
        return this.startLine;
    }

    public void setStartColumn (Integer startColumn) {
        this.startColumn = startColumn;
    }

    public Integer getStartColumn() {
        return this.startColumn;
    }

    public void setEndLine (Integer endLine) {
        this.endLine = endLine;
    }

    public Integer getEndLine() {
        return this.endLine;
    }

    public void setEndColumn (Integer endColumn) {
        this.endColumn = endColumn;
    }

    public Integer getEndColumn() {
        return this.endColumn;
    }

    public SourceRange(Integer startLine, Integer startColumn, Integer endLine, Integer endColumn) {
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public SourceRange() {
    }

}