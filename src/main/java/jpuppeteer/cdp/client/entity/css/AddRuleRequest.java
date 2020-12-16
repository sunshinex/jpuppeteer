package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class AddRuleRequest {

    /**
    * The css style sheet identifier where a new rule should be inserted.
    */
    public final String styleSheetId;

    /**
    * The text of a new rule.
    */
    public final String ruleText;

    /**
    * Text position of a new rule in the target style sheet.
    */
    public final SourceRange location;

    public AddRuleRequest(String styleSheetId, String ruleText, SourceRange location) {
        this.styleSheetId = styleSheetId;
        this.ruleText = ruleText;
        this.location = location;
    }

}