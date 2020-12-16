package jpuppeteer.cdp.client.constant.runtime;

/**
*/
public enum RemoteObjectSubtype implements jpuppeteer.cdp.client.CDPEnum {

    ARRAY("array"),
    NULL("null"),
    NODE("node"),
    REGEXP("regexp"),
    DATE("date"),
    MAP("map"),
    SET("set"),
    WEAKMAP("weakmap"),
    WEAKSET("weakset"),
    ITERATOR("iterator"),
    GENERATOR("generator"),
    ERROR("error"),
    PROXY("proxy"),
    PROMISE("promise"),
    TYPEDARRAY("typedarray"),
    ARRAYBUFFER("arraybuffer"),
    DATAVIEW("dataview"),
    ;

    private String value;

    RemoteObjectSubtype(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static RemoteObjectSubtype findByValue(String value) {
        for(RemoteObjectSubtype val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}