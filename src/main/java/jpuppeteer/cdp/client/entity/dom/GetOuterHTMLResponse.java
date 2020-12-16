package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetOuterHTMLResponse {

    /**
    * Outer HTML markup.
    */
    public final String outerHTML;

    public GetOuterHTMLResponse(String outerHTML) {
        this.outerHTML = outerHTML;
    }

}