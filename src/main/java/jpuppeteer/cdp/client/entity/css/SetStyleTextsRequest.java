package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleTextsRequest {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.StyleDeclarationEdit> edits;

    public void setEdits (java.util.List<jpuppeteer.cdp.client.entity.css.StyleDeclarationEdit> edits) {
        this.edits = edits;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.StyleDeclarationEdit> getEdits() {
        return this.edits;
    }

    public SetStyleTextsRequest(java.util.List<jpuppeteer.cdp.client.entity.css.StyleDeclarationEdit> edits) {
        this.edits = edits;
    }

    public SetStyleTextsRequest() {
    }

}