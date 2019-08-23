package jpuppeteer.chrome;


import com.sun.org.apache.xml.internal.security.utils.Base64;
import jpuppeteer.api.browser.Header;
import jpuppeteer.api.browser.Response;
import jpuppeteer.api.browser.SecurityDetails;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.cdp.domain.Network;
import jpuppeteer.cdp.cdp.entity.network.GetResponseBodyRequest;
import jpuppeteer.cdp.cdp.entity.network.GetResponseBodyResponse;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

@Setter
@ToString
@Builder
public class ChromeResponse implements Response {

    private static final Logger logger = LoggerFactory.getLogger(ChromeResponse.class);

    private transient CDPSession session;

    private transient Network network;

    private ChromeRequest request;

    private ChromeFrame frame;

    private URL url;

    private int status;

    private String statusText;

    private List<Header> headers;

    private boolean fromCache;

    private String content;

    private String remoteAddress;

    private SecurityDetails securityDetails;

    @Override
    public ChromeFrame frame() {
        return frame;
    }

    @Override
    public boolean fromCache() {
        return fromCache;
    }

    @Override
    public List<Header> headers() {
        return headers;
    }

    @Override
    public String remoteAddress() {
        return remoteAddress;
    }

    @Override
    public ChromeRequest request() {
        return request;
    }

    @Override
    public SecurityDetails securityDetails() {
        return securityDetails;
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
    public String content() {
        if (content != null) {
            return content;
        }
        GetResponseBodyRequest request = new GetResponseBodyRequest();
        request.setRequestId(request.getRequestId());
        try {
            GetResponseBodyResponse response = network.getResponseBody(request, DEFAULT_TIMEOUT);
            content = Boolean.TRUE.equals(response.getBase64Encoded()) ? new String(Base64.decode(response.getBody())) : response.getBody();
        } catch (Exception e) {
            logger.error("getResponseBody error, error={}", e.getMessage(), e);
        }
        return content;
    }

    @Override
    public URL url() {
        return url;
    }
}
