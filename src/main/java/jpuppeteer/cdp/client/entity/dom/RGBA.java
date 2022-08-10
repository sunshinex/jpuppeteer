package jpuppeteer.cdp.client.entity.dom;

/**
* A structure holding an RGBA color.
*/
public class RGBA {

    /**
    * The red component, in the [0-255] range.
    */
    private Integer r;

    /**
    * The green component, in the [0-255] range.
    */
    private Integer g;

    /**
    * The blue component, in the [0-255] range.
    */
    private Integer b;

    /**
    * The alpha component, in the [0-1] range (default: 1).
    */
    private java.math.BigDecimal a;

    public void setR (Integer r) {
        this.r = r;
    }

    public Integer getR() {
        return this.r;
    }

    public void setG (Integer g) {
        this.g = g;
    }

    public Integer getG() {
        return this.g;
    }

    public void setB (Integer b) {
        this.b = b;
    }

    public Integer getB() {
        return this.b;
    }

    public void setA (java.math.BigDecimal a) {
        this.a = a;
    }

    public java.math.BigDecimal getA() {
        return this.a;
    }

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

    public RGBA() {
    }

}