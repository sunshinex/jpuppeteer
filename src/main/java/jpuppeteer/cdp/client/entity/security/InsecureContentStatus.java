package jpuppeteer.cdp.client.entity.security;

/**
* Information about insecure content on the page.
*/
public class InsecureContentStatus {

    /**
    * Always false.
    */
    public final Boolean ranMixedContent;

    /**
    * Always false.
    */
    public final Boolean displayedMixedContent;

    /**
    * Always false.
    */
    public final Boolean containedMixedForm;

    /**
    * Always false.
    */
    public final Boolean ranContentWithCertErrors;

    /**
    * Always false.
    */
    public final Boolean displayedContentWithCertErrors;

    /**
    * Always set to unknown.
    */
    public final jpuppeteer.cdp.client.constant.security.SecurityState ranInsecureContentStyle;

    /**
    * Always set to unknown.
    */
    public final jpuppeteer.cdp.client.constant.security.SecurityState displayedInsecureContentStyle;

    public InsecureContentStatus(Boolean ranMixedContent, Boolean displayedMixedContent, Boolean containedMixedForm, Boolean ranContentWithCertErrors, Boolean displayedContentWithCertErrors, jpuppeteer.cdp.client.constant.security.SecurityState ranInsecureContentStyle, jpuppeteer.cdp.client.constant.security.SecurityState displayedInsecureContentStyle) {
        this.ranMixedContent = ranMixedContent;
        this.displayedMixedContent = displayedMixedContent;
        this.containedMixedForm = containedMixedForm;
        this.ranContentWithCertErrors = ranContentWithCertErrors;
        this.displayedContentWithCertErrors = displayedContentWithCertErrors;
        this.ranInsecureContentStyle = ranInsecureContentStyle;
        this.displayedInsecureContentStyle = displayedInsecureContentStyle;
    }

}