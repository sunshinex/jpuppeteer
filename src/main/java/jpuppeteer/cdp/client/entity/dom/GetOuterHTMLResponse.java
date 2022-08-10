package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetOuterHTMLResponse {

    /**
    * Outer HTML markup.
    */
    private String outerHTML;

    public void setOuterHTML (String outerHTML) {
        this.outerHTML = outerHTML;
    }

    public String getOuterHTML() {
        return this.outerHTML;
    }

    public GetOuterHTMLResponse(String outerHTML) {
        this.outerHTML = outerHTML;
    }

    public GetOuterHTMLResponse() {
    }

}