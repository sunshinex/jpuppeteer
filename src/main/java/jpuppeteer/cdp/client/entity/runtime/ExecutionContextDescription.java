package jpuppeteer.cdp.client.entity.runtime;

/**
* Description of an isolated world.
*/
public class ExecutionContextDescription {

    /**
    * Unique id of the execution context. It can be used to specify in which execution context script evaluation should be performed.
    */
    public final Integer id;

    /**
    * Execution context origin.
    */
    public final String origin;

    /**
    * Human readable name describing given context.
    */
    public final String name;

    /**
    * Embedder-specific auxiliary data.
    */
    public final java.util.Map<String, Object> auxData;

    public ExecutionContextDescription(Integer id, String origin, String name, java.util.Map<String, Object> auxData) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.auxData = auxData;
    }

    public ExecutionContextDescription(Integer id, String origin, String name) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.auxData = null;
    }

}