package jpuppeteer.cdp.client.entity.security;

/**
* The security state of the page changed.
*/
public class SecurityStateChangedEvent {

    /**
    * Security state.
    */
    public final jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * True if the page was loaded over cryptographic transport such as HTTPS.
    */
    public final Boolean schemeIsCryptographic;

    /**
    * List of explanations for the security state. If the overall security state is `insecure` or `warning`, at least one corresponding explanation should be included.
    */
    public final java.util.List<SecurityStateExplanation> explanations;

    /**
    * Information about insecure content on the page.
    */
    public final InsecureContentStatus insecureContentStatus;

    /**
    * Overrides user-visible description of the state.
    */
    public final String summary;

    public SecurityStateChangedEvent(jpuppeteer.cdp.client.constant.security.SecurityState securityState, Boolean schemeIsCryptographic, java.util.List<SecurityStateExplanation> explanations, InsecureContentStatus insecureContentStatus, String summary) {
        this.securityState = securityState;
        this.schemeIsCryptographic = schemeIsCryptographic;
        this.explanations = explanations;
        this.insecureContentStatus = insecureContentStatus;
        this.summary = summary;
    }

    public SecurityStateChangedEvent(jpuppeteer.cdp.client.constant.security.SecurityState securityState, Boolean schemeIsCryptographic, java.util.List<SecurityStateExplanation> explanations, InsecureContentStatus insecureContentStatus) {
        this.securityState = securityState;
        this.schemeIsCryptographic = schemeIsCryptographic;
        this.explanations = explanations;
        this.insecureContentStatus = insecureContentStatus;
        this.summary = null;
    }

}