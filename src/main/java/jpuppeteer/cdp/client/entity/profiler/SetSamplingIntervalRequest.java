package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class SetSamplingIntervalRequest {

    /**
    * New sampling interval in microseconds.
    */
    public final Integer interval;

    public SetSamplingIntervalRequest(Integer interval) {
        this.interval = interval;
    }

}