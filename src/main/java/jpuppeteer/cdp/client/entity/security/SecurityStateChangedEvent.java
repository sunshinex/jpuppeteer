package jpuppeteer.cdp.client.entity.security;

/**
* The security state of the page changed.
*/
public class SecurityStateChangedEvent {

    /**
    * Security state.
    */
    public final String securityState;

    /**
    * True if the page was loaded over cryptographic transport such as HTTPS.
    */
    public final Boolean schemeIsCryptographic;

    /**
    * List of explanations for the security state. If the overall security state is `insecure` or `warning`, at least one corresponding explanation should be included.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> explanations;

    /**
    * Information about insecure content on the page.
    */
    public final jpuppeteer.cdp.client.entity.security.InsecureContentStatus insecureContentStatus;

    /**
    * Overrides user-visible description of the state.
    */
    public final String summary;

    public SecurityStateChangedEvent(String securityState, Boolean schemeIsCryptographic, java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> explanations, jpuppeteer.cdp.client.entity.security.InsecureContentStatus insecureContentStatus, String summary) {
        this.securityState = securityState;
        this.schemeIsCryptographic = schemeIsCryptographic;
        this.explanations = explanations;
        this.insecureContentStatus = insecureContentStatus;
        this.summary = summary;
    }

    public SecurityStateChangedEvent(String securityState, Boolean schemeIsCryptographic, java.util.List<jpuppeteer.cdp.client.entity.security.SecurityStateExplanation> explanations, jpuppeteer.cdp.client.entity.security.InsecureContentStatus insecureContentStatus) {
        this.securityState = securityState;
        this.schemeIsCryptographic = schemeIsCryptographic;
        this.explanations = explanations;
        this.insecureContentStatus = insecureContentStatus;
        this.summary = null;
    }

}