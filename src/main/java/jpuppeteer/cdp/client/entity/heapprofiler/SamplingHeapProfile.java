package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* Sampling profile.
* experimental
*/
public class SamplingHeapProfile {

    /**
    */
    public final SamplingHeapProfileNode head;

    /**
    */
    public final java.util.List<SamplingHeapProfileSample> samples;

    public SamplingHeapProfile(SamplingHeapProfileNode head, java.util.List<SamplingHeapProfileSample> samples) {
        this.head = head;
        this.samples = samples;
    }

}