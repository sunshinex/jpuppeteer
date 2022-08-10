package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class SetSamplingIntervalRequest {

    /**
    * New sampling interval in microseconds.
    */
    private Integer interval;

    public void setInterval (Integer interval) {
        this.interval = interval;
    }

    public Integer getInterval() {
        return this.interval;
    }

    public SetSamplingIntervalRequest(Integer interval) {
        this.interval = interval;
    }

    public SetSamplingIntervalRequest() {
    }

}