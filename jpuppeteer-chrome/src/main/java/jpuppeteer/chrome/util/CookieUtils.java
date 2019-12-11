package jpuppeteer.chrome.util;

import com.google.common.collect.Lists;
import jpuppeteer.api.browser.Cookie;
import jpuppeteer.api.browser.Header;
import jpuppeteer.cdp.cdp.entity.network.CookieParam;
import jpuppeteer.cdp.cdp.entity.network.SetCookiesRequest;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CookieUtils {

    public static SetCookiesRequest create(Cookie... cookies) {
        SetCookiesRequest request = new SetCookiesRequest();
        List<CookieParam> cookieParams = Lists.newArrayListWithCapacity(cookies.length);
        for(Cookie cookie : cookies) {
            CookieParam cookieParam = new CookieParam();
            cookieParam.setName(cookie.getName());
            cookieParam.setValue(cookie.getValue());
            cookieParam.setDomain(cookie.getDomain());
            cookieParam.setPath(cookie.getPath());
            cookieParam.setExpires(cookie.getExpires() != null ? Long.valueOf(cookie.getExpires().getTime() / 1000).doubleValue() : null);
            cookieParam.setSecure(cookie.isSecure());
            cookieParam.setHttpOnly(cookie.isHttpOnly());
            cookieParam.setSameSite(cookie.getSameSite());
            cookieParam.setUrl(cookie.getUrl());
            cookieParams.add(cookieParam);
        }
        request.setCookies(cookieParams);
        return request;
    }

    public static Cookie copyOf(jpuppeteer.cdp.cdp.entity.network.Cookie cookie) {
        return Cookie.builder()
                .name(cookie.getName())
                .value(cookie.getValue())
                .domain(cookie.getDomain())
                .path(cookie.getPath())
                .expires(cookie.getExpires() != null && cookie.getExpires() != -1 ? new Date(cookie.getExpires().longValue()) : null)
                .httpOnly(cookie.getHttpOnly())
                .secure(cookie.getSecure())
                .sameSite(cookie.getSameSite())
                .build();
    }

    /** This class should not be instantiated. */
    private CookieUtils() {
    }
}
