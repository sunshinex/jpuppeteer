package jpuppeteer.api.event;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface EventEmitter {

    <E> void addListener(EventType<E> eventType, Consumer<E> consumer);

    <E> void removeListener(EventType<E> eventType, Consumer<E> consumer);

    <E> E wait(EventType<E> eventType, int timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

    <E> E wait(EventType<E> eventType, Predicate<E> predicate, int timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;

    default <E> E wait(EventType<E> eventType) throws InterruptedException, ExecutionException, TimeoutException {
        return wait(eventType, 0, null);
    }

    <E> void emit(EventType<E> eventType, E event);

}