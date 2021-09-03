package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DragDataItem {

    /**
    * Mime type of the dragged data.
    */
    public final String mimeType;

    /**
    * Depending of the value of `mimeType`, it contains the dragged link, text, HTML markup or any other data.
    */
    public final String data;

    /**
    * Title associated with a link. Only valid when `mimeType` == "text/uri-list".
    */
    public final String title;

    /**
    * Stores the base URL for the contained markup. Only valid when `mimeType` == "text/html".
    */
    public final String baseURL;

    public DragDataItem(String mimeType, String data, String title, String baseURL) {
        this.mimeType = mimeType;
        this.data = data;
        this.title = title;
        this.baseURL = baseURL;
    }

    public DragDataItem(String mimeType, String data) {
        this.mimeType = mimeType;
        this.data = data;
        this.title = null;
        this.baseURL = null;
    }

}