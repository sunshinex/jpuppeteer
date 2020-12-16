package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class SetStyleTextsRequest {

    /**
    */
    public final java.util.List<StyleDeclarationEdit> edits;

    public SetStyleTextsRequest(java.util.List<StyleDeclarationEdit> edits) {
        this.edits = edits;
    }

}