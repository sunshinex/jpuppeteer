package jpuppeteer.chrome;

import jpuppeteer.api.browser.Header;
import jpuppeteer.api.browser.Request;
import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.domain.Network;
import jpuppeteer.cdp.cdp.entity.network.ContinueInterceptedRequestRequest;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataRequest;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

@Getter
@ToString(exclude = {"response"})
@Builder
public class ChromeRequest implements Request {

    private static final Logger logger = LoggerFactory.getLogger(ChromeRequest.class);

    private transient CDPSession session;

    private transient Network network;

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
    public void abort() {
        ContinueInterceptedRequestRequest request = new ContinueInterceptedRequestRequest();
    }

    @Override
    public void failure() {

    }

    @Override
    public void continues() {

    }
}
