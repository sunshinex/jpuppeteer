package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetEmulatedMediaRequest {

    /**
    * Media type to emulate. Empty string disables the override.
    */
    public final String media;

    /**
    * Media features to emulate.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.emulation.MediaFeature> features;

    public SetEmulatedMediaRequest(String media, java.util.List<jpuppeteer.cdp.client.entity.emulation.MediaFeature> features) {
        this.media = media;
        this.features = features;
    }

    public SetEmulatedMediaRequest() {
        this.media = null;
        this.features = null;
    }

}