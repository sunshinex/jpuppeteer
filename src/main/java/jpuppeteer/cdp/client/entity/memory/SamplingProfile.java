package jpuppeteer.cdp.client.entity.memory;

/**
* Array of heap profile samples.
* experimental
*/
public class SamplingProfile {

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.memory.SamplingProfileNode> samples;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.memory.Module> modules;

    public SamplingProfile(java.util.List<jpuppeteer.cdp.client.entity.memory.SamplingProfileNode> samples, java.util.List<jpuppeteer.cdp.client.entity.memory.Module> modules) {
        this.samples = samples;
        this.modules = modules;
    }

}