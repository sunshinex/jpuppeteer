package jpuppeteer.cdp.client.entity.systeminfo;

/**
* Describes the width and height dimensions of an entity.
* experimental
*/
public class Size {

    /**
    * Width in pixels.
    */
    private Integer width;

    /**
    * Height in pixels.
    */
    private Integer height;

    public void setWidth (Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setHeight (Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Size(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Size() {
    }

}