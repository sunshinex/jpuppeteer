package jpuppeteer.util;

import io.netty.util.concurrent.*;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;

public class SeriesFuture<V> implements Future<V> {

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
        this.executor = executor;
        this.future = future;
    }

    private SeriesFuture(Future<V> future) {
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
        return new SeriesFuture<V>(future);
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

    @Override
    public SeriesFuture<V> addListener(GenericFutureListener<? extends Future<? super V>> listener) {
        future.addListener(listener);
        return this;
    }

    @Override
    public SeriesFuture<V> addListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        future.addListeners(listeners);
        return this;
    }

    @Override
    public SeriesFuture<V> removeListener(GenericFutureListener<? extends Future<? super V>> listener) {
        future.removeListener(listener);
        return this;
    }

    @Override
    public SeriesFuture<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        future.removeListeners(listeners);
        return this;
    }

    @Override
    public SeriesFuture<V> sync() throws InterruptedException {
        future.sync();
        return this;
    }

    @Override
    public SeriesFuture<V> syncUninterruptibly() {
        future.syncUninterruptibly();
        return this;
    }

    @Override
    public SeriesFuture<V> await() throws InterruptedException {
        future.await();
        return this;
    }

    @Override
    public SeriesFuture<V> awaitUninterruptibly() {
        future.awaitUninterruptibly();
        return this;
    }

    @Override
    public boolean isSuccess() {
        return future.isSuccess();
    }

    @Override
    public boolean isCancellable() {
        return future.isCancellable();
    }

    @Override
    public Throwable cause() {
        return future.cause();
    }

    @Override
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        return future.await(timeout, unit);
    }

    @Override
    public boolean await(long timeoutMillis) throws InterruptedException {
        return future.await(timeoutMillis);
    }

    @Override
    public boolean awaitUninterruptibly(long timeout, TimeUnit unit) {
        return future.awaitUninterruptibly(timeout, unit);
    }

    @Override
    public boolean awaitUninterruptibly(long timeoutMillis) {
        return future.awaitUninterruptibly(timeoutMillis);
    }

    @Override
    public V getNow() {
        return future.getNow();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return future.cancel(mayInterruptIfRunning);
    }

    @Override
    public boolean isCancelled() {
        return future.isCancelled();
    }

    @Override
    public boolean isDone() {
        return future.isDone();
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        return future.get();
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return future.get(timeout, unit);
    }
}
