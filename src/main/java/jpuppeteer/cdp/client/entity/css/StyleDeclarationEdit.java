package jpuppeteer.cdp.client.entity.css;

/**
* A descriptor of operation to mutate style declaration text.
* experimental
*/
public class StyleDeclarationEdit {

    /**
    * The css style sheet identifier.
    */
    private String styleSheetId;

    /**
    * The range of the style text in the enclosing stylesheet.
    */
    private jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    * New style text.
    */
    private String text;

    public void setStyleSheetId (String styleSheetId) {
        this.styleSheetId = styleSheetId;
    }

    public String getStyleSheetId() {
        return this.styleSheetId;
    }

    public void setRange (jpuppeteer.cdp.client.entity.css.SourceRange range) {
        this.range = range;
    }

    public jpuppeteer.cdp.client.entity.css.SourceRange getRange() {
        return this.range;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public StyleDeclarationEdit(String styleSheetId, jpuppeteer.cdp.client.entity.css.SourceRange range, String text) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.text = text;
    }

    public StyleDeclarationEdit() {
    }

}