package jpuppeteer.api.future;


import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface Promise<V> extends Future<V> {

    Promise<V> await() throws InterruptedException;

    boolean await(long timeout, TimeUnit unit) throws InterruptedException;

    Promise<V> setSuccess(V result);

    boolean trySuccess(V result);

    Promise<V> setFailure(Throwable cause);

    boolean tryFailure(Throwable cause);

    boolean setUncancellable();

    V getNow();
}

