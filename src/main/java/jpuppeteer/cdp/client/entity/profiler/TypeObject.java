package jpuppeteer.cdp.client.entity.profiler;

/**
* Describes a type collected during runtime.
*/
public class TypeObject {

    /**
    * Name of a type collected with type profiling.
    */
    public final String name;

    public TypeObject(String name) {
        this.name = name;
    }

}