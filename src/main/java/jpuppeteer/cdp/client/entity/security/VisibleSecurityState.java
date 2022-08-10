package jpuppeteer.cdp.client.entity.security;

/**
* Security state information about the page.
*/
public class VisibleSecurityState {

    /**
    * The security level of the page.
    */
    private jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * Security state details about the page certificate.
    */
    private jpuppeteer.cdp.client.entity.security.CertificateSecurityState certificateSecurityState;

    /**
    * The type of Safety Tip triggered on the page. Note that this field will be set even if the Safety Tip UI was not actually shown.
    */
    private jpuppeteer.cdp.client.entity.security.SafetyTipInfo safetyTipInfo;

    /**
    * Array of security state issues ids.
    */
    private java.util.List<String> securityStateIssueIds;

    public void setSecurityState (jpuppeteer.cdp.client.constant.security.SecurityState securityState) {
        this.securityState = securityState;
    }

    public jpuppeteer.cdp.client.constant.security.SecurityState getSecurityState() {
        return this.securityState;
    }

    public void setCertificateSecurityState (jpuppeteer.cdp.client.entity.security.CertificateSecurityState certificateSecurityState) {
        this.certificateSecurityState = certificateSecurityState;
    }

    public jpuppeteer.cdp.client.entity.security.CertificateSecurityState getCertificateSecurityState() {
        return this.certificateSecurityState;
    }

    public void setSafetyTipInfo (jpuppeteer.cdp.client.entity.security.SafetyTipInfo safetyTipInfo) {
        this.safetyTipInfo = safetyTipInfo;
    }

    public jpuppeteer.cdp.client.entity.security.SafetyTipInfo getSafetyTipInfo() {
        return this.safetyTipInfo;
    }

    public void setSecurityStateIssueIds (java.util.List<String> securityStateIssueIds) {
        this.securityStateIssueIds = securityStateIssueIds;
    }

    public java.util.List<String> getSecurityStateIssueIds() {
        return this.securityStateIssueIds;
    }

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

    public VisibleSecurityState() {
    }

}