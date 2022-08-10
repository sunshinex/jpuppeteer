package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CollectClassNamesFromSubtreeResponse {

    /**
    * Class name list.
    */
    private java.util.List<String> classNames;

    public void setClassNames (java.util.List<String> classNames) {
        this.classNames = classNames;
    }

    public java.util.List<String> getClassNames() {
        return this.classNames;
    }

    public CollectClassNamesFromSubtreeResponse(java.util.List<String> classNames) {
        this.classNames = classNames;
    }

    public CollectClassNamesFromSubtreeResponse() {
    }

}