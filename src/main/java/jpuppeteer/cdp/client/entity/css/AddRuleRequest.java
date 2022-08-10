package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class AddRuleRequest {

    /**
    * The css style sheet identifier where a new rule should be inserted.
    */
    private String styleSheetId;

    /**
    * The text of a new rule.
    */
    private String ruleText;

    /**
    * Text position of a new rule in the target style sheet.
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange location;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setRuleText (String ruleText) {
        this.ruleText = ruleText;
    }

    public String getRuleText() {
        return this.ruleText;
    }

    public void setLocation (jpuppeteer.cdp.client.entity.css.SourceRange location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getLocation() {
        return this.location;
    }

    public AddRuleRequest(String styleSheetId, String ruleText, jpuppeteer.cdp.client.entity.css.SourceRange location) {
        this.styleSheetId = styleSheetId;
        this.ruleText = ruleText;
        this.location = location;
    }

    public AddRuleRequest() {
    }

}