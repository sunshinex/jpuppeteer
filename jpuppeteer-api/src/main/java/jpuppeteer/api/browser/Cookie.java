package jpuppeteer.api.browser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Cookie {

    private String name;

    private String value;

    private String url;

    private String domain;

    private String path;

    private boolean secure;

    private boolean httpOnly;

    private String sameSite;

    private Long expires;

}
