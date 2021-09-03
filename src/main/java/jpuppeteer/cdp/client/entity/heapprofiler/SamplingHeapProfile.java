package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* Sampling profile.
* experimental
*/
public class SamplingHeapProfile {

    /**
    */
    public final jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode head;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileSample> samples;

    public SamplingHeapProfile(jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode head, java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileSample> samples) {
        this.head = head;
        this.samples = samples;
    }

}