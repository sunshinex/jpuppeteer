package jpuppeteer.api.event.page;

import com.google.common.base.Charsets;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.Frame;
import jpuppeteer.api.HttpHeader;
import jpuppeteer.api.InterceptedRequest;
import jpuppeteer.api.Request;
import jpuppeteer.cdp.client.constant.network.ErrorReason;
import jpuppeteer.cdp.client.constant.network.ResourceType;
import jpuppeteer.cdp.client.domain.Fetch;
import jpuppeteer.cdp.client.entity.fetch.*;
import jpuppeteer.util.SeriesPromise;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestInterceptedEvent extends FrameEvent implements InterceptedRequest {

    private static final Map<Integer, String> STATUS_TEXT = new ConcurrentHashMap<>();

    static {
        STATUS_TEXT.put(100, "Continue");
        STATUS_TEXT.put(101, "Switching Protocols");
        STATUS_TEXT.put(102, "Processing");
        STATUS_TEXT.put(103, "Early Hints");
        STATUS_TEXT.put(200, "OK");
        STATUS_TEXT.put(201, "Created");
        STATUS_TEXT.put(202, "Accepted");
        STATUS_TEXT.put(203, "Non-Authoritative Information");
        STATUS_TEXT.put(204, "No Content");
        STATUS_TEXT.put(205, "Reset Content");
        STATUS_TEXT.put(206, "Partial Content");
        STATUS_TEXT.put(207, "Multi-Status");
        STATUS_TEXT.put(208, "Already Reported");
        STATUS_TEXT.put(226, "IM Used");
        STATUS_TEXT.put(300, "Multiple Choices");
        STATUS_TEXT.put(301, "Moved Permanently");
        STATUS_TEXT.put(302, "Found");
        STATUS_TEXT.put(303, "See Other");
        STATUS_TEXT.put(304, "Not Modified");
        STATUS_TEXT.put(305, "Use Proxy");
        STATUS_TEXT.put(306, "Switch Proxy");
        STATUS_TEXT.put(307, "Temporary Redirect");
        STATUS_TEXT.put(308, "Permanent Redirect");
        STATUS_TEXT.put(400, "Bad Request");
        STATUS_TEXT.put(401, "Unauthorized");
        STATUS_TEXT.put(402, "Payment Required");
        STATUS_TEXT.put(403, "Forbidden");
        STATUS_TEXT.put(404, "Not Found");
        STATUS_TEXT.put(405, "Method Not Allowed");
        STATUS_TEXT.put(406, "Not Acceptable");
        STATUS_TEXT.put(407, "Proxy Authentication Required");
        STATUS_TEXT.put(408, "Request Timeout");
        STATUS_TEXT.put(409, "Conflict");
        STATUS_TEXT.put(410, "Gone");
        STATUS_TEXT.put(411, "Length Required");
        STATUS_TEXT.put(412, "Precondition Failed");
        STATUS_TEXT.put(413, "Payload Too Large");
        STATUS_TEXT.put(414, "URI Too Long");
        STATUS_TEXT.put(415, "Unsupported Media Type");
        STATUS_TEXT.put(416, "Range Not Satisfiable");
        STATUS_TEXT.put(417, "Expectation Failed");
        STATUS_TEXT.put(418, "I'm a teapot");
        STATUS_TEXT.put(421, "Misdirected Request");
        STATUS_TEXT.put(422, "Unprocessable Entity");
        STATUS_TEXT.put(423, "Locked");
        STATUS_TEXT.put(424, "Failed Dependency");
        STATUS_TEXT.put(425, "Too Early");
        STATUS_TEXT.put(426, "Upgrade Required");
        STATUS_TEXT.put(428, "Precondition Required");
        STATUS_TEXT.put(429, "Too Many Requests");
        STATUS_TEXT.put(431, "Request Header Fields Too Large");
        STATUS_TEXT.put(451, "Unavailable For Legal Reasons");
        STATUS_TEXT.put(500, "Internal Server Error");
        STATUS_TEXT.put(501, "Not Implemented");
        STATUS_TEXT.put(502, "Bad Gateway");
        STATUS_TEXT.put(503, "Service Unavailable");
        STATUS_TEXT.put(504, "Gateway Timeout");
        STATUS_TEXT.put(505, "HTTP Version Not Supported");
        STATUS_TEXT.put(506, "Variant Also Negotiates");
        STATUS_TEXT.put(507, "Insufficient Storage");
        STATUS_TEXT.put(508, "Loop Detected");
        STATUS_TEXT.put(510, "Not Extended");
        STATUS_TEXT.put(511, "Network Authentication Required");
    }

    private final Fetch fetch;

    private final EventExecutor executor;

    private final String interceptorId;

    private final Request request;

    private final ErrorReason responseErrorReason;

    private final Integer responseStatusCode;

    private final HttpHeader[] responseHeaders;

    private RequestInterceptedEvent(Frame frame, Fetch fetch, EventExecutor executor, String interceptorId, Request request, ErrorReason responseErrorReason, Integer responseStatusCode, HttpHeader[] responseHeaders) {
        super(frame);
        this.fetch = fetch;
        this.executor = executor;
        this.interceptorId = interceptorId;
        this.request = request;
        this.responseErrorReason = responseErrorReason;
        this.responseStatusCode = responseStatusCode;
        this.responseHeaders = responseHeaders;
    }

    @Override
    public Future continues(String method, String url, HttpHeader[] headers, byte[] body) {
        List<HeaderEntry> entries = null;
        if (headers != null && headers.length > 0) {
            entries = new ArrayList<>(headers.length);
            for (HttpHeader header : headers) {
                HeaderEntry entry = new HeaderEntry(header.name(), header.value());
                entries.add(entry);
            }
        }
        String base64Body = null;
        if (body != null) {
            base64Body = Base64.getEncoder().encodeToString(body);
        }
        ContinueRequestRequest request = new ContinueRequestRequest(interceptorId, url, method, base64Body, entries);
        return fetch.continueRequest(request);
    }

    @Override
    public String interceptorId() {
        return interceptorId;
    }

    @Override
    public ErrorReason responseErrorReason() {
        return responseErrorReason;
    }

    @Override
    public int responseStatusCode() {
        return responseStatusCode;
    }

    @Override
    public HttpHeader[] responseHeaders() {
        return responseHeaders;
    }

    @Override
    public Future<byte[]> responseBody() {
        return SeriesPromise
                .wrap(fetch.getResponseBody(new GetResponseBodyRequest(interceptorId)))
                .sync(o -> o.base64Encoded ? Base64.getDecoder().decode(o.body) : o.body.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public Future abort() {
        FailRequestRequest request = new FailRequestRequest(interceptorId, ErrorReason.ABORTED);
        return fetch.failRequest(request);
    }

    @Override
    public Future continues() {
        ContinueRequestRequest request = new ContinueRequestRequest(interceptorId);
        return fetch.continueRequest(request);
    }

    @Override
    public Future respond(int statusCode, HttpHeader[] headers, byte[] body) {
        if (!STATUS_TEXT.containsKey(statusCode)) {
            throw new RuntimeException("unknown statusCode " + statusCode);
        }
        String responsePhase = STATUS_TEXT.get(statusCode);
        Charset encoding = Charsets.UTF_8;
        boolean contentTypeDefined = false;
        List<HeaderEntry> entries = null;
        if (headers != null && headers.length > 0) {
            entries = new ArrayList<>(headers.length);
            for(HttpHeader header : headers) {
                if (
                        "transfer-encoding".equalsIgnoreCase(header.name()) ||
                        "content-length".equalsIgnoreCase(header.name())
                ) {
                    //这些无效的头需要丢弃掉
                    continue;
                } else if ("content-type".equalsIgnoreCase(header.name())) {
                    contentTypeDefined = true;
                }
                entries.add(new HeaderEntry(header.name(), header.value()));
            }
        }
        String encodedBody;
        int length;
        if (body != null) {
            length = body.length;
            byte[] encodedBodyBytes = Base64.getEncoder().encode(body);
            encodedBody = new String(encodedBodyBytes, encoding);
        } else {
            encodedBody = "";
            length = 0;
        }
        if (entries == null) {
            entries = new ArrayList<>(1);
        }
        entries.add(new HeaderEntry("Content-Length", String.valueOf(length)));
        if (!contentTypeDefined) {
            HeaderEntry contentTypeEntry = new HeaderEntry("Content-Type", "text/plain; charset=" + encoding.name());
            entries.add(contentTypeEntry);
        }
        FulfillRequestRequest request = new FulfillRequestRequest(
                interceptorId, statusCode, entries,
                null, encodedBody, responsePhase
        );
        return fetch.fulfillRequest(request);
    }

    @Override
    public String requestId() {
        return request.requestId();
    }

    @Override
    public String loaderId() {
        return request.loaderId();
    }

    @Override
    public String url() {
        return request.url();
    }

    @Override
    public String method() {
        return request.method();
    }

    @Override
    public HttpHeader[] headers() {
        return request.headers();
    }

    @Override
    public ResourceType resourceType() {
        return request.resourceType();
    }

    @Override
    public String location() {
        return request.location();
    }

    @Override
    public Future<String> content() {
        return request.content();
    }

    public static RequestInterceptedEventBuilder newBuilder() {
        return new RequestInterceptedEventBuilder();
    }

    public static final class RequestInterceptedEventBuilder {
        private Fetch fetch;
        private EventExecutor executor;
        private String interceptorId;
        private Request request;
        private ErrorReason responseErrorReason;
        private Integer responseStatusCode;
        private HttpHeader[] responseHeaders;
        private Frame frame;

        private RequestInterceptedEventBuilder() {
        }

        public static RequestInterceptedEventBuilder aRequestInterceptedEvent() {
            return new RequestInterceptedEventBuilder();
        }

        public RequestInterceptedEventBuilder fetch(Fetch fetch) {
            this.fetch = fetch;
            return this;
        }

        public RequestInterceptedEventBuilder executor(EventExecutor executor) {
            this.executor = executor;
            return this;
        }

        public RequestInterceptedEventBuilder interceptorId(String interceptorId) {
            this.interceptorId = interceptorId;
            return this;
        }

        public RequestInterceptedEventBuilder request(Request request) {
            this.request = request;
            return this;
        }

        public RequestInterceptedEventBuilder responseErrorReason(ErrorReason responseErrorReason) {
            this.responseErrorReason = responseErrorReason;
            return this;
        }

        public RequestInterceptedEventBuilder responseStatusCode(Integer responseStatusCode) {
            this.responseStatusCode = responseStatusCode;
            return this;
        }

        public RequestInterceptedEventBuilder responseHeaders(HttpHeader[] responseHeaders) {
            this.responseHeaders = responseHeaders;
            return this;
        }

        public RequestInterceptedEventBuilder frame(Frame frame) {
            this.frame = frame;
            return this;
        }

        public RequestInterceptedEvent build() {
            return new RequestInterceptedEvent(frame, fetch, executor, interceptorId, request, responseErrorReason, responseStatusCode, responseHeaders);
        }
    }
}
