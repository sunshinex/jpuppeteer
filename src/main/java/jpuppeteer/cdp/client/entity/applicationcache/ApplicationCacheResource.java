package jpuppeteer.cdp.client.entity.applicationcache;

/**
* Detailed application cache resource information.
* experimental
*/
public class ApplicationCacheResource {

    /**
    * Resource url.
    */
    public final String url;

    /**
    * Resource size.
    */
    public final Integer size;

    /**
    * Resource type.
    */
    public final String type;

    public ApplicationCacheResource(String url, Integer size, String type) {
        this.url = url;
        this.size = size;
        this.type = type;
    }

}