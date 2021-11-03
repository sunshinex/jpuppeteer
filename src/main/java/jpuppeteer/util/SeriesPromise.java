package jpuppeteer.util;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;

import java.lang.reflect.Method;
import java.util.function.Function;

@SuppressWarnings({"rawtypes","unchecked"})
public class SeriesPromise<V> extends DefaultPromise<V> {

    private static final Method PROMISE_EXECUTOR;

    static {
        try {
            PROMISE_EXECUTOR = DefaultPromise.class.getDeclaredMethod("executor");
            PROMISE_EXECUTOR.setAccessible(true);
        } catch (Throwable cause) {
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private final SeriesPromise<Object> prev;

    private SeriesPromise(EventExecutor executor, SeriesPromise<Object> prev) {
        super(executor);
        this.prev = prev;
    }

    public static <V> SeriesPromise<V> wrap(Future<V> future) {
        if (!(future instanceof DefaultPromise)) {
            throw new UnsupportedOperationException("future type not supported, supported:DefaultPromise");
        }
        try {
            EventExecutor executor = (EventExecutor) PROMISE_EXECUTOR.invoke(future);
            SeriesPromise<V> promise = new SeriesPromise<>(executor, null);
            future.addListener(f -> {
                if (f.isCancelled()) {
                    promise.cancel(true);
                } else if (f.isSuccess()) {
                    promise.trySuccess((V) f.getNow());
                } else {
                    promise.tryFailure(f.cause());
                }
            });
            promise.addListener(f -> {
                if (f.isCancelled()) {
                    future.cancel(true);
                }
            });
            return promise;
        } catch (Throwable cause) {
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        try {
            return super.cancel(mayInterruptIfRunning);
        } finally {
            if (prev != null) {
                prev.cancel(mayInterruptIfRunning);
            }
        }
    }

    public <R> SeriesPromise<R> async(Function<V, Future<R>> function) {
        SeriesPromise<R> promise = new SeriesPromise<>(executor(), (SeriesPromise<Object>) this);
        addListener(f0 -> {
            if (f0.cause() != null) {
                promise.tryFailure(f0.cause());
            } else {
                try {
                    function.apply((V) f0.getNow())
                            .addListener(f1 -> {
                                if (f1.cause() != null) {
                                    promise.tryFailure(f1.cause());
                                } else {
                                    promise.trySuccess((R) f1.getNow());
                                }
                            });
                } catch (Exception e) {
                    promise.tryFailure(e);
                }
            }
        });
        return promise;
    }

    public <R> SeriesPromise<R> sync(Function<V, R> function) {
        SeriesPromise<R> promise = new SeriesPromise<>(executor(), (SeriesPromise<Object>) this);
        addListener(f0 -> {
            if (f0.cause() != null) {
                promise.tryFailure(f0.cause());
            } else {
                try {
                    R r = function.apply((V) f0.getNow());
                    promise.trySuccess(r);
                } catch (Throwable cause) {
                    promise.tryFailure(cause);
                }
            }
        });
        return promise;
    }
}
