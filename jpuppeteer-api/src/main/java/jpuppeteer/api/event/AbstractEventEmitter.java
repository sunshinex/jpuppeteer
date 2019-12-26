package jpuppeteer.api.event;

import jpuppeteer.api.util.ConcurrentHashSet;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public abstract class AbstractEventEmitter<E extends Enum<E>> implements EventEmitter<E> {

    protected final Map<Enum<E>, Set<Consumer>> listenerMap;

    protected AbstractEventEmitter() {
        this.listenerMap = new ConcurrentHashMap<>();
    }

    @Override
    public void addListener(E type, Consumer<?> consumer) {
        Set<Consumer> consumers = new ConcurrentHashSet<>();
        consumers.add(consumer);
        if (listenerMap.putIfAbsent(type, consumers) != null) {
            listenerMap.get(type).add(consumer);
        }
    }

    @Override
    public void removeListener(E type, Consumer<?> consumer) {
        Set<Consumer> consumers = listenerMap.get(type);
        if (consumers == null || consumers.size() == 0) {
            return;
        }
        consumers.remove(consumer);
    }

    @Override
    public void emit(E type, Object event) {
        Set<Consumer> consumers = listenerMap.get(type);
        if (consumers == null || consumers.size() == 0) {
            return;
        }
        consumers.iterator().forEachRemaining(consumer -> emitInternal(consumer, event));
    }

    protected abstract void emitInternal(Consumer<Object> consumer, Object event);
}
