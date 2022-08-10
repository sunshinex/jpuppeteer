package jpuppeteer.cdp.client.entity.security;

/**
*/
public class SafetyTipInfo {

    /**
    * Describes whether the page triggers any safety tips or reputation warnings. Default is unknown.
    */
    private jpuppeteer.cdp.client.constant.security.SafetyTipStatus safetyTipStatus;

    /**
    * The URL the safety tip suggested ("Did you mean?"). Only filled in for lookalike matches.
    */
    private String safeUrl;

    public void setSafetyTipStatus (jpuppeteer.cdp.client.constant.security.SafetyTipStatus safetyTipStatus) {
        this.safetyTipStatus = safetyTipStatus;
    }

    public jpuppeteer.cdp.client.constant.security.SafetyTipStatus getSafetyTipStatus() {
        return this.safetyTipStatus;
    }

    public void setSafeUrl (String safeUrl) {
        this.safeUrl = safeUrl;
    }

    public String getSafeUrl() {
        return this.safeUrl;
    }

    public SafetyTipInfo(jpuppeteer.cdp.client.constant.security.SafetyTipStatus safetyTipStatus, String safeUrl) {
        this.safetyTipStatus = safetyTipStatus;
        this.safeUrl = safeUrl;
    }

    public SafetyTipInfo(jpuppeteer.cdp.client.constant.security.SafetyTipStatus safetyTipStatus) {
        this.safetyTipStatus = safetyTipStatus;
        this.safeUrl = null;
    }

    public SafetyTipInfo() {
    }

}