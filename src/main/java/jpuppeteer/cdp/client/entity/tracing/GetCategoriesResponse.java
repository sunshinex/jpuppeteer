package jpuppeteer.cdp.client.entity.tracing;

/**
* experimental
*/
public class GetCategoriesResponse {

    /**
    * A list of supported tracing categories.
    */
    public final java.util.List<String> categories;

    public GetCategoriesResponse(java.util.List<String> categories) {
        this.categories = categories;
    }

}