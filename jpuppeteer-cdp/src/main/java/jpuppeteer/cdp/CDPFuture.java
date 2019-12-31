package jpuppeteer.cdp;

import com.alibaba.fastjson.JSONObject;
import jpuppeteer.api.future.FutureFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class CDPFuture<V> extends FutureFuture<JSONObject, V> {

    private final Class<V> clazz;

    public CDPFuture(Future<JSONObject> future, Class<V> clazz) {
        super(future, object -> object.toJavaObject(clazz));
        this.clazz = clazz;
    }
}
