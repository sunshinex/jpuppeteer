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
    * A system-unique execution context identifier. Unlike the id, this is unique accross multiple processes, so can be reliably used to identify specific context while backend performs a cross-process navigation.
    */
    public final String uniqueId;

    /**
    * Embedder-specific auxiliary data.
    */
    public final java.util.Map<String, Object> auxData;

    public ExecutionContextDescription(Integer id, String origin, String name, String uniqueId, java.util.Map<String, Object> auxData) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.uniqueId = uniqueId;
        this.auxData = auxData;
    }

    public ExecutionContextDescription(Integer id, String origin, String name, String uniqueId) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.uniqueId = uniqueId;
        this.auxData = null;
    }

}