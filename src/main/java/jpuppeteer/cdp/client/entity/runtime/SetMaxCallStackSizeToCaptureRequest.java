package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class SetMaxCallStackSizeToCaptureRequest {

    /**
    */
    private Integer size;

    public void setSize (Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return this.size;
    }

    public SetMaxCallStackSizeToCaptureRequest(Integer size) {
        this.size = size;
    }

    public SetMaxCallStackSizeToCaptureRequest() {
    }

}