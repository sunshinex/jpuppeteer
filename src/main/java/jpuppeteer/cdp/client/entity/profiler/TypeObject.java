package jpuppeteer.cdp.client.entity.profiler;

/**
* Describes a type collected during runtime.
*/
public class TypeObject {

    /**
    * Name of a type collected with type profiling.
    */
    private String name;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public TypeObject(String name) {
        this.name = name;
    }

    public TypeObject() {
    }

}