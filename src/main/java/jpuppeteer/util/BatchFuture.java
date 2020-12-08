package jpuppeteer.util;

import com.google.common.collect.Lists;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"unchecked"})
public class BatchFuture<V> extends FutureWrapper<V[], BatchFuture<V>> {

    private volatile V[] values;

    private BatchFuture(Promise<V[]> promise, Future<V>[] futures) {
        super(promise);
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

    @Override
    protected BatchFuture<V> self() {
        return this;
    }

    public static <V> BatchFuture<V> wrap(EventExecutor executor, Future<V>... futures) {
        Promise<V[]> promise = executor.newPromise();
        return new BatchFuture<>(promise, futures);
    }

    public static <V> BatchFuture<V> wrap(EventExecutor executor, Iterable<Future<V>> futures) {
        List<Future<V>> futureList = Lists.newArrayList(futures);
        Future<V>[] futureArray = new Future[futureList.size()];
        futureList.toArray(futureArray);
        Promise<V[]> promise = executor.newPromise();
        return new BatchFuture<>(promise, futureArray);
    }
}
