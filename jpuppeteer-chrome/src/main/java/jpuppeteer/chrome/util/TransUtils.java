package jpuppeteer.chrome.util;

import jpuppeteer.api.browser.Cookie;

public class TransUtils {

    public static Cookie cookie(jpuppeteer.cdp.cdp.entity.network.Cookie cookie) {
        return Cookie.builder()
                .name(cookie.getName())
                .value(cookie.getValue())
                .domain(cookie.getDomain())
                .path(cookie.getPath())
                .expires(cookie.getExpires().longValue())
                .httpOnly(cookie.getHttpOnly())
                .secure(cookie.getSecure())
                .sameSite(cookie.getSameSite())
                .build();
    }

}
