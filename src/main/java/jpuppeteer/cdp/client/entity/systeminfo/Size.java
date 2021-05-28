package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes the width and height dimensions of an entity.
* experimental
*/
public class Size {

    /**
    * Width in pixels.
    */
    public final Integer width;

    /**
    * Height in pixels.
    */
    public final Integer height;

    public Size(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

}