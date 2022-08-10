package jpuppeteer.cdp.client.entity.page;

/**
* Generic font families collection.
*/
public class FontFamilies {

    /**
    * The standard font-family.
    */
    private String standard;

    /**
    * The fixed font-family.
    */
    private String fixed;

    /**
    * The serif font-family.
    */
    private String serif;

    /**
    * The sansSerif font-family.
    */
    private String sansSerif;

    /**
    * The cursive font-family.
    */
    private String cursive;

    /**
    * The fantasy font-family.
    */
    private String fantasy;

    /**
    * The pictograph font-family.
    */
    private String pictograph;

    public void setStandard (String standard) {
        this.standard = standard;
    }

    public String getStandard() {
        return this.standard;
    }

    public void setFixed (String fixed) {
        this.fixed = fixed;
    }

    public String getFixed() {
        return this.fixed;
    }

    public void setSerif (String serif) {
        this.serif = serif;
    }

    public String getSerif() {
        return this.serif;
    }

    public void setSansSerif (String sansSerif) {
        this.sansSerif = sansSerif;
    }

    public String getSansSerif() {
        return this.sansSerif;
    }

    public void setCursive (String cursive) {
        this.cursive = cursive;
    }

    public String getCursive() {
        return this.cursive;
    }

    public void setFantasy (String fantasy) {
        this.fantasy = fantasy;
    }

    public String getFantasy() {
        return this.fantasy;
    }

    public void setPictograph (String pictograph) {
        this.pictograph = pictograph;
    }

    public String getPictograph() {
        return this.pictograph;
    }

    public FontFamilies(String standard, String fixed, String serif, String sansSerif, String cursive, String fantasy, String pictograph) {
        this.standard = standard;
        this.fixed = fixed;
        this.serif = serif;
        this.sansSerif = sansSerif;
        this.cursive = cursive;
        this.fantasy = fantasy;
        this.pictograph = pictograph;
    }

    public FontFamilies() {
        this.standard = null;
        this.fixed = null;
        this.serif = null;
        this.sansSerif = null;
        this.cursive = null;
        this.fantasy = null;
        this.pictograph = null;
    }

}