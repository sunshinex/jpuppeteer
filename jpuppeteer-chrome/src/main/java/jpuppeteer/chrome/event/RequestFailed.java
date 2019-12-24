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

    private Request request;

    private String errorText;

    private Boolean canceled;

    private BlockedReason blockedReason;
}
