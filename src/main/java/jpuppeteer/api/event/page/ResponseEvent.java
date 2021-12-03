package jpuppeteer.api.event.page;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.Frame;
import jpuppeteer.api.HttpHeader;
import jpuppeteer.api.Response;
import jpuppeteer.cdp.client.constant.network.ResourceType;
import jpuppeteer.cdp.client.domain.Network;
import jpuppeteer.cdp.client.entity.network.GetResponseBodyRequest;
import jpuppeteer.util.SeriesPromise;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ResponseEvent extends FrameEvent implements Response {

    private final Network network;

    private final EventExecutor executor;

    private final String requestId;

    private final String loaderId;

    private final ResourceType resourceType;

    private final String url;

    private final String protocol;

    private final Integer status;

    private final String statusText;

    private final String mimeType;

    private final HttpHeader[] headers;

    private final HttpHeader[] requestHeaders;

    private final Boolean connectionReused;

    private final Integer connectionId;

    private final InetSocketAddress remoteAddress;

    private final Boolean fromDiskCache;

    private final Boolean fromServiceWorker;

    private final Boolean fromPrefetchCache;

    private final Integer encodedDataLength;

    private ResponseEvent(Frame frame, Network network, EventExecutor executor, String requestId, String loaderId, ResourceType resourceType, String url, String protocol, Integer status, String statusText, String mimeType, HttpHeader[] headers, HttpHeader[] requestHeaders, Boolean connectionReused, Integer connectionId, InetSocketAddress remoteAddress, Boolean fromDiskCache, Boolean fromServiceWorker, Boolean fromPrefetchCache, Integer encodedDataLength) {
        super(frame);
        this.network = network;
        this.executor = executor;
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.resourceType = resourceType;
        this.url = url;
        this.protocol = protocol;
        this.status = status;
        this.statusText = statusText;
        this.mimeType = mimeType;
        this.headers = headers;
        this.requestHeaders = requestHeaders;
        this.connectionReused = connectionReused;
        this.connectionId = connectionId;
        this.remoteAddress = remoteAddress;
        this.fromDiskCache = fromDiskCache;
        this.fromServiceWorker = fromServiceWorker;
        this.fromPrefetchCache = fromPrefetchCache;
        this.encodedDataLength = encodedDataLength;
    }

    @Override
    public String requestId() {
        return requestId;
    }

    @Override
    public String loaderId() {
        return loaderId;
    }

    @Override
    public ResourceType resourceType() {
        return resourceType;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public String protocol() {
        return protocol;
    }

    @Override
    public int status() {
        return status;
    }

    @Override
    public String statusText() {
        return statusText;
    }

    @Override
    public String mimeType() {
        return mimeType;
    }

    @Override
    public HttpHeader[] headers() {
        return headers;
    }

    @Override
    public HttpHeader[] requestHeaders() {
        return requestHeaders;
    }

    @Override
    public boolean connectionReused() {
        return connectionReused;
    }

    @Override
    public int connectionId() {
        return connectionId;
    }

    @Override
    public InetSocketAddress remoteAddress() {
        return remoteAddress;
    }

    @Override
    public boolean fromDiskCache() {
        return fromDiskCache;
    }

    @Override
    public boolean fromServiceWorker() {
        return fromServiceWorker;
    }

    @Override
    public boolean fromPrefetchCache() {
        return fromPrefetchCache;
    }

    @Override
    public int encodedDataLength() {
        return encodedDataLength;
    }

    @Override
    public Future<byte[]> content() {
        if (encodedDataLength == 0) {
            return null;
        }
        return SeriesPromise
                .wrap(network.getResponseBody(new GetResponseBodyRequest(requestId)))
                .sync(o -> o.base64Encoded ? Base64.getDecoder().decode(o.body) : o.body.getBytes(StandardCharsets.UTF_8));
    }

    public static ResponseEventBuilder newBuilder() {
        return new ResponseEventBuilder();
    }

    public static final class ResponseEventBuilder {
        private Network network;
        private EventExecutor executor;
        private String requestId;
        private String loaderId;
        private ResourceType resourceType;
        private String url;
        private String protocol;
        private Integer status;
        private String statusText;
        private String mimeType;
        private HttpHeader[] headers;
        private HttpHeader[] requestHeaders;
        private Boolean connectionReused;
        private Integer connectionId;
        private InetSocketAddress remoteAddress;
        private Boolean fromDiskCache;
        private Boolean fromServiceWorker;
        private Boolean fromPrefetchCache;
        private Integer encodedDataLength;
        private Frame frame;

        private ResponseEventBuilder() {
        }

        public ResponseEventBuilder network(Network network) {
            this.network = network;
            return this;
        }

        public ResponseEventBuilder executor(EventExecutor executor) {
            this.executor = executor;
            return this;
        }

        public ResponseEventBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public ResponseEventBuilder loaderId(String loaderId) {
            this.loaderId = loaderId;
            return this;
        }

        public ResponseEventBuilder resourceType(ResourceType resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        public ResponseEventBuilder url(String url) {
            this.url = url;
            return this;
        }

        public ResponseEventBuilder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public ResponseEventBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ResponseEventBuilder statusText(String statusText) {
            this.statusText = statusText;
            return this;
        }

        public ResponseEventBuilder mimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public ResponseEventBuilder headers(HttpHeader[] headers) {
            this.headers = headers;
            return this;
        }

        public ResponseEventBuilder requestHeaders(HttpHeader[] requestHeaders) {
            this.requestHeaders = requestHeaders;
            return this;
        }

        public ResponseEventBuilder connectionReused(Boolean connectionReused) {
            this.connectionReused = connectionReused;
            return this;
        }

        public ResponseEventBuilder connectionId(Integer connectionId) {
            this.connectionId = connectionId;
            return this;
        }

        public ResponseEventBuilder remoteAddress(InetSocketAddress remoteAddress) {
            this.remoteAddress = remoteAddress;
            return this;
        }

        public ResponseEventBuilder fromDiskCache(Boolean fromDiskCache) {
            this.fromDiskCache = fromDiskCache;
            return this;
        }

        public ResponseEventBuilder fromServiceWorker(Boolean fromServiceWorker) {
            this.fromServiceWorker = fromServiceWorker;
            return this;
        }

        public ResponseEventBuilder fromPrefetchCache(Boolean fromPrefetchCache) {
            this.fromPrefetchCache = fromPrefetchCache;
            return this;
        }

        public ResponseEventBuilder encodedDataLength(Integer encodedDataLength) {
            this.encodedDataLength = encodedDataLength;
            return this;
        }

        public ResponseEventBuilder frame(Frame frame) {
            this.frame = frame;
            return this;
        }

        public ResponseEvent build() {
            return new ResponseEvent(frame, network, executor, requestId, loaderId, resourceType, url, protocol, status, statusText, mimeType, headers, requestHeaders, connectionReused, connectionId, remoteAddress, fromDiskCache, fromServiceWorker, fromPrefetchCache, encodedDataLength);
        }
    }
}
