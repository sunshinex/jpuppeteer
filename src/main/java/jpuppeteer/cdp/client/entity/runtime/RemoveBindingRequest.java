package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class RemoveBindingRequest {

    /**
    */
    private String name;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public RemoveBindingRequest(String name) {
        this.name = name;
    }

    public RemoveBindingRequest() {
    }

}