package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetContentQuadsResponse {

    /**
    * Quads that describe node layout relative to viewport.
    */
    public final java.util.List<java.util.List<java.math.BigDecimal>> quads;

    public GetContentQuadsResponse(java.util.List<java.util.List<java.math.BigDecimal>> quads) {
        this.quads = quads;
    }

}