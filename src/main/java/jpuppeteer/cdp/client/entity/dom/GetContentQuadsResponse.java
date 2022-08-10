package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetContentQuadsResponse {

    /**
    * Quads that describe node layout relative to viewport.
    */
    private java.util.List<java.util.List<java.math.BigDecimal>> quads;

    public void setQuads (java.util.List<java.util.List<java.math.BigDecimal>> quads) {
        this.quads = quads;
    }

    public java.util.List<java.util.List<java.math.BigDecimal>> getQuads() {
        return this.quads;
    }

    public GetContentQuadsResponse(java.util.List<java.util.List<java.math.BigDecimal>> quads) {
        this.quads = quads;
    }

    public GetContentQuadsResponse() {
    }

}