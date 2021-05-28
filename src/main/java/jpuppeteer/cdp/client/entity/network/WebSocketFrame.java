package jpuppeteer.cdp.client.entity.network;

/**
* WebSocket message data. This represents an entire WebSocket message, not just a fragmented frame as the name suggests.
*/
public class WebSocketFrame {

    /**
    * WebSocket message opcode.
    */
    public final java.math.BigDecimal opcode;

    /**
    * WebSocket message mask.
    */
    public final Boolean mask;

    /**
    * WebSocket message payload data. If the opcode is 1, this is a text message and payloadData is a UTF-8 string. If the opcode isn't 1, then payloadData is a base64 encoded string representing binary data.
    */
    public final String payloadData;

    public WebSocketFrame(java.math.BigDecimal opcode, Boolean mask, String payloadData) {
        this.opcode = opcode;
        this.mask = mask;
        this.payloadData = payloadData;
    }

}