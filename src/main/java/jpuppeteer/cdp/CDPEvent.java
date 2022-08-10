package jpuppeteer.cdp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import jpuppeteer.cdp.client.CDPEventType;
import jpuppeteer.util.JacksonUtil;


public class CDPEvent {

    public final CDPEventType method;

    private final JsonNode params;

    public CDPEvent(CDPEventType method, JsonNode params) {
        this.method = method;
        this.params = params;
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject() {
        try {
            Object result = JacksonUtil.INSTANCE.treeToValue(params, method.getClazz());
            if (result == null) {
                return null;
            }
            return (T) result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonNode convert to JavaObject `"+method.getClazz().getName()+"` failed");
        }
    }

    @Override
    public String toString() {
        return "CDPEvent{" +
                "method=" + method +
                ", params=" + params +
                '}';
    }
}
