package jpuppeteer.util;

import jpuppeteer.cdp.client.constant.network.CookiePriority;
import jpuppeteer.cdp.client.constant.network.CookieSameSite;
import jpuppeteer.cdp.client.constant.network.CookieSourceScheme;
import jpuppeteer.cdp.client.entity.network.CookieParam;

import java.math.BigDecimal;

public final class CookieParamBuilder {
    private String name;
    private String value;
    private String url;
    private String domain;
    private String path;
    private Boolean secure;
    private Boolean httpOnly;
    private jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite;
    private java.math.BigDecimal expires;
    private jpuppeteer.cdp.client.constant.network.CookiePriority priority;
    private Boolean sameParty;
    private jpuppeteer.cdp.client.constant.network.CookieSourceScheme sourceScheme;
    private Integer sourcePort;

    private CookieParamBuilder() {
    }

    public static CookieParamBuilder newBuilder() {
        return new CookieParamBuilder();
    }

    public CookieParamBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CookieParamBuilder value(String value) {
        this.value = value;
        return this;
    }

    public CookieParamBuilder url(String url) {
        this.url = url;
        return this;
    }

    public CookieParamBuilder domain(String domain) {
        this.domain = domain;
        return this;
    }

    public CookieParamBuilder path(String path) {
        this.path = path;
        return this;
    }

    public CookieParamBuilder secure(Boolean secure) {
        this.secure = secure;
        return this;
    }

    public CookieParamBuilder httpOnly(Boolean httpOnly) {
        this.httpOnly = httpOnly;
        return this;
    }

    public CookieParamBuilder sameSite(CookieSameSite sameSite) {
        this.sameSite = sameSite;
        return this;
    }

    public CookieParamBuilder expires(BigDecimal expires) {
        this.expires = expires;
        return this;
    }

    public CookieParamBuilder priority(CookiePriority priority) {
        this.priority = priority;
        return this;
    }

    public CookieParamBuilder sameParty(Boolean sameParty) {
        this.sameParty = sameParty;
        return this;
    }

    public CookieParamBuilder sourceScheme(CookieSourceScheme sourceScheme) {
        this.sourceScheme = sourceScheme;
        return this;
    }

    public CookieParamBuilder sourcePort(Integer sourcePort) {
        this.sourcePort = sourcePort;
        return this;
    }

    public CookieParam build() {
        return new CookieParam(name, value, url, domain, path, secure, httpOnly, sameSite, expires, priority, sameParty, sourceScheme, sourcePort);
    }
}
