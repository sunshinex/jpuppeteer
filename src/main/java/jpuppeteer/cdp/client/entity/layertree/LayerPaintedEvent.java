package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LayerPaintedEvent {

    /**
    * The id of the painted layer.
    */
    public final String layerId;

    /**
    * Clip rectangle.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect clip;

    public LayerPaintedEvent(String layerId, jpuppeteer.cdp.client.entity.dom.Rect clip) {
        this.layerId = layerId;
        this.clip = clip;
    }

}