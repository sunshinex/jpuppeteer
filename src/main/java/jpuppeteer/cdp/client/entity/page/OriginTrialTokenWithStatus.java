package jpuppeteer.cdp.client.entity.page;

/**
*/
public class OriginTrialTokenWithStatus {

    /**
    */
    private String rawTokenText;

    /**
    * `parsedToken` is present only when the token is extractable and parsable.
    */
    private jpuppeteer.cdp.client.entity.page.OriginTrialToken parsedToken;

    /**
    */
    private jpuppeteer.cdp.client.constant.page.OriginTrialTokenStatus status;

    public void setRawTokenText (String rawTokenText) {
        this.rawTokenText = rawTokenText;
    }

    public String getRawTokenText() {
        return this.rawTokenText;
    }

    public void setParsedToken (jpuppeteer.cdp.client.entity.page.OriginTrialToken parsedToken) {
        this.parsedToken = parsedToken;
    }

    public jpuppeteer.cdp.client.entity.page.OriginTrialToken getParsedToken() {
        return this.parsedToken;
    }

    public void setStatus (jpuppeteer.cdp.client.constant.page.OriginTrialTokenStatus status) {
        this.status = status;
    }

    public jpuppeteer.cdp.client.constant.page.OriginTrialTokenStatus getStatus() {
        return this.status;
    }

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

    public OriginTrialTokenWithStatus() {
    }

}