package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class SourceCodeLocation {

    /**
    */
    private String scriptId;

    /**
    */
    private String url;

    /**
    */
    private Integer lineNumber;

    /**
    */
    private Integer columnNumber;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLineNumber (Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getLineNumber() {
        return this.lineNumber;
    }

    public void setColumnNumber (Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Integer getColumnNumber() {
        return this.columnNumber;
    }

    public SourceCodeLocation(String scriptId, String url, Integer lineNumber, Integer columnNumber) {
        this.scriptId = scriptId;
        this.url = url;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public SourceCodeLocation(String url, Integer lineNumber, Integer columnNumber) {
        this.scriptId = null;
        this.url = url;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public SourceCodeLocation() {
    }

}