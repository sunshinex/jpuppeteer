package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LayerTreeDidChangeEvent {

    /**
    * Layer tree, absent if not in the comspositing mode.
    */
    public final java.util.List<Layer> layers;

    public LayerTreeDidChangeEvent(java.util.List<Layer> layers) {
        this.layers = layers;
    }

    public LayerTreeDidChangeEvent() {
        this.layers = null;
    }

}