package jpuppeteer.api.event;

public interface EventEmitter<E> {

    void addListener(AbstractListener<? extends E> listener);

    void removeListener(AbstractListener<? extends E> listener);

}
