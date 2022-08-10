package jpuppeteer.cdp.client.entity.memory;

/**
* Array of heap profile samples.
* experimental
*/
public class SamplingProfile {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.memory.SamplingProfileNode> samples;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.memory.Module> modules;

    public void setSamples (java.util.List<jpuppeteer.cdp.client.entity.memory.SamplingProfileNode> samples) {
        this.samples = samples;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.memory.SamplingProfileNode> getSamples() {
        return this.samples;
    }

    public void setModules (java.util.List<jpuppeteer.cdp.client.entity.memory.Module> modules) {
        this.modules = modules;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.memory.Module> getModules() {
        return this.modules;
    }

    public SamplingProfile(java.util.List<jpuppeteer.cdp.client.entity.memory.SamplingProfileNode> samples, java.util.List<jpuppeteer.cdp.client.entity.memory.Module> modules) {
        this.samples = samples;
        this.modules = modules;
    }

    public SamplingProfile() {
    }

}