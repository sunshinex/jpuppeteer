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
    public final String ranInsecureContentStyle;

    /**
    * Always set to unknown.
    */
    public final String displayedInsecureContentStyle;

    public InsecureContentStatus(Boolean ranMixedContent, Boolean displayedMixedContent, Boolean containedMixedForm, Boolean ranContentWithCertErrors, Boolean displayedContentWithCertErrors, String ranInsecureContentStyle, String displayedInsecureContentStyle) {
        this.ranMixedContent = ranMixedContent;
        this.displayedMixedContent = displayedMixedContent;
        this.containedMixedForm = containedMixedForm;
        this.ranContentWithCertErrors = ranContentWithCertErrors;
        this.displayedContentWithCertErrors = displayedContentWithCertErrors;
        this.ranInsecureContentStyle = ranInsecureContentStyle;
        this.displayedInsecureContentStyle = displayedInsecureContentStyle;
    }

}