package jpuppeteer.cdp.client.entity.database;

/**
* Database error.
* experimental
*/
public class Error {

    /**
    * Error message.
    */
    private String message;

    /**
    * Error code.
    */
    private Integer code;

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode (Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public Error(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public Error() {
    }

}