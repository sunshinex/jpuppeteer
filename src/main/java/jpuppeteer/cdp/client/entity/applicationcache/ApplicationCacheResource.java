package jpuppeteer.cdp.client.entity.applicationcache;

/**
* Detailed application cache resource information.
* experimental
*/
public class ApplicationCacheResource {

    /**
    * Resource url.
    */
    private String url;

    /**
    * Resource size.
    */
    private Integer size;

    /**
    * Resource type.
    */
    private String type;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setSize (Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public ApplicationCacheResource(String url, Integer size, String type) {
        this.url = url;
        this.size = size;
        this.type = type;
    }

    public ApplicationCacheResource() {
    }

}