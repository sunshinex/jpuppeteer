package jpuppeteer.cdp.client.constant.domdebugger;

/**
* CSP Violation type.
*/
public enum CSPViolationType implements jpuppeteer.cdp.client.CDPEnum {

    TRUSTEDTYPE_SINK_VIOLATION("trustedtype-sink-violation"),
    TRUSTEDTYPE_POLICY_VIOLATION("trustedtype-policy-violation"),
    ;

    private String value;

    CSPViolationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static CSPViolationType findByValue(String value) {
        for(CSPViolationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}