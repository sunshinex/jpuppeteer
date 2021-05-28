package jpuppeteer.cdp.client.entity.page;

/**
* Generic font families collection.
*/
public class FontFamilies {

    /**
    * The standard font-family.
    */
    public final String standard;

    /**
    * The fixed font-family.
    */
    public final String fixed;

    /**
    * The serif font-family.
    */
    public final String serif;

    /**
    * The sansSerif font-family.
    */
    public final String sansSerif;

    /**
    * The cursive font-family.
    */
    public final String cursive;

    /**
    * The fantasy font-family.
    */
    public final String fantasy;

    /**
    * The pictograph font-family.
    */
    public final String pictograph;

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