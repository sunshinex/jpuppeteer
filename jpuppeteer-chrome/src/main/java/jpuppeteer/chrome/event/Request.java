package jpuppeteer.chrome.event;

import com.google.common.base.Charsets;
import jpuppeteer.api.browser.Header;
import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.constant.network.ErrorReason;
import jpuppeteer.cdp.cdp.domain.Fetch;
import jpuppeteer.cdp.cdp.domain.Network;
import jpuppeteer.cdp.cdp.entity.fetch.ContinueRequestRequest;
import jpuppeteer.cdp.cdp.entity.fetch.FailRequestRequest;
import jpuppeteer.cdp.cdp.entity.fetch.FulfillRequestRequest;
import jpuppeteer.cdp.cdp.entity.fetch.HeaderEntry;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataRequest;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataResponse;
import jpuppeteer.chrome.ChromeFrame;
import jpuppeteer.chrome.ChromeResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

@Getter
@ToString(exclude = {"response"})
@Builder
public class Request implements jpuppeteer.api.browser.Request {

    private static final Logger logger = LoggerFactory.getLogger(Request.class);

    private static final Map<Integer, String> STATUS_TEXT;

    private transient CDPSession session;

    private transient Network network;

    private transient Fetch fetch;

    private ChromeFrame frame;

    private String requestId;

    private String loaderId;

    private String method;

    private URL url;

    private ResourceType resourceType;

    private List<Header> headers;

    private transient boolean hasPostData;

    private String postData;

    @Setter
    private ChromeResponse response;

    private String interceptorId;

    static {
        STATUS_TEXT = new HashMap<>();
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

    @Override
    public ChromeFrame frame() {
        return frame;
    }

    @Override
    public List<Header> headers() {
        return headers;
    }

    @Override
    public boolean isNavigationRequest() {
        return StringUtils.equals(requestId, loaderId) && ResourceType.DOCUMENT.equals(resourceType);
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public String postData() {
        if (!hasPostData) {
            return null;
        }
        if (postData != null) {
            return postData;
        }
        GetRequestPostDataRequest request = new GetRequestPostDataRequest();
        request.setRequestId(requestId);
        try {
            GetRequestPostDataResponse response = network.getRequestPostData(request, DEFAULT_TIMEOUT);
            postData = response.getPostData();
        } catch (Exception e) {
            logger.error("getRequestPostData failed, error={}", e.getMessage(), e);
        }
        return postData;
    }
//
//    @Override
//    public Request prev() {
//        return prev;
//    }

    @Override
    public ResourceType resourceType() {
        return resourceType;
    }

    @Override
    public ChromeResponse response() {
        return response;
    }

    @Override
    public URL url() {
        return url;
    }

    @Override
    public void abort() throws Exception {
        if (StringUtils.isEmpty(interceptorId)) {
            logger.warn("interceptorId undefined, requestId={}", requestId);
            return;
        }
        FailRequestRequest request = new FailRequestRequest();
        request.setRequestId(interceptorId);
        request.setErrorReason(ErrorReason.ABORTED.getValue());
        fetch.failRequest(request, DEFAULT_TIMEOUT);
        //终止请求成功之后, 置空拦截ID
        this.interceptorId = null;
    }

    @Override
    public void continues(jpuppeteer.api.browser.Request request) throws Exception {
        if (StringUtils.isEmpty(interceptorId)) {
            logger.warn("interceptorId undefined, requestId={}", requestId);
            return;
        }
        ContinueRequestRequest req = new ContinueRequestRequest();
        req.setRequestId(interceptorId);
        if (request != null) {
            if (request.url() != null) {
                req.setUrl(request.url().toString());
            }
            if (request.method() != null) {
                req.setMethod(request.method());
            }
            if (request.postData() != null) {
                req.setPostData(request.postData());
            }
            if (CollectionUtils.isNotEmpty(request.headers())) {
                List<HeaderEntry> entries = new ArrayList<>();
                for (Header header : request.headers()) {
                    HeaderEntry entry = new HeaderEntry();
                    entry.setName(header.getName());
                    entry.setValue(StringUtils.join(header.getValues(), System.lineSeparator()));
                    entries.add(entry);
                }
                req.setHeaders(entries);
            }
        }
        fetch.continueRequest(req, DEFAULT_TIMEOUT);
        //放行请求成功之后, 置空拦截ID
        this.interceptorId = null;
    }

    @Override
    public void respond(int statusCode, List<Header> headers, byte[] body) throws Exception {
        if (StringUtils.isEmpty(interceptorId)) {
            logger.warn("interceptorId undefined, requestId={}", requestId);
            return;
        }
        if (!STATUS_TEXT.containsKey(statusCode)) {
            throw new RuntimeException("unknown statusCode " + statusCode);
        }
        FulfillRequestRequest request = new FulfillRequestRequest();
        request.setRequestId(interceptorId);
        request.setResponseCode(statusCode);
        request.setResponsePhrase(STATUS_TEXT.get(statusCode));
        Charset encoding = Charsets.UTF_8;
        if (CollectionUtils.isNotEmpty(headers)) {
            List<HeaderEntry> entries = new ArrayList<>(headers.size());
            for(Header header : headers) {
                HeaderEntry entry = new HeaderEntry();
                entry.setName(header.getName());
                entry.setValue(StringUtils.join(header.getValues(), System.lineSeparator()));
                entries.add(entry);
                if ("Content-Type".equalsIgnoreCase(header.getName())) {
                    String[] types = header.getValue().toLowerCase().split("charset=");
                    if (types.length == 2) {
                        try {
                            encoding = Charset.forName(types[1].trim());
                            logger.info("auto detected encoding success {}", encoding);
                        } catch (Exception e) {
                            logger.error("auto detected encoding failed, error={}", e.getMessage(), e);
                        }
                    }
                }
            }
            request.setResponseHeaders(entries);
        }
        if (body != null) {
            byte[] encodedBodyBytes = Base64.getEncoder().encode(body);
            String encodedBody = new String(encodedBodyBytes, encoding);
            request.setBody(encodedBody);
            if (request.getResponseHeaders() == null) {
                request.setResponseHeaders(new ArrayList<>(1));
            }
            HeaderEntry entry = new HeaderEntry();
            entry.setName("Content-Length");
            entry.setValue(String.valueOf(encodedBodyBytes.length));
            request.getResponseHeaders().add(entry);
        }
        fetch.fulfillRequest(request, DEFAULT_TIMEOUT);
        //完成请求成功之后, 置空拦截ID
        this.interceptorId = null;
    }
}
