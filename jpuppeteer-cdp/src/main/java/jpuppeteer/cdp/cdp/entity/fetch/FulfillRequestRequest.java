package jpuppeteer.cdp.cdp.entity.fetch;

/**
* experimental
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class FulfillRequestRequest {

    /**
    * An id the client received in requestPaused event.
    */
    private String requestId;

    /**
    * An HTTP response code.
    */
    private Integer responseCode;

    /**
    * Response headers.
    */
    private java.util.List<jpuppeteer.cdp.cdp.entity.fetch.HeaderEntry> responseHeaders;

    /**
    * A response body.
    */
    private String body;

    /**
    * A textual representation of responseCode. If absent, a standard phrase mathcing responseCode is used.
    */
    private String responsePhrase;



}