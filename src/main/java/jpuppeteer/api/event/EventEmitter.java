package jpuppeteer.api.event;

import com.google.common.util.concurrent.SettableFuture;

import java.util.concurrent.Future;

public interface EventEmitter<E> {

    void addListener(AbstractListener<? extends E> listener);

    void removeListener(AbstractListener<? extends E> listener);

    default <R extends E> Future<R> once(Class<R> clazz) {
        SettableFuture<R> future = SettableFuture.create();
        AbstractListener<R> listener = new AbstractListener<R>(true, clazz) {
            @Override
            public void accept(R e) {
                future.set(e);
            }
        };
        addListener(listener);
        return future;
    }

}
