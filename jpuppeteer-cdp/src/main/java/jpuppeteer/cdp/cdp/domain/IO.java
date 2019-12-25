package jpuppeteer.cdp.cdp.domain;

/**
*/
public class IO {

    private jpuppeteer.cdp.CDPSession session;

    public IO(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Close the stream, discard any temporary backing storage.
    */
    public void close(jpuppeteer.cdp.cdp.entity.io.CloseRequest request, int timeout) throws Exception {
        session.send("IO.close", request, timeout);
    }


    /**
    * Read a chunk of the stream
    */
    public jpuppeteer.cdp.cdp.entity.io.ReadResponse read(jpuppeteer.cdp.cdp.entity.io.ReadRequest request, int timeout) throws Exception {
        return session.send("IO.read", request, jpuppeteer.cdp.cdp.entity.io.ReadResponse.class, timeout);
    }


    /**
    * Return UUID of Blob object specified by a remote object id.
    */
    public jpuppeteer.cdp.cdp.entity.io.ResolveBlobResponse resolveBlob(jpuppeteer.cdp.cdp.entity.io.ResolveBlobRequest request, int timeout) throws Exception {
        return session.send("IO.resolveBlob", request, jpuppeteer.cdp.cdp.entity.io.ResolveBlobResponse.class, timeout);
    }

}