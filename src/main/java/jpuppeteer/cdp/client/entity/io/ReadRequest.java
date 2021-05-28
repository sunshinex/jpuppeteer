package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ReadRequest {

    /**
    * Handle of the stream to read.
    */
    public final String handle;

    /**
    * Seek to the specified offset before reading (if not specificed, proceed with offset following the last read). Some types of streams may only support sequential reads.
    */
    public final Integer offset;

    /**
    * Maximum number of bytes to read (left upon the agent discretion if not specified).
    */
    public final Integer size;

    public ReadRequest(String handle, Integer offset, Integer size) {
        this.handle = handle;
        this.offset = offset;
        this.size = size;
    }

    public ReadRequest(String handle) {
        this.handle = handle;
        this.offset = null;
        this.size = null;
    }

}