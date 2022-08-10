package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LayerTreeDidChangeEvent {

    /**
    * Layer tree, absent if not in the comspositing mode.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.layertree.Layer> layers;

    public void setLayers (java.util.List<jpuppeteer.cdp.client.entity.layertree.Layer> layers) {
        this.layers = layers;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.layertree.Layer> getLayers() {
        return this.layers;
    }

    public LayerTreeDidChangeEvent(java.util.List<jpuppeteer.cdp.client.entity.layertree.Layer> layers) {
        this.layers = layers;
    }

    public LayerTreeDidChangeEvent() {
        this.layers = null;
    }

}