package jpuppeteer.httpclient;

import jpuppeteer.api.browser.Browser;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.http.cookie.ClientCookie.*;

public class SharedCookieStore implements CookieStore {

    private static final Logger logger = LoggerFactory.getLogger(SharedCookieStore.class);

    private Browser browser;

    public SharedCookieStore(Browser browser) {
        this.browser = browser;
    }

    @Override
    public void addCookie(Cookie cookie) {
        /**
         * @see org.apache.http.impl.cookie.RFC6265CookieSpec#parse(org.apache.http.Header, org.apache.http.cookie.CookieOrigin)
         * 因为RFC6265中cookie的domain定义如果需要应用于二级域名的话, 不在需要前导的(.) 所以RFC6265CookieSpec.parse方法在解析cookie的时候去掉的前导的(.) 但是attributes中的domain保存了原始的值, 此处把他还原回来
         */
        if (cookie instanceof BasicClientCookie) {
            BasicClientCookie bcCookie = (BasicClientCookie) cookie;
            String domain = bcCookie.getAttribute(DOMAIN_ATTR);
            if (!StringUtils.isEmpty(domain)) {
                bcCookie.setDomain(domain);
            }
        }
        jpuppeteer.api.browser.Cookie ck = jpuppeteer.api.browser.Cookie.builder()
                .name(cookie.getName())
                .value(cookie.getValue())
                .domain(cookie.getDomain())
                .path(cookie.getPath())
                .secure(cookie.isSecure())
                .httpOnly(false)
                .expires(cookie.isPersistent() ? cookie.getExpiryDate().getTime() / 1000 : -1)
                .sameSite(null)
                .build();
        try {
            browser.setCookie(ck);
        } catch (Exception e) {
            logger.error("add cookie failed, error={}", e.getMessage(), e);
        }
    }

    @Override
    public List<Cookie> getCookies() {
        List<Cookie> cookies = null;
        try {
            cookies = browser.cookies().stream().map(cookie -> {
                BasicClientCookie basicClientCookie = new BasicClientCookie(cookie.getName(), cookie.getValue());
                basicClientCookie.setDomain(cookie.getDomain());
                basicClientCookie.setPath(cookie.getPath());
                basicClientCookie.setExpiryDate(cookie.getExpires() != -1 ? new Date(cookie.getExpires() * 1000) : null);
                basicClientCookie.setSecure(cookie.isSecure());
                basicClientCookie.setVersion(1);

                /**
                 * 这一句很重要, 不然二级域名不能共享cookie
                 * @see org.apache.http.impl.cookie.BasicDomainHandler#match 这里面会判断是否存在DOMAIN_ATTR, 但是前面根本没有设置
                 */
                basicClientCookie.setAttribute(DOMAIN_ATTR, cookie.getDomain());
                basicClientCookie.setAttribute(PATH_ATTR, cookie.getPath());
                if (basicClientCookie.getExpiryDate() != null) {
                    basicClientCookie.setAttribute(EXPIRES_ATTR, DateFormatUtils.format(basicClientCookie.getExpiryDate(), "yyyy-MM-dd HH:mm:ss"));
                }
                basicClientCookie.setAttribute(SECURE_ATTR, cookie.isSecure() ? "true" : "false");
                return basicClientCookie;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("get cookies failed, error={}", e.getMessage(), e);
        }
        return cookies;
    }

    @Override
    public boolean clearExpired(Date date) {
        boolean success = true;
        try {
            List<jpuppeteer.api.browser.Cookie> expired = browser.cookies().stream()
                    .filter(cookie -> cookie.getExpires() != -1 ? cookie.getExpires() < date.getTime() / 1000 : false)
                    .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(expired)) {
                browser.deleteCookie(expired.toArray(new jpuppeteer.api.browser.Cookie[expired.size()]));
            }
        } catch (Exception e) {
            success = false;
            logger.error("delete expired cookies failed, error={}", e.getMessage(), e);
        }
        return success;
    }

    @Override
    public void clear() {
        try {
            browser.clearCookie();
        } catch (Exception e) {
            logger.error("clear cookies failed, error={}", e.getMessage(), e);
        }
    }
}
