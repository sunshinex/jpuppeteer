package jpuppeteer.chrome.event;

import jpuppeteer.api.browser.Header;
import jpuppeteer.api.browser.Request;
import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.domain.Fetch;
import jpuppeteer.cdp.cdp.domain.Network;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataRequest;
import jpuppeteer.cdp.cdp.entity.network.GetRequestPostDataResponse;
import jpuppeteer.chrome.ChromeFrame;
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
public class RequestImpl implements Request {

    private static final Logger logger = LoggerFactory.getLogger(RequestImpl.class);

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

    private volatile String postData;

    @Setter
    private volatile ResponseImpl response;

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
    public String content() {
        if (!hasPostData) {
            return null;
        }
        if (postData == null) {
            synchronized (this) {
                if (postData == null) {
                    GetRequestPostDataRequest request = new GetRequestPostDataRequest();
                    request.setRequestId(requestId);
                    try {
                        GetRequestPostDataResponse response = network.getRequestPostData(request, DEFAULT_TIMEOUT);
                        postData = response.getPostData();
                    } catch (Exception e) {
                        logger.error("getRequestPostData failed, error={}", e.getMessage(), e);
                    }
                }
            }
        }
        return postData;
    }

    @Override
    public ResourceType resourceType() {
        return resourceType;
    }

    @Override
    public ResponseImpl response() {
        return response;
    }

    @Override
    public URL url() {
        return url;
    }
}
