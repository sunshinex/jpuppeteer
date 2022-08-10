package jpuppeteer.cdp.client.entity.security;

/**
* The security state of the page changed.
*/
public class SecurityStateChangedEvent {

    /**
    * Security state.
    */
    private jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * True if the page was loaded over cryptographic transport such as HTTPS.
    */
    private Boolean schemeIsCryptographic;

    /**
    * List of explanations for the security state. If the overall security state is `insecure` or `warning`, at least one corresponding explanation should be included.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> explanations;

    /**
    * Information about insecure content on the page.
    */
    private jpuppeteer.cdp.client.entity.security.InsecureContentStatus insecureContentStatus;

    /**
    * Overrides user-visible description of the state.
    */
    private String summary;

    public void setSecurityState (jpuppeteer.cdp.client.constant.security.SecurityState securityState) {
        this.securityState = securityState;
    }

    public jpuppeteer.cdp.client.constant.security.SecurityState getSecurityState() {
        return this.securityState;
    }

    public void setSchemeIsCryptographic (Boolean schemeIsCryptographic) {
        this.schemeIsCryptographic = schemeIsCryptographic;
    }

    public Boolean getSchemeIsCryptographic() {
        return this.schemeIsCryptographic;
    }

    public void setExplanations (java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> explanations) {
        this.explanations = explanations;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> getExplanations() {
        return this.explanations;
    }

    public void setInsecureContentStatus (jpuppeteer.cdp.client.entity.security.InsecureContentStatus insecureContentStatus) {
        this.insecureContentStatus = insecureContentStatus;
    }

    public jpuppeteer.cdp.client.entity.security.InsecureContentStatus getInsecureContentStatus() {
        return this.insecureContentStatus;
    }

    public void setSummary (String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return this.summary;
    }

    public SecurityStateChangedEvent(jpuppeteer.cdp.client.constant.security.SecurityState securityState, Boolean schemeIsCryptographic, java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> explanations, jpuppeteer.cdp.client.entity.security.InsecureContentStatus insecureContentStatus, String summary) {
        this.securityState = securityState;
        this.schemeIsCryptographic = schemeIsCryptographic;
        this.explanations = explanations;
        this.insecureContentStatus = insecureContentStatus;
        this.summary = summary;
    }

    public SecurityStateChangedEvent(jpuppeteer.cdp.client.constant.security.SecurityState securityState, Boolean schemeIsCryptographic, java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> explanations, jpuppeteer.cdp.client.entity.security.InsecureContentStatus insecureContentStatus) {
        this.securityState = securityState;
        this.schemeIsCryptographic = schemeIsCryptographic;
        this.explanations = explanations;
        this.insecureContentStatus = insecureContentStatus;
        this.summary = null;
    }

    public SecurityStateChangedEvent() {
    }

}