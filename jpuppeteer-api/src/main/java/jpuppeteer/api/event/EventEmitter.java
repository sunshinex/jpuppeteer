package jpuppeteer.api.event;

import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface EventEmitter {

    <E> void addListener(EventType<E> eventType, Consumer<E> consumer);

    <E> void removeListener(EventType<E> eventType, Consumer<E> consumer);

    <E> Future<E> await(EventType<E> eventType);

    <E> Future<E> await(EventType<E> eventType, Predicate<E> predicate);

    <E> void emit(EventType<E> eventType, E event);

}