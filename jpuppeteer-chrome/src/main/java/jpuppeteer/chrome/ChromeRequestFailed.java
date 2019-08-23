package jpuppeteer.chrome;

import jpuppeteer.cdp.cdp.constant.network.BlockedReason;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ChromeRequestFailed {

    private ChromeRequest request;

    private String errorText;

    private Boolean canceled;

    private BlockedReason blockedReason;
}
