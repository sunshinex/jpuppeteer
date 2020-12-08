package jpuppeteer.util;

import io.netty.util.concurrent.*;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;

@SuppressWarnings({"rawtypes","unchecked"})
public class SeriesFuture<V> extends FutureWrapper<V, SeriesFuture<V>> {

    private static final AtomicReferenceFieldUpdater<SeriesFuture, Function> NEXT_FUNCTION_UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(SeriesFuture.class, Function.class, "nextFunction");

    private static final Method PROMISE_EXECUTOR;

    static {
        try {
            PROMISE_EXECUTOR = DefaultPromise.class.getDeclaredMethod("executor");
            PROMISE_EXECUTOR.setAccessible(true);
        } catch (Throwable cause) {
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private final EventExecutor executor;

    private final Future<V> future;

    private volatile Function<V, Object> nextFunction;

    private SeriesFuture(EventExecutor executor, Future<V> future) {
        super(future);
        this.executor = executor;
        this.future = future;
    }

    private SeriesFuture(Future<V> future) {
        super(future);
        if (future instanceof DefaultPromise) {
            try {
                this.executor = (EventExecutor) PROMISE_EXECUTOR.invoke(future);
            } catch (Throwable cause) {
                throw new RuntimeException(cause.getMessage(), cause);
            }
        } else if (future instanceof SeriesFuture) {
            this.executor = ((SeriesFuture<Object>) future).executor;
        } else {
            this.executor = GlobalEventExecutor.INSTANCE;
        }
        this.future = future;
    }

    public static <V> SeriesFuture<V> wrap(Future<V> future) {
        return new SeriesFuture<>(future);
    }

    @Override
    protected SeriesFuture<V> self() {
        return this;
    }

    private void initFunction(Function function) {
        if (!NEXT_FUNCTION_UPDATER.compareAndSet(this, null, function)) {
            throw new IllegalStateException("Failed to bind function because it is bind already");
        }
    }

    public <R> SeriesFuture<R> async(Function<V, Future<R>> function) {
        initFunction(function);
        Promise<R> p = executor.newPromise();
        SeriesFuture<R> seriesFuture = new SeriesFuture<>(executor, p);
        future.addListener(f -> {
            if (f.cause() != null) {
                p.tryFailure(f.cause());
            } else {
                try {
                    function.apply((V) f.getNow())
                            .addListener(f0 -> {
                                if (f0.cause() != null) {
                                    p.tryFailure(f0.cause());
                                } else {
                                    p.trySuccess((R) f0.getNow());
                                }
                            });
                } catch (Throwable cause) {
                    p.tryFailure(cause);
                }
            }

        });
        return seriesFuture;
    }

    public <R> SeriesFuture<R> sync(Function<V, R> function) {
        initFunction(function);
        Promise<R> p = executor.newPromise();
        SeriesFuture<R> seriesFuture = new SeriesFuture<>(executor, p);
        future.addListener(f -> {
            if (f.cause() != null) {
                p.tryFailure(f.cause());
            } else {
                try {
                    R r = function.apply((V) f.getNow());
                    p.trySuccess(r);
                } catch (Throwable cause) {
                    p.tryFailure(cause);
                }
            }

        });
        return seriesFuture;
    }
}
