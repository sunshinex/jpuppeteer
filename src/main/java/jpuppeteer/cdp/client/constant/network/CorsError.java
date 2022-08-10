package jpuppeteer.cdp.client.constant.network;

/**
* The reason why request was blocked.
*/
public enum CorsError implements jpuppeteer.cdp.client.CDPEnum {

    DISALLOWEDBYMODE("DisallowedByMode"),
    INVALIDRESPONSE("InvalidResponse"),
    WILDCARDORIGINNOTALLOWED("WildcardOriginNotAllowed"),
    MISSINGALLOWORIGINHEADER("MissingAllowOriginHeader"),
    MULTIPLEALLOWORIGINVALUES("MultipleAllowOriginValues"),
    INVALIDALLOWORIGINVALUE("InvalidAllowOriginValue"),
    ALLOWORIGINMISMATCH("AllowOriginMismatch"),
    INVALIDALLOWCREDENTIALS("InvalidAllowCredentials"),
    CORSDISABLEDSCHEME("CorsDisabledScheme"),
    PREFLIGHTINVALIDSTATUS("PreflightInvalidStatus"),
    PREFLIGHTDISALLOWEDREDIRECT("PreflightDisallowedRedirect"),
    PREFLIGHTWILDCARDORIGINNOTALLOWED("PreflightWildcardOriginNotAllowed"),
    PREFLIGHTMISSINGALLOWORIGINHEADER("PreflightMissingAllowOriginHeader"),
    PREFLIGHTMULTIPLEALLOWORIGINVALUES("PreflightMultipleAllowOriginValues"),
    PREFLIGHTINVALIDALLOWORIGINVALUE("PreflightInvalidAllowOriginValue"),
    PREFLIGHTALLOWORIGINMISMATCH("PreflightAllowOriginMismatch"),
    PREFLIGHTINVALIDALLOWCREDENTIALS("PreflightInvalidAllowCredentials"),
    PREFLIGHTMISSINGALLOWEXTERNAL("PreflightMissingAllowExternal"),
    PREFLIGHTINVALIDALLOWEXTERNAL("PreflightInvalidAllowExternal"),
    INVALIDALLOWMETHODSPREFLIGHTRESPONSE("InvalidAllowMethodsPreflightResponse"),
    INVALIDALLOWHEADERSPREFLIGHTRESPONSE("InvalidAllowHeadersPreflightResponse"),
    METHODDISALLOWEDBYPREFLIGHTRESPONSE("MethodDisallowedByPreflightResponse"),
    HEADERDISALLOWEDBYPREFLIGHTRESPONSE("HeaderDisallowedByPreflightResponse"),
    REDIRECTCONTAINSCREDENTIALS("RedirectContainsCredentials"),
    INSECUREPRIVATENETWORK("InsecurePrivateNetwork"),
    NOCORSREDIRECTMODENOTFOLLOW("NoCorsRedirectModeNotFollow"),
    ;

    private String value;

    CorsError(String value) {
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

    public static CorsError findByValue(String value) {
        for(CorsError val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}