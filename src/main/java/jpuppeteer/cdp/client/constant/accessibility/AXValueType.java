package jpuppeteer.cdp.client.constant.accessibility;

/**
* Enum of possible property types.
* experimental
*/
public enum AXValueType implements jpuppeteer.cdp.client.CDPEnum {

    BOOLEAN("boolean"),
    TRISTATE("tristate"),
    BOOLEANORUNDEFINED("booleanOrUndefined"),
    IDREF("idref"),
    IDREFLIST("idrefList"),
    INTEGER("integer"),
    NODE("node"),
    NODELIST("nodeList"),
    NUMBER("number"),
    STRING("string"),
    COMPUTEDSTRING("computedString"),
    TOKEN("token"),
    TOKENLIST("tokenList"),
    DOMRELATION("domRelation"),
    ROLE("role"),
    INTERNALROLE("internalRole"),
    VALUEUNDEFINED("valueUndefined"),
    ;

    private String value;

    AXValueType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static AXValueType findByValue(String value) {
        for(AXValueType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}