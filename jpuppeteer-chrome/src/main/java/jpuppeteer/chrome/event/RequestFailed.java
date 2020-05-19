package jpuppeteer.chrome.event;

import jpuppeteer.cdp.cdp.constant.network.BlockedReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class RequestFailed {

    private String requestId;

    //可能会没有request, request不会一直保存, 当进行垃圾回收的时候 会释放request
    private Request request;

    private String errorText;

    private Boolean canceled;

    private BlockedReason blockedReason;
}
