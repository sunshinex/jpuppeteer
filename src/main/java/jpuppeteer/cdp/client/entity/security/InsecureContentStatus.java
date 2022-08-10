package jpuppeteer.cdp.client.entity.security;

/**
* Information about insecure content on the page.
*/
public class InsecureContentStatus {

    /**
    * Always false.
    */
    private Boolean ranMixedContent;

    /**
    * Always false.
    */
    private Boolean displayedMixedContent;

    /**
    * Always false.
    */
    private Boolean containedMixedForm;

    /**
    * Always false.
    */
    private Boolean ranContentWithCertErrors;

    /**
    * Always false.
    */
    private Boolean displayedContentWithCertErrors;

    /**
    * Always set to unknown.
    */
    private jpuppeteer.cdp.client.constant.security.SecurityState ranInsecureContentStyle;

    /**
    * Always set to unknown.
    */
    private jpuppeteer.cdp.client.constant.security.SecurityState displayedInsecureContentStyle;

    public void setRanMixedContent (Boolean ranMixedContent) {
        this.ranMixedContent = ranMixedContent;
    }

    public Boolean getRanMixedContent() {
        return this.ranMixedContent;
    }

    public void setDisplayedMixedContent (Boolean displayedMixedContent) {
        this.displayedMixedContent = displayedMixedContent;
    }

    public Boolean getDisplayedMixedContent() {
        return this.displayedMixedContent;
    }

    public void setContainedMixedForm (Boolean containedMixedForm) {
        this.containedMixedForm = containedMixedForm;
    }

    public Boolean getContainedMixedForm() {
        return this.containedMixedForm;
    }

    public void setRanContentWithCertErrors (Boolean ranContentWithCertErrors) {
        this.ranContentWithCertErrors = ranContentWithCertErrors;
    }

    public Boolean getRanContentWithCertErrors() {
        return this.ranContentWithCertErrors;
    }

    public void setDisplayedContentWithCertErrors (Boolean displayedContentWithCertErrors) {
        this.displayedContentWithCertErrors = displayedContentWithCertErrors;
    }

    public Boolean getDisplayedContentWithCertErrors() {
        return this.displayedContentWithCertErrors;
    }

    public void setRanInsecureContentStyle (jpuppeteer.cdp.client.constant.security.SecurityState ranInsecureContentStyle) {
        this.ranInsecureContentStyle = ranInsecureContentStyle;
    }

    public jpuppeteer.cdp.client.constant.security.SecurityState getRanInsecureContentStyle() {
        return this.ranInsecureContentStyle;
    }

    public void setDisplayedInsecureContentStyle (jpuppeteer.cdp.client.constant.security.SecurityState displayedInsecureContentStyle) {
        this.displayedInsecureContentStyle = displayedInsecureContentStyle;
    }

    public jpuppeteer.cdp.client.constant.security.SecurityState getDisplayedInsecureContentStyle() {
        return this.displayedInsecureContentStyle;
    }

    public InsecureContentStatus(Boolean ranMixedContent, Boolean displayedMixedContent, Boolean containedMixedForm, Boolean ranContentWithCertErrors, Boolean displayedContentWithCertErrors, jpuppeteer.cdp.client.constant.security.SecurityState ranInsecureContentStyle, jpuppeteer.cdp.client.constant.security.SecurityState displayedInsecureContentStyle) {
        this.ranMixedContent = ranMixedContent;
        this.displayedMixedContent = displayedMixedContent;
        this.containedMixedForm = containedMixedForm;
        this.ranContentWithCertErrors = ranContentWithCertErrors;
        this.displayedContentWithCertErrors = displayedContentWithCertErrors;
        this.ranInsecureContentStyle = ranInsecureContentStyle;
        this.displayedInsecureContentStyle = displayedInsecureContentStyle;
    }

    public InsecureContentStatus() {
    }

}