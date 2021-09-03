package jpuppeteer.cdp.client.entity.css;

/**
* A descriptor of operation to mutate style declaration text.
* experimental
*/
public class StyleDeclarationEdit {

    /**
    * The css style sheet identifier.
    */
    public final String styleSheetId;

    /**
    * The range of the style text in the enclosing stylesheet.
    */
    public final jpuppeteer.cdp.client.entity.css.SourceRange range;

    /**
    * New style text.
    */
    public final String text;

    public StyleDeclarationEdit(String styleSheetId, jpuppeteer.cdp.client.entity.css.SourceRange range, String text) {
        this.styleSheetId = styleSheetId;
        this.range = range;
        this.text = text;
    }

}