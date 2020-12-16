package jpuppeteer.cdp.client.entity.security;

/**
*/
public class SafetyTipInfo {

    /**
    * Describes whether the page triggers any safety tips or reputation warnings. Default is unknown.
    */
    public final jpuppeteer.cdp.client.constant.security.SafetyTipStatus safetyTipStatus;

    /**
    * The URL the safety tip suggested ("Did you mean?"). Only filled in for lookalike matches.
    */
    public final String safeUrl;

    public SafetyTipInfo(jpuppeteer.cdp.client.constant.security.SafetyTipStatus safetyTipStatus, String safeUrl) {
        this.safetyTipStatus = safetyTipStatus;
        this.safeUrl = safeUrl;
    }

    public SafetyTipInfo(jpuppeteer.cdp.client.constant.security.SafetyTipStatus safetyTipStatus) {
        this.safetyTipStatus = safetyTipStatus;
        this.safeUrl = null;
    }

}