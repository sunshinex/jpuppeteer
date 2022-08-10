package jpuppeteer.cdp.client.entity.network;

/**
*/
public class TakeResponseBodyForInterceptionAsStreamResponse {

    /**
    */
    private String stream;

    public void setStream (String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return this.stream;
    }

    public TakeResponseBodyForInterceptionAsStreamResponse(String stream) {
        this.stream = stream;
    }

    public TakeResponseBodyForInterceptionAsStreamResponse() {
    }

}