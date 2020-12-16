package jpuppeteer.util;

import com.alibaba.fastjson.serializer.ValueFilter;
import jpuppeteer.cdp.client.CDPEnum;

import java.util.Collection;
import java.util.stream.Collectors;

public class CDPEnumFilter implements ValueFilter {

    @SuppressWarnings("unchecked")
    @Override
    public Object process(Object object, String name, Object value) {
        if (value instanceof CDPEnum) {
            return ((CDPEnum) value).value();
        } else if (value instanceof Collection) {
            Collection collection = (Collection) value;
            return collection.stream().map(o -> {
                if (o instanceof CDPEnum) {
                    return ((CDPEnum) o).value();
                } else {
                    return o;
                }
            }).collect(Collectors.toList());
        } else if (value instanceof Object[]) {
            Object[] array = (Object[]) value;
            for(int i=0; i<array.length; i++) {
                Object o = array[i];
                if (o instanceof CDPEnum) {
                    array[i] = ((CDPEnum) o).value();
                }
            }
            return array;
        } else {
            return value;
        }
    }
}
