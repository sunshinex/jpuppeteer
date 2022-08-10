package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CustomPreview {

    /**
    * The JSON-stringified result of formatter.header(object, config) call. It contains json ML array that represents RemoteObject.
    */
    private String header;

    /**
    * If formatter returns true as a result of formatter.hasBody call then bodyGetterId will contain RemoteObjectId for the function that returns result of formatter.body(object, config) call. The result value is json ML array.
    */
    private String bodyGetterId;

    public void setHeader (String header) {
        this.header = header;
    }

    public String getHeader() {
        return this.header;
    }

    public void setBodyGetterId (String bodyGetterId) {
        this.bodyGetterId = bodyGetterId;
    }

    public String getBodyGetterId() {
        return this.bodyGetterId;
    }

    public CustomPreview(String header, String bodyGetterId) {
        this.header = header;
        this.bodyGetterId = bodyGetterId;
    }

    public CustomPreview(String header) {
        this.header = header;
        this.bodyGetterId = null;
    }

    public CustomPreview() {
    }

}