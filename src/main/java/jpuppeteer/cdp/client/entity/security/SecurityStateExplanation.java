package jpuppeteer.cdp.client.entity.security;

/**
* An explanation of an factor contributing to the security state.
*/
public class SecurityStateExplanation {

    /**
    * Security state representing the severity of the factor being explained.
    */
    public final jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * Title describing the type of factor.
    */
    public final String title;

    /**
    * Short phrase describing the type of factor.
    */
    public final String summary;

    /**
    * Full text explanation of the factor.
    */
    public final String description;

    /**
    * The type of mixed content described by the explanation.
    */
    public final jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType;

    /**
    * Page certificate.
    */
    public final java.util.List<String> certificate;

    /**
    * Recommendations to fix any issues.
    */
    public final java.util.List<String> recommendations;

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

}