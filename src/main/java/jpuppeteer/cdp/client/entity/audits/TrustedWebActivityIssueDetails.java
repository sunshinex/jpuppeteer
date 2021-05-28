package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class TrustedWebActivityIssueDetails {

    /**
    * The url that triggers the violation.
    */
    public final String url;

    /**
    */
    public final jpuppeteer.cdp.client.constant.audits.TwaQualityEnforcementViolationType violationType;

    /**
    */
    public final Integer httpStatusCode;

    /**
    * The package name of the Trusted Web Activity client app. This field is only used when violation type is kDigitalAssetLinks.
    */
    public final String packageName;

    /**
    * The signature of the Trusted Web Activity client app. This field is only used when violation type is kDigitalAssetLinks.
    */
    public final String signature;

    public TrustedWebActivityIssueDetails(String url, jpuppeteer.cdp.client.constant.audits.TwaQualityEnforcementViolationType violationType, Integer httpStatusCode, String packageName, String signature) {
        this.url = url;
        this.violationType = violationType;
        this.httpStatusCode = httpStatusCode;
        this.packageName = packageName;
        this.signature = signature;
    }

    public TrustedWebActivityIssueDetails(String url, jpuppeteer.cdp.client.constant.audits.TwaQualityEnforcementViolationType violationType) {
        this.url = url;
        this.violationType = violationType;
        this.httpStatusCode = null;
        this.packageName = null;
        this.signature = null;
    }

}