package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* Sampling profile.
* experimental
*/
public class SamplingHeapProfile {

    /**
    */
    private jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode head;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileSample> samples;

    public void setHead (jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode head) {
        this.head = head;
    }

    public jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode getHead() {
        return this.head;
    }

    public void setSamples (java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileSample> samples) {
        this.samples = samples;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileSample> getSamples() {
        return this.samples;
    }

    public SamplingHeapProfile(jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileNode head, java.util.List<jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfileSample> samples) {
        this.head = head;
        this.samples = samples;
    }

    public SamplingHeapProfile() {
    }

}