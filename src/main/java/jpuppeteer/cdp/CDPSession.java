package jpuppeteer.cdp;

import com.alibaba.fastjson.TypeReference;
import io.netty.util.concurrent.Future;

import java.util.HashMap;
import java.util.Map;

public class CDPSession {

    protected static final String SESSION_ID = "sessionId";

    private final CDPConnection connection;

    private final String targetId;

    private final String sessionId;

    private final Map<String, Object> extra;

    protected CDPSession(CDPConnection connection, String targetId, String sessionId) {
        this.connection = connection;
        this.targetId = targetId;
        this.sessionId = sessionId;
        this.extra = new HashMap<>();
        this.extra.put(SESSION_ID, sessionId);
    }

    public String targetId() {
        return targetId;
    }

    public String sessionId() {
        return sessionId;
    }

    public final Future<Void> send(String method, Object params) {
        return connection.send(method, params, extra, o -> null);
    }

    public final <T> Future<T> send(String method, Object params, Class<T> clazz) {
        return connection.send(method, params, extra, clazz);
    }
}