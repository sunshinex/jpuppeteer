package jpuppeteer.chrome.entity;

import jpuppeteer.api.browser.Cookie;
import jpuppeteer.chrome.ChromeResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CookieEvent {

    private ChromeResponse response;

    private List<Cookie> cookies;

    public CookieEvent(ChromeResponse response, List<Cookie> cookies) {
        this.response = response;
        this.cookies = cookies;
    }
}
