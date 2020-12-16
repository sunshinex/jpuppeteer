package jpuppeteer.cdp.client.entity.dom;

/**
* A structure holding an RGBA color.
*/
public class RGBA {

    /**
    * The red component, in the [0-255] range.
    */
    public final Integer r;

    /**
    * The green component, in the [0-255] range.
    */
    public final Integer g;

    /**
    * The blue component, in the [0-255] range.
    */
    public final Integer b;

    /**
    * The alpha component, in the [0-1] range (default: 1).
    */
    public final java.math.BigDecimal a;

    public RGBA(Integer r, Integer g, Integer b, java.math.BigDecimal a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public RGBA(Integer r, Integer g, Integer b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = null;
    }

}