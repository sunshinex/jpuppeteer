package jpuppeteer.util;

import com.alibaba.fastjson.serializer.ValueFilter;
import jpuppeteer.cdp.client.CDPEnum;

public class CDPEnumFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        if (value instanceof CDPEnum) {
            return ((CDPEnum) value).value();
        } else {
            return value;
        }
    }
}
