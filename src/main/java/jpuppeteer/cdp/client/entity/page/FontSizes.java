package jpuppeteer.cdp.client.entity.page;

/**
* Default font sizes.
*/
public class FontSizes {

    /**
    * Default standard font size.
    */
    private Integer standard;

    /**
    * Default fixed font size.
    */
    private Integer fixed;

    public void setStandard (Integer standard) {
        this.standard = standard;
    }

    public Integer getStandard() {
        return this.standard;
    }

    public void setFixed (Integer fixed) {
        this.fixed = fixed;
    }

    public Integer getFixed() {
        return this.fixed;
    }

    public FontSizes(Integer standard, Integer fixed) {
        this.standard = standard;
        this.fixed = fixed;
    }

    public FontSizes() {
        this.standard = null;
        this.fixed = null;
    }

}