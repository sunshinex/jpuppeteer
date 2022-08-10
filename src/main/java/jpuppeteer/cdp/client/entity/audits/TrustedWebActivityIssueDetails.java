package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class TrustedWebActivityIssueDetails {

    /**
    * The url that triggers the violation.
    */
    private String url;

    /**
    */
    private jpuppeteer.cdp.client.constant.audits.TwaQualityEnforcementViolationType violationType;

    /**
    */
    private Integer httpStatusCode;

    /**
    * The package name of the Trusted Web Activity client app. This field is only used when violation type is kDigitalAssetLinks.
    */
    private String packageName;

    /**
    * The signature of the Trusted Web Activity client app. This field is only used when violation type is kDigitalAssetLinks.
    */
    private String signature;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setViolationType (jpuppeteer.cdp.client.constant.audits.TwaQualityEnforcementViolationType violationType) {
        this.violationType = violationType;
    }

    public jpuppeteer.cdp.client.constant.audits.TwaQualityEnforcementViolationType getViolationType() {
        return this.violationType;
    }

    public void setHttpStatusCode (Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setPackageName (String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setSignature (String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return this.signature;
    }

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

    public TrustedWebActivityIssueDetails() {
    }

}