package jpuppeteer.chrome.entity;

import jpuppeteer.api.constant.ResourceType;
import jpuppeteer.cdp.cdp.entity.network.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RequestEvent {

    private String frameId;

    private String requestId;

    private String loaderId;

    private String interceptorId;

    private ResourceType resourceType;

    private Request request;
}
