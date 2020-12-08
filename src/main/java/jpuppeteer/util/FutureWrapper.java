package jpuppeteer.util;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class FutureWrapper<V, T extends FutureWrapper<V, T>> implements Future<V> {

    private final Future<V> future;

    protected FutureWrapper(Future<V> future) {
        this.future = future;
    }

    abstract protected T self();

    @Override
    public T addListener(GenericFutureListener<? extends Future<? super V>> listener) {
        future.addListener(listener);
        return self();
    }

    @Override
    public T addListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        future.addListeners(listeners);
        return self();
    }

    @Override
    public T removeListener(GenericFutureListener<? extends Future<? super V>> listener) {
        future.removeListener(listener);
        return self();
    }

    @Override
    public T removeListeners(GenericFutureListener<? extends Future<? super V>>... listeners) {
        future.removeListeners(listeners);
        return self();
    }

    @Override
    public T sync() throws InterruptedException {
        future.sync();
        return self();
    }

    @Override
    public T syncUninterruptibly() {
        future.syncUninterruptibly();
        return self();
    }

    @Override
    public T await() throws InterruptedException {
        future.await();
        return self();
    }

    @Override
    public T awaitUninterruptibly() {
        future.awaitUninterruptibly();
        return self();
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
    public V get() throws InterruptedException, java.util.concurrent.ExecutionException {
        return future.get();
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return future.get(timeout, unit);
    }

}
