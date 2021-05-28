package jpuppeteer.cdp.client.entity.security;

/**
* Security state information about the page.
*/
public class VisibleSecurityState {

    /**
    * The security level of the page.
    */
    public final jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * Security state details about the page certificate.
    */
    public final jpuppeteer.cdp.client.entity.security.CertificateSecurityState certificateSecurityState;

    /**
    * The type of Safety Tip triggered on the page. Note that this field will be set even if the Safety Tip UI was not actually shown.
    */
    public final jpuppeteer.cdp.client.entity.security.SafetyTipInfo safetyTipInfo;

    /**
    * Array of security state issues ids.
    */
    public final java.util.List<String> securityStateIssueIds;

    public VisibleSecurityState(jpuppeteer.cdp.client.constant.security.SecurityState securityState, jpuppeteer.cdp.client.entity.security.CertificateSecurityState certificateSecurityState, jpuppeteer.cdp.client.entity.security.SafetyTipInfo safetyTipInfo, java.util.List<String> securityStateIssueIds) {
        this.securityState = securityState;
        this.certificateSecurityState = certificateSecurityState;
        this.safetyTipInfo = safetyTipInfo;
        this.securityStateIssueIds = securityStateIssueIds;
    }

    public VisibleSecurityState(jpuppeteer.cdp.client.constant.security.SecurityState securityState, java.util.List<String> securityStateIssueIds) {
        this.securityState = securityState;
        this.certificateSecurityState = null;
        this.safetyTipInfo = null;
        this.securityStateIssueIds = securityStateIssueIds;
    }

}