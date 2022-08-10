package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetEmulatedMediaRequest {

    /**
    * Media type to emulate. Empty string disables the override.
    */
    private String media;

    /**
    * Media features to emulate.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.emulation.MediaFeature> features;

    public void setMedia (String media) {
        this.media = media;
    }

    public String getMedia() {
        return this.media;
    }

    public void setFeatures (java.util.List<jpuppeteer.cdp.client.entity.emulation.MediaFeature> features) {
        this.features = features;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.emulation.MediaFeature> getFeatures() {
        return this.features;
    }

    public SetEmulatedMediaRequest(String media, java.util.List<jpuppeteer.cdp.client.entity.emulation.MediaFeature> features) {
        this.media = media;
        this.features = features;
    }

    public SetEmulatedMediaRequest() {
        this.media = null;
        this.features = null;
    }

}