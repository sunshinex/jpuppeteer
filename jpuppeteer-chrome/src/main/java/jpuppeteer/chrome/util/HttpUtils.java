package jpuppeteer.chrome.util;

import com.google.common.collect.Lists;
import jpuppeteer.api.browser.Header;
import org.apache.commons.collections4.MapUtils;

import java.util.List;
import java.util.Map;

public class HttpUtils {

    public static List<Header> parseHeader(Map<String, Object> headerMap) {
        List<Header> headers = Lists.newArrayListWithCapacity(0);
        if (MapUtils.isNotEmpty(headerMap)) {
            for (Map.Entry<String, Object> entry : headerMap.entrySet()) {
                String[] items = entry.getValue().toString().split("\n");
                Header header = null;
                for (String item : items) {
                    if (header == null) {
                        header = new Header(entry.getKey(), item);
                    } else {
                        header.add(item);
                    }
                }
                if (header == null) {
                    continue;
                }
                headers.add(header);
            }
        }
        return headers;
    }

}
