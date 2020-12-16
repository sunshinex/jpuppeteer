package jpuppeteer.util;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import jpuppeteer.cdp.client.CDPEnum;
import org.apache.commons.lang3.EnumUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CDPEnumDeserializer implements ObjectDeserializer {

    private static Map<Type, Map<String, CDPEnum>> enumCache = new ConcurrentHashMap<>();

    private final ObjectDeserializer enumDeserializer;

    public CDPEnumDeserializer(ObjectDeserializer enumDeserializer) {
        this.enumDeserializer = enumDeserializer;
    }

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        if (type instanceof Class && CDPEnum.class.isAssignableFrom((Class) type)) {
            String value = parser.parseObject(String.class);
            if (value == null) {
                return null;
            }
            Map<String, CDPEnum> enumMap = enumCache.get(type);
            if (enumMap == null) {
                enumMap = new HashMap<>();
                List<CDPEnum> enums = EnumUtils.getEnumList((Class) type);
                for (CDPEnum cdpEnum : enums) {
                    enumMap.put(cdpEnum.value(), cdpEnum);
                }
                enumCache.put(type, enumMap);
            }
            return (T) enumMap.get(value);
        } else {
            return enumDeserializer.deserialze(parser, type, fieldName);
        }
    }

    @Override
    public int getFastMatchToken() {
        return enumDeserializer.getFastMatchToken();
    }

}
