package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LayerPaintedEvent {

    /**
    * The id of the painted layer.
    */
    private String layerId;

    /**
    * Clip rectangle.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect clip;

    public void setLayerId (String layerId) {
        this.layerId = layerId;
    }

    public String getLayerId() {
        return this.layerId;
    }

    public void setClip (jpuppeteer.cdp.client.entity.dom.Rect clip) {
        this.clip = clip;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getClip() {
        return this.clip;
    }

    public LayerPaintedEvent(String layerId, jpuppeteer.cdp.client.entity.dom.Rect clip) {
        this.layerId = layerId;
        this.clip = clip;
    }

    public LayerPaintedEvent() {
    }

}