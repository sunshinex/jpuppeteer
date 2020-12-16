package jpuppeteer.cdp.client.entity.memory;

/**
* Array of heap profile samples.
* experimental
*/
public class SamplingProfile {

    /**
    */
    public final java.util.List<SamplingProfileNode> samples;

    /**
    */
    public final java.util.List<Module> modules;

    public SamplingProfile(java.util.List<SamplingProfileNode> samples, java.util.List<Module> modules) {
        this.samples = samples;
        this.modules = modules;
    }

}