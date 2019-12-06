package jpuppeteer.chrome.util;

import jpuppeteer.cdp.cdp.entity.fetch.RequestPattern;

public class ObjectMapperUtils {

    public static RequestPattern create(String pattern) {
        RequestPattern requestPattern = new RequestPattern();
        requestPattern.setUrlPattern(pattern);
        return requestPattern;
    }

}
