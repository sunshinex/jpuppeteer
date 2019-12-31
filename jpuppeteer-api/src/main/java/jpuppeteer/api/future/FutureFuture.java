package jpuppeteer.api.future;

import java.util.concurrent.*;
import java.util.function.Function;

public class FutureFuture<O, V> implements Future<V> {

    private Future<O> future;

    private Function<O, V> function;

    public FutureFuture(Future<O> future, Function<O, V> function) {
        this.future = future;
        this.function = function;
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
        return function.apply(future.get());
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return function.apply(future.get(timeout, unit));
    }
}
