package jpuppeteer.entity;

import jpuppeteer.api.HttpHeader;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.client.entity.io.CloseRequest;
import jpuppeteer.cdp.client.entity.io.ReadRequest;
import jpuppeteer.cdp.client.entity.io.ReadResponse;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class HttpResource implements Closeable {

    private final CDPConnection connection;

    private final int status;

    private final HttpHeader[] headers;

    private final String stream;

    private volatile byte[] content;

    private volatile IOException error;

    public HttpResource(CDPConnection connection, int status, HttpHeader[] headers, String stream) {
        this.connection = connection;
        this.status = status;
        this.headers = headers;
        this.stream = stream;
    }

    public int status() {
        return status;
    }

    public HttpHeader[] headers() {
        return headers;
    }

    public String contentAsString() throws IOException {
        return new String(content(), StandardCharsets.UTF_8);
    }

    public synchronized byte[] content() throws IOException {
        if (error != null) {
            throw error;
        } else if (content != null) {
            return content;
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
                while (true) {
                    ReadResponse resp = connection.io.read(new ReadRequest(stream)).get(30, TimeUnit.SECONDS);
                    if (resp.getBase64Encoded()) {
                        bos.write(Base64.getDecoder().decode(resp.getData()));
                    } else {
                        bos.write(resp.getData().getBytes(StandardCharsets.UTF_8));
                    }
                    if (resp.getEof()) {
                        break;
                    }
                }
                content = bos.toByteArray();
                return content;
            } catch (Exception e) {
                error = new IOException("read failed", e);
                throw error;
            }
        }
    }

    @Override
    public void close() throws IOException {
        try {
            connection.io.close(new CloseRequest(stream)).get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new IOException("close failed", e);
        }
    }
}
