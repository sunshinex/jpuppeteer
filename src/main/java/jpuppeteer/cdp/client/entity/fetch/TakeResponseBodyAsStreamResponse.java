package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class TakeResponseBodyAsStreamResponse {

    /**
    */
    private String stream;

    public void setStream (String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return this.stream;
    }

    public TakeResponseBodyAsStreamResponse(String stream) {
        this.stream = stream;
    }

    public TakeResponseBodyAsStreamResponse() {
    }

}