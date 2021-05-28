package jpuppeteer.cdp.client.entity.page;

/**
* Default font sizes.
*/
public class FontSizes {

    /**
    * Default standard font size.
    */
    public final Integer standard;

    /**
    * Default fixed font size.
    */
    public final Integer fixed;

    public FontSizes(Integer standard, Integer fixed) {
        this.standard = standard;
        this.fixed = fixed;
    }

    public FontSizes() {
        this.standard = null;
        this.fixed = null;
    }

}