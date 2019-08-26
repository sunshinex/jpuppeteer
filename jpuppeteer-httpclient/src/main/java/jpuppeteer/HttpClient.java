package jpuppeteer;

import jpuppeteer.api.browser.Browser;
import jpuppeteer.chrome.ChromeLauncher;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.apache.http.cookie.ClientCookie.*;

public class HttpClient {

    private static final String DEFAULT_USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    public static void main(String... args) throws Exception {
        RequestConfig requestConfig = RequestConfig.custom()
                .setCircularRedirectsAllowed(false)//不允许循环重定向
                .setSocketTimeout(10000)//read timeout 10s
                .setConnectTimeout(10000)//connect timeout 10s
                .setConnectionRequestTimeout(10000)//从ConnectionManager拿connection超时10s
                .setCookieSpec(CookieSpecs.STANDARD)
                .build();
        List<BasicHeader> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip, deflate, br"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"));
        headers.add(new BasicHeader("Connection", "keep-alive"));
        headers.add(new BasicHeader("Upgrade-Insecure-Requests", "1"));

        Browser browser = new ChromeLauncher(new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")).launch(args);

        CookieStore cookieStore = new SharedCookieStore(browser);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setUserAgent(DEFAULT_USERAGENT)
                .setDefaultHeaders(headers)
                .setConnectionTimeToLive(120, TimeUnit.SECONDS)//keep alive 维持2分钟
                .setDefaultRequestConfig(requestConfig)
                .setDefaultCookieStore(cookieStore)
//				.setProxy(new HttpHost("127.0.0.1", 8888))
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();
    }

    public static class SharedCookieStore implements CookieStore {

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
            try {
                List<jpuppeteer.api.browser.Cookie> expired = browser.cookies().stream()
                        .filter(cookie -> cookie.getExpires() != -1 ? cookie.getExpires() < date.getTime() / 1000 : false)
                        .collect(Collectors.toList());
                browser.
            } catch (Exception e) {
            }
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
}
