package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class CollectClassNamesResponse {

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

    public CollectClassNamesResponse(java.util.List<String> classNames) {
        this.classNames = classNames;
    }

    public CollectClassNamesResponse() {
    }

}