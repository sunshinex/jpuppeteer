package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum ContentSecurityPolicyViolationType implements jpuppeteer.cdp.client.CDPEnum {

    KINLINEVIOLATION("kInlineViolation"),
    KEVALVIOLATION("kEvalViolation"),
    KURLVIOLATION("kURLViolation"),
    KTRUSTEDTYPESSINKVIOLATION("kTrustedTypesSinkViolation"),
    KTRUSTEDTYPESPOLICYVIOLATION("kTrustedTypesPolicyViolation"),
    ;

    private String value;

    ContentSecurityPolicyViolationType(String value) {
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

    public static ContentSecurityPolicyViolationType findByValue(String value) {
        for(ContentSecurityPolicyViolationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}