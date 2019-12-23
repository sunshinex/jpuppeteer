package jpuppeteer.api.event;

import java.util.function.Consumer;

public interface EventEmitter<E extends Enum<E>> {

    void addListener(E type, Consumer<?> consumer);

    void removeListener(E type, Consumer<?> consumer);

    void emit(E type, Object event);

}