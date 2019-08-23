package jpuppeteer.cdp;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CDPEvent {

    private String sessionId;

    private String method;

    private JSONObject params;

}
