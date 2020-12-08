package jpuppeteer.util;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class BatchFuture<V> implements Future<V[]> {

    private final Promise<V[]> promise;

    private volatile V[] values;

    private BatchFuture(EventExecutor executor, Future<V>[] futures) {
        this.promise = executor.newPromise();
        int i = 0;
        int total = futures.length;
        AtomicInteger countDown = new AtomicInteger(total);
        for(Future<V> future : futures) {
            final int vi = i;
            future.addListener(f -> {
                if (f.cause() != null) {
                    promise.tryFailure(f.cause());
                    for(Future<V> fu : futures) {
                        if (!fu.isDone() && !fu.isCancelled()) {
                            fu.cancel(true);
                        }
                    }
                } else {
                    if (this.values == null) {
                        synchronized (this) {
                            if (this.values == null) {
                                this.values = (V[]) Array.newInstance(f.getNow().getClass(), total);
                            }
                        }
                    }
                    this.values[vi] = (V) f.getNow();
                    if (countDown.decrementAndGet() == 0) {
                        promise.trySuccess(this.values);
                    }
                }
            });
            i++;
        }
    }

    public static <V> BatchFuture<V> wrap(EventExecutor executor, Future<V>... futures) {
        return new BatchFuture<>(executor, futures);
    }

    public static <V> BatchFuture<V> wrap(EventExecutor executor, Iterable<Future<V>> futures) {
        List<Future<V>> futureList = Lists.newArrayList(futures);
        Future<V>[] futureArray = new Future[futureList.size()];
        futureList.toArray(futureArray);
        return new BatchFuture<>(executor, futureArray);
    }

    @Override
    public BatchFuture<V> addListener(GenericFutureListener<? extends Future<? super V[]>> listener) {
        promise.addListener(listener);
        return this;
    }

    @Override
    public BatchFuture<V> addListeners(GenericFutureListener<? extends Future<? super V[]>>... listeners) {
        promise.addListeners(listeners);
        return this;
    }

    @Override
    public BatchFuture<V> removeListener(GenericFutureListener<? extends Future<? super V[]>> listener) {
        promise.removeListener(listener);
        return this;
    }

    @Override
    public BatchFuture<V> removeListeners(GenericFutureListener<? extends Future<? super V[]>>... listeners) {
        promise.removeListeners(listeners);
        return this;
    }

    @Override
    public BatchFuture<V> sync() throws InterruptedException {
        promise.sync();
        return this;
    }

    @Override
    public BatchFuture<V> syncUninterruptibly() {
        promise.syncUninterruptibly();
        return this;
    }

    @Override
    public BatchFuture<V> await() throws InterruptedException {
        promise.await();
        return this;
    }

    @Override
    public BatchFuture<V> awaitUninterruptibly() {
        promise.awaitUninterruptibly();
        return this;
    }

    @Override
    public boolean isSuccess() {
        return promise.isSuccess();
    }

    @Override
    public boolean isCancellable() {
        return promise.isCancellable();
    }

    @Override
    public Throwable cause() {
        return promise.cause();
    }

    @Override
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        return promise.await(timeout, unit);
    }

    @Override
    public boolean await(long timeoutMillis) throws InterruptedException {
        return promise.await(timeoutMillis);
    }

    @Override
    public boolean awaitUninterruptibly(long timeout, TimeUnit unit) {
        return promise.awaitUninterruptibly(timeout, unit);
    }

    @Override
    public boolean awaitUninterruptibly(long timeoutMillis) {
        return promise.awaitUninterruptibly(timeoutMillis);
    }

    @Override
    public V[] getNow() {
        return promise.getNow();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return promise.cancel(mayInterruptIfRunning);
    }

    @Override
    public boolean isCancelled() {
        return promise.isCancelled();
    }

    @Override
    public boolean isDone() {
        return promise.isDone();
    }

    @Override
    public V[] get() throws InterruptedException, ExecutionException {
        return promise.get();
    }

    @Override
    public V[] get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return promise.get(timeout, unit);
    }
}
