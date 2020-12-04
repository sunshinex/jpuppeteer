package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetVisibleSizeRequest {

    /**
    * Frame width (DIP).
    */
    public final Integer width;

    /**
    * Frame height (DIP).
    */
    public final Integer height;

    public SetVisibleSizeRequest(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

}