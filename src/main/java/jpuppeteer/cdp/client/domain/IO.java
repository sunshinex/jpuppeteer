package jpuppeteer.cdp.client.domain;

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
    public io.netty.util.concurrent.Future close(jpuppeteer.cdp.client.entity.io.CloseRequest request) {
        return session.send("IO.close", request);
    }


    /**
    * Read a chunk of the stream
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.io.ReadResponse> read(jpuppeteer.cdp.client.entity.io.ReadRequest request) {
        return session.send("IO.read", request, jpuppeteer.cdp.client.entity.io.ReadResponse.class);
    }


    /**
    * Return UUID of Blob object specified by a remote object id.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.io.ResolveBlobResponse> resolveBlob(jpuppeteer.cdp.client.entity.io.ResolveBlobRequest request) {
        return session.send("IO.resolveBlob", request, jpuppeteer.cdp.client.entity.io.ResolveBlobResponse.class);
    }

}