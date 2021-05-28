package jpuppeteer.cdp.client.entity.database;

/**
* Database error.
* experimental
*/
public class Error {

    /**
    * Error message.
    */
    public final String message;

    /**
    * Error code.
    */
    public final Integer code;

    public Error(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

}