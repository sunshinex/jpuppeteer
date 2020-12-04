package jpuppeteer.cdp.client.entity.security;

/**
*/
public class SafetyTipInfo {

    /**
    * Describes whether the page triggers any safety tips or reputation warnings. Default is unknown.
    */
    public final String safetyTipStatus;

    /**
    * The URL the safety tip suggested ("Did you mean?"). Only filled in for lookalike matches.
    */
    public final String safeUrl;

    public SafetyTipInfo(String safetyTipStatus, String safeUrl) {
        this.safetyTipStatus = safetyTipStatus;
        this.safeUrl = safeUrl;
    }

    public SafetyTipInfo(String safetyTipStatus) {
        this.safetyTipStatus = safetyTipStatus;
        this.safeUrl = null;
    }

}