package jpuppeteer.chrome;

import jpuppeteer.api.browser.Header;
import jpuppeteer.api.browser.Request;
import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.constant.network.ErrorReason;
import jpuppeteer.cdp.cdp.domain.Fetch;
import jpuppeteer.cdp.cdp.domain.Network;
import jpuppeteer.cdp.cdp.entity.fetch.ContinueRequestRequest;
import jpuppeteer.cdp.cdp.entity.fetch.FailRequestRequest;
import jpuppeteer.cdp.cdp.entity.fetch.HeaderEntry;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataRequest;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

@Getter
@ToString(exclude = {"response"})
@Builder
public class ChromeRequest implements Request {

    private static final Logger logger = LoggerFactory.getLogger(ChromeRequest.class);

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

    /**
     * 此处记录下一个请求, 也就是如果存在redirect的话, 此处会是一个链表
     */
    @Setter
    private ChromeRequest prev;

    @Setter
    private ChromeResponse response;

    @Setter
    private String interceptorId;

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

    @Override
    public Request prev() {
        return prev;
    }

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
            throw new RuntimeException("interceptorId undefined");
        }
        FailRequestRequest request = new FailRequestRequest();
        request.setRequestId(interceptorId);
        request.setErrorReason(ErrorReason.ABORTED.getValue());
        fetch.failRequest(request, DEFAULT_TIMEOUT);
    }

    @Override
    public void continues(Request request) throws Exception {
        if (StringUtils.isEmpty(interceptorId)) {
            throw new RuntimeException("interceptorId undefined");
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
    }
}
