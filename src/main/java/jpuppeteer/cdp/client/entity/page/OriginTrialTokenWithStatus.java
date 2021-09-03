package jpuppeteer.cdp.client.entity.page;

/**
*/
public class OriginTrialTokenWithStatus {

    /**
    */
    public final String rawTokenText;

    /**
    * `parsedToken` is present only when the token is extractable and parsable.
    */
    public final jpuppeteer.cdp.client.entity.page.OriginTrialToken parsedToken;

    /**
    */
    public final jpuppeteer.cdp.client.constant.page.OriginTrialTokenStatus status;

    public OriginTrialTokenWithStatus(String rawTokenText, jpuppeteer.cdp.client.entity.page.OriginTrialToken parsedToken, jpuppeteer.cdp.client.constant.page.OriginTrialTokenStatus status) {
        this.rawTokenText = rawTokenText;
        this.parsedToken = parsedToken;
        this.status = status;
    }

    public OriginTrialTokenWithStatus(String rawTokenText, jpuppeteer.cdp.client.constant.page.OriginTrialTokenStatus status) {
        this.rawTokenText = rawTokenText;
        this.parsedToken = null;
        this.status = status;
    }

}