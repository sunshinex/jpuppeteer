package jpuppeteer.api.event.page;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import jpuppeteer.api.Frame;
import jpuppeteer.api.HttpHeader;
import jpuppeteer.api.Request;
import jpuppeteer.api.event.FrameEvent;
import jpuppeteer.cdp.client.constant.network.ResourceType;
import jpuppeteer.cdp.client.domain.Network;
import jpuppeteer.cdp.client.entity.network.GetRequestPostDataRequest;
import jpuppeteer.util.SeriesFuture;
import org.apache.commons.lang3.StringUtils;

public class RequestEvent extends FrameEvent implements Request {

    private final Network network;

    private final EventExecutor executor;

    private final String requestId;

    private final String loaderId;

    private final String url;

    private final String method;

    private final HttpHeader[] headers;

    private final ResourceType resourceType;

    private final String location;

    private final Boolean hasPostData;

    private final String postData;

    private RequestEvent(Frame frame, Network network, EventExecutor executor, String requestId, String loaderId, String url, String method, HttpHeader[] headers, ResourceType resourceType, String location, Boolean hasPostData, String postData) {
        super(frame);
        this.network = network;
        this.executor = executor;
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.resourceType = resourceType;
        this.location = location;
        this.hasPostData = hasPostData;
        this.postData = postData;
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
    public String url() {
        return url;
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public HttpHeader[] headers() {
        return headers;
    }

    @Override
    public ResourceType resourceType() {
        return resourceType;
    }

    @Override
    public String location() {
        return location;
    }

    @Override
    public Future<String> content() {
        if (!hasPostData) {
            return null;
        }
        if (postData != null) {
            Promise<String> promise = new DefaultPromise<>(executor);
            promise.trySuccess(postData);
            return promise;
        }
        return SeriesFuture
                .wrap(network.getRequestPostData(new GetRequestPostDataRequest(requestId)))
                .sync(o -> o.postData);
    }

    public static RequestEventBuilder newBuilder() {
        return new RequestEventBuilder();
    }

    public static final class RequestEventBuilder {
        private Network network;
        private EventExecutor executor;
        private String requestId;
        private String loaderId;
        private String url;
        private String method;
        private HttpHeader[] headers;
        private ResourceType resourceType;
        private String location;
        private Boolean hasPostData;
        private String postData;
        private Frame frame;

        private RequestEventBuilder() {
        }

        public static RequestEventBuilder aRequestEvent() {
            return new RequestEventBuilder();
        }

        public RequestEventBuilder network(Network network) {
            this.network = network;
            return this;
        }

        public RequestEventBuilder executor(EventExecutor executor) {
            this.executor = executor;
            return this;
        }

        public RequestEventBuilder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public RequestEventBuilder loaderId(String loaderId) {
            this.loaderId = loaderId;
            return this;
        }

        public RequestEventBuilder url(String url) {
            this.url = url;
            return this;
        }

        public RequestEventBuilder method(String method) {
            this.method = method;
            return this;
        }

        public RequestEventBuilder headers(HttpHeader[] headers) {
            this.headers = headers;
            return this;
        }

        public RequestEventBuilder resourceType(ResourceType resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        public RequestEventBuilder location(String location) {
            this.location = location;
            return this;
        }

        public RequestEventBuilder hasPostData(Boolean hasPostData) {
            this.hasPostData = hasPostData;
            return this;
        }

        public RequestEventBuilder postData(String postData) {
            this.postData = postData;
            return this;
        }

        public RequestEventBuilder frame(Frame frame) {
            this.frame = frame;
            return this;
        }

        public RequestEvent build() {
            return new RequestEvent(frame, network, executor, requestId, loaderId, url, method, headers, resourceType, location, hasPostData, postData);
        }
    }
}
