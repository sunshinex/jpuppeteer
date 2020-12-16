package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CustomPreview {

    /**
    * The JSON-stringified result of formatter.header(object, config) call. It contains json ML array that represents RemoteObject.
    */
    public final String header;

    /**
    * If formatter returns true as a result of formatter.hasBody call then bodyGetterId will contain RemoteObjectId for the function that returns result of formatter.body(object, config) call. The result value is json ML array.
    */
    public final String bodyGetterId;

    public CustomPreview(String header, String bodyGetterId) {
        this.header = header;
        this.bodyGetterId = bodyGetterId;
    }

    public CustomPreview(String header) {
        this.header = header;
        this.bodyGetterId = null;
    }

}