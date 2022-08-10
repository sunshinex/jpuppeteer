package jpuppeteer.util;

import io.netty.util.concurrent.Future;

import java.util.function.Function;

public interface XFuture<T> extends Future<T> {

    <R> XFuture<R> sync(Function<T, R> function);

    <R> XFuture<R> async(Function<T, Future<R>> function);

    <R> XFuture<R> xSync(XFunction<T, R> function);

    <R> XFuture<R> xAsync(XFunction<T, Future<R>> function);

}
