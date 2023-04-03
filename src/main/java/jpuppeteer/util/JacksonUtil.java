package jpuppeteer.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.TimeZone;

public class JacksonUtil {

    public static final ObjectMapper INSTANCE = createMapper();

    private JacksonUtil() {

    }

    public static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return mapper;
    }

}
