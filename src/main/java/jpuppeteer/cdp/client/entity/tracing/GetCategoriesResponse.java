package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class GetCategoriesResponse {

    /**
    * A list of supported tracing categories.
    */
    private java.util.List<String> categories;

    public void setCategories (java.util.List<String> categories) {
        this.categories = categories;
    }

    public java.util.List<String> getCategories() {
        return this.categories;
    }

    public GetCategoriesResponse(java.util.List<String> categories) {
        this.categories = categories;
    }

    public GetCategoriesResponse() {
    }

}