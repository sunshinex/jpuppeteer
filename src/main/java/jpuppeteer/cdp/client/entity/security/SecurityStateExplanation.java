package jpuppeteer.cdp.client.entity.security;

/**
* An explanation of an factor contributing to the security state.
*/
public class SecurityStateExplanation {

    /**
    * Security state representing the severity of the factor being explained.
    */
    private jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * Title describing the type of factor.
    */
    private String title;

    /**
    * Short phrase describing the type of factor.
    */
    private String summary;

    /**
    * Full text explanation of the factor.
    */
    private String description;

    /**
    * The type of mixed content described by the explanation.
    */
    private jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType;

    /**
    * Page certificate.
    */
    private java.util.List<String> certificate;

    /**
    * Recommendations to fix any issues.
    */
    private java.util.List<String> recommendations;

    public void setSecurityState (jpuppeteer.cdp.client.constant.security.SecurityState securityState) {
        this.securityState = securityState;
    }

    public jpuppeteer.cdp.client.constant.security.SecurityState getSecurityState() {
        return this.securityState;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setSummary (String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setMixedContentType (jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType) {
        this.mixedContentType = mixedContentType;
    }

    public jpuppeteer.cdp.client.constant.security.MixedContentType getMixedContentType() {
        return this.mixedContentType;
    }

    public void setCertificate (java.util.List<String> certificate) {
        this.certificate = certificate;
    }

    public java.util.List<String> getCertificate() {
        return this.certificate;
    }

    public void setRecommendations (java.util.List<String> recommendations) {
        this.recommendations = recommendations;
    }

    public java.util.List<String> getRecommendations() {
        return this.recommendations;
    }

    public SecurityStateExplanation(jpuppeteer.cdp.client.constant.security.SecurityState securityState, String title, String summary, String description, jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType, java.util.List<String> certificate, java.util.List<String> recommendations) {
        this.securityState = securityState;
        this.title = title;
        this.summary = summary;
        this.description = description;
        this.mixedContentType = mixedContentType;
        this.certificate = certificate;
        this.recommendations = recommendations;
    }

    public SecurityStateExplanation(jpuppeteer.cdp.client.constant.security.SecurityState securityState, String title, String summary, String description, jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType, java.util.List<String> certificate) {
        this.securityState = securityState;
        this.title = title;
        this.summary = summary;
        this.description = description;
        this.mixedContentType = mixedContentType;
        this.certificate = certificate;
        this.recommendations = null;
    }

    public SecurityStateExplanation() {
    }

}