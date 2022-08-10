package jpuppeteer.cdp.client.entity.input;

/**
*/
public class DragDataItem {

    /**
    * Mime type of the dragged data.
    */
    private String mimeType;

    /**
    * Depending of the value of `mimeType`, it contains the dragged link, text, HTML markup or any other data.
    */
    private String data;

    /**
    * Title associated with a link. Only valid when `mimeType` == "text/uri-list".
    */
    private String title;

    /**
    * Stores the base URL for the contained markup. Only valid when `mimeType` == "text/html".
    */
    private String baseURL;

    public void setMimeType (String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBaseURL (String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBaseURL() {
        return this.baseURL;
    }

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

    public DragDataItem() {
    }

}