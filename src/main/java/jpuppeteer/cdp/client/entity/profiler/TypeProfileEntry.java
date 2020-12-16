package jpuppeteer.cdp.client.entity.profiler;

/**
* Source offset and types for a parameter or return value.
*/
public class TypeProfileEntry {

    /**
    * Source offset of the parameter or end of function for return values.
    */
    public final Integer offset;

    /**
    * The types for this parameter or return value.
    */
    public final java.util.List<TypeObject> types;

    public TypeProfileEntry(Integer offset, java.util.List<TypeObject> types) {
        this.offset = offset;
        this.types = types;
    }

}