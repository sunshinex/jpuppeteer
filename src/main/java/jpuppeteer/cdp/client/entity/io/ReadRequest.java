package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ReadRequest {

    /**
    * Handle of the stream to read.
    */
    private String handle;

    /**
    * Seek to the specified offset before reading (if not specificed, proceed with offset following the last read). Some types of streams may only support sequential reads.
    */
    private Integer offset;

    /**
    * Maximum number of bytes to read (left upon the agent discretion if not specified).
    */
    private Integer size;

    public void setHandle (String handle) {
        this.handle = handle;
    }

    public String getHandle() {
        return this.handle;
    }

    public void setOffset (Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setSize (Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return this.size;
    }

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

    public ReadRequest() {
    }

}