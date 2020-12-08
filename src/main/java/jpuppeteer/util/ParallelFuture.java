package jpuppeteer.util;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

import java.util.concurrent.atomic.AtomicInteger;

public class ParallelFuture<T extends Tuple> extends FutureWrapper<T, ParallelFuture<T>> {

    private ParallelFuture(Promise<T> promise, Future<?>[] futures, TupleFactory<T> factory) {
        super(promise);
        AtomicInteger countDown = new AtomicInteger(futures.length);
        T tuple = factory.newTuple();
        for(int i=0; i<futures.length; i++) {
            Future<?> future = futures[i];
            int x = i;
            future.addListener(f -> {
                if (f.cause() != null) {
                    promise.tryFailure(f.cause());
                } else {
                    tuple.set(x, f.getNow());
                    if (countDown.decrementAndGet() == 0) {
                        promise.trySuccess(tuple);
                    }
                }
            });
        }
    }

    @Override
    protected ParallelFuture<T> self() {
        return this;
    }

    private static <T extends Tuple> ParallelFuture<T> wrap(
            EventExecutor executor, TupleFactory<T> factory, Future<?>... futures) {
        Promise<T> promise = executor.newPromise();
        return new ParallelFuture<>(promise, futures, factory);
    }

    public static <A> ParallelFuture<Tuple1<A>> wrap(EventExecutor executor, Future<A> f0) {
        return wrap(executor, Tuple1::new, f0);
    }

    public static <A, B> ParallelFuture<Tuple2<A, B>> wrap(
            EventExecutor executor,
            Future<A> f0, Future<B> f1) {
        return wrap(executor, Tuple2::new, f0, f1);
    }

    public static <A, B, C> ParallelFuture<Tuple3<A, B, C>> wrap(
            EventExecutor executor,
            Future<A> f0, Future<B> f1, Future<C> f2) {
        return wrap(executor, Tuple3::new, f0, f1, f2);
    }

    public static <A, B, C, D> ParallelFuture<Tuple4<A, B, C, D>> wrap(
            EventExecutor executor,
            Future<A> f0, Future<B> f1, Future<C> f2, Future<D> f3) {
        return wrap(executor, Tuple4::new, f0, f1, f2, f3);
    }

    public static <A, B, C, D, E> ParallelFuture<Tuple5<A, B, C, D, E>> wrap(
            EventExecutor executor,
            Future<A> f0, Future<B> f1, Future<C> f2, Future<D> f3, Future<E> f4) {
        return wrap(executor, Tuple5::new, f0, f1, f2, f3, f4);
    }

    public static <A, B, C, D, E, F> ParallelFuture<Tuple6<A, B, C, D, E, F>> wrap(
            EventExecutor executor,
            Future<A> f0, Future<B> f1, Future<C> f2, Future<D> f3, Future<E> f4, Future<F> f5) {
        return wrap(executor, Tuple6::new, f0, f1, f2, f3, f4, f5);
    }

    @FunctionalInterface
    private interface TupleFactory<T extends Tuple> {

        T newTuple();

    }
}
