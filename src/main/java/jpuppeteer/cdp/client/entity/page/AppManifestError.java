package jpuppeteer.cdp.client.entity.page;

/**
* Error while paring app manifest.
*/
public class AppManifestError {

    /**
    * Error message.
    */
    private String message;

    /**
    * If criticial, this is a non-recoverable parse error.
    */
    private Integer critical;

    /**
    * Error line.
    */
    private Integer line;

    /**
    * Error column.
    */
    private Integer column;

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCritical (Integer critical) {
        this.critical = critical;
    }

    public Integer getCritical() {
        return this.critical;
    }

    public void setLine (Integer line) {
        this.line = line;
    }

    public Integer getLine() {
        return this.line;
    }

    public void setColumn (Integer column) {
        this.column = column;
    }

    public Integer getColumn() {
        return this.column;
    }

    public AppManifestError(String message, Integer critical, Integer line, Integer column) {
        this.message = message;
        this.critical = critical;
        this.line = line;
        this.column = column;
    }

    public AppManifestError() {
    }

}