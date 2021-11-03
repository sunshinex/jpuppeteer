package jpuppeteer.cdp.client.domain;

/**
*/
public class IO {

    private jpuppeteer.cdp.CDPConnection connection;

    public IO(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Close the stream, discard any temporary backing storage.
    */
    public io.netty.util.concurrent.Future close(jpuppeteer.cdp.client.entity.io.CloseRequest request) {
        return connection.send("IO.close", request);
    }


    /**
    * Read a chunk of the stream
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.io.ReadResponse> read(jpuppeteer.cdp.client.entity.io.ReadRequest request) {
        return connection.send("IO.read", request, jpuppeteer.cdp.client.entity.io.ReadResponse.class);
    }


    /**
    * Return UUID of Blob object specified by a remote object id.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.io.ResolveBlobResponse> resolveBlob(jpuppeteer.cdp.client.entity.io.ResolveBlobRequest request) {
        return connection.send("IO.resolveBlob", request, jpuppeteer.cdp.client.entity.io.ResolveBlobResponse.class);
    }

}