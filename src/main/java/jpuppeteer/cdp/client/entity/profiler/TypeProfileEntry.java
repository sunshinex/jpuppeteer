package jpuppeteer.cdp.client.entity.profiler;

/**
* Source offset and types for a parameter or return value.
*/
public class TypeProfileEntry {

    /**
    * Source offset of the parameter or end of function for return values.
    */
    private Integer offset;

    /**
    * The types for this parameter or return value.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeObject> types;

    public void setOffset (Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setTypes (java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeObject> types) {
        this.types = types;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeObject> getTypes() {
        return this.types;
    }

    public TypeProfileEntry(Integer offset, java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeObject> types) {
        this.offset = offset;
        this.types = types;
    }

    public TypeProfileEntry() {
    }

}