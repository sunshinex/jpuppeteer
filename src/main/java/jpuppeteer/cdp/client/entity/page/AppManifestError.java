package jpuppeteer.cdp.client.entity.page;

/**
* Error while paring app manifest.
*/
public class AppManifestError {

    /**
    * Error message.
    */
    public final String message;

    /**
    * If criticial, this is a non-recoverable parse error.
    */
    public final Integer critical;

    /**
    * Error line.
    */
    public final Integer line;

    /**
    * Error column.
    */
    public final Integer column;

    public AppManifestError(String message, Integer critical, Integer line, Integer column) {
        this.message = message;
        this.critical = critical;
        this.line = line;
        this.column = column;
    }

}