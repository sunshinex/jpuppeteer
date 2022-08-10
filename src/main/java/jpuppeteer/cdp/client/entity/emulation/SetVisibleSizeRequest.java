package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetVisibleSizeRequest {

    /**
    * Frame width (DIP).
    */
    private Integer width;

    /**
    * Frame height (DIP).
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

    public SetVisibleSizeRequest(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public SetVisibleSizeRequest() {
    }

}