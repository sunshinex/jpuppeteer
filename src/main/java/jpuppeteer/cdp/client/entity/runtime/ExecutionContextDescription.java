package jpuppeteer.cdp.client.entity.runtime;

/**
* Description of an isolated world.
*/
public class ExecutionContextDescription {

    /**
    * Unique id of the execution context. It can be used to specify in which execution context script evaluation should be performed.
    */
    private Integer id;

    /**
    * Execution context origin.
    */
    private String origin;

    /**
    * Human readable name describing given context.
    */
    private String name;

    /**
    * A system-unique execution context identifier. Unlike the id, this is unique accross multiple processes, so can be reliably used to identify specific context while backend performs a cross-process navigation.
    */
    private String uniqueId;

    /**
    * Embedder-specific auxiliary data.
    */
    private java.util.Map<String, Object> auxData;

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUniqueId (String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setAuxData (java.util.Map<String, Object> auxData) {
        this.auxData = auxData;
    }

    public java.util.Map<String, Object> getAuxData() {
        return this.auxData;
    }

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

    public ExecutionContextDescription() {
    }

}