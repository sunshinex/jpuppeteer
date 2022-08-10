package jpuppeteer.util;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

@SuppressWarnings({"unchecked"})
public class XPromise<V> extends DefaultPromise<V> implements XFuture<V> {

    private static final Method PROMISE_EXECUTOR;

    static {
        try {
            PROMISE_EXECUTOR = DefaultPromise.class.getDeclaredMethod("executor");
            PROMISE_EXECUTOR.setAccessible(true);
        } catch (Throwable cause) {
            throw new RuntimeException("初始化XPromise失败", cause);
        }
    }

    private final EventExecutor executor;

    private final AtomicInteger indexCounter;

    private final Series results;

    private XPromise(XPromise<?> parent) {
        super(parent.executor);
        this.executor = parent.executor;
        this.indexCounter = parent.indexCounter;
        this.results = new Series(parent.results.results, this.indexCounter.getAndIncrement());
    }

    public XPromise(EventExecutor executor) {
        super(executor);
        this.executor = executor;
        this.indexCounter = new AtomicInteger(0);
        this.results = new Series(new ArrayList<>(), this.indexCounter.getAndIncrement());
    }

    @Override
    public <R> XFuture<R> sync(Function<V, R> function) {
        return xSync((series, v) -> function.apply(v));
    }

    @Override
    public <R> XFuture<R> async(Function<V, Future<R>> function) {
        return xAsync((series, v) -> function.apply(v));
    }

    @Override
    public <R> XFuture<R> xSync(XFunction<V, R> function) {
        XPromise<R> promise = new XPromise<>(this);
        addListener(f -> {
            if (f.isSuccess()) {
                try {
                    this.results.set(f.getNow());
                    R res = function.apply(this.results, (V) f.getNow());
                    promise.trySuccess(res);
                } catch (Exception e) {
                    promise.tryFailure(e);
                }
            } else if (f.isCancelled()) {
                promise.cancel(true);
            } else {
                promise.tryFailure(f.cause());
            }
        });
        promise.addListener(f -> {
            if (f.isCancelled()) {
                this.cancel(true);
            }
        });
        return promise;
    }

    @Override
    public <R> XFuture<R> xAsync(XFunction<V, Future<R>> function) {
        XPromise<R> promise = new XPromise<>(this);
        addListener(f -> {
            if (f.isSuccess()) {
                try {
                    this.results.set(f.getNow());
                    Future<R> future = function.apply(this.results, (V) f.getNow());
                    future.addListener(f0 -> {
                        if (f0.isSuccess()) {
                            R res = (R) f0.getNow();
                            promise.trySuccess(res);
                        } else if (f0.isCancelled()) {
                            promise.cancel(true);
                        } else {
                            promise.tryFailure(f0.cause());
                        }
                    });
                    promise.addListener(f1 -> {
                        if (f1.isCancelled()) {
                            future.cancel(true);
                        }
                    });
                } catch (Exception e) {
                    promise.tryFailure(e);
                }
            } else if (f.isCancelled()) {
                promise.cancel(true);
            } else {
                promise.tryFailure(f.cause());
            }
        });
        promise.addListener(f -> {
            if (f.isCancelled()) {
                this.cancel(true);
            }
        });
        return promise;
    }

    public static <T> XFuture<T> wrap(Future<T> future) {
        EventExecutor executor;
        if (future instanceof DefaultPromise) {
            try {
                executor = (EventExecutor) PROMISE_EXECUTOR.invoke(future);
            } catch (Exception e) {
                throw new RuntimeException("获取EventExecutor失败", e);
            }
        } else {
            executor = GlobalEventExecutor.INSTANCE;
        }
        XPromise<T> promise = new XPromise<>(executor);
        future.addListener(f -> {
            if (f.isSuccess()) {
                T res = (T) f.getNow();
                promise.trySuccess(res);
            } else if (f.isCancelled()) {
                promise.cancel(true);
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
    }
}
