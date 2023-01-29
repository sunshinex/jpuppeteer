package jpuppeteer.api.event;

import jpuppeteer.api.event.page.LoadedEvent;
import jpuppeteer.api.event.page.PageEvent;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public abstract class AbstractEventEmitter<E> implements EventEmitter<E> {

    private final Map<Long, AbstractListener<E>> listeners;

    public AbstractEventEmitter() {
        this.listeners = new ConcurrentHashMap<>();
    }

    protected abstract void emitInternal(AbstractListener<E> listener, E event);

    protected void emit(E event) {
        Set<Long> keys = listeners.keySet();
        for(Long key : keys) {
            AbstractListener<E> listener = listeners.get(key);
            if (listener == null) {
                //如果取不到, 就是这个监听器被remove了
                continue;
            }
            Class<? extends E> typeClass = listener.type();
            Class<E> eventClass = (Class<E>) event.getClass();
            if (typeClass.isAssignableFrom(eventClass)) {
                //如果没有限定类型，或者限定的类型范围包含事件的实际类型才对这个监听器触发这个事件
                if (listener.once()) {
                    //如果这个监听器是单次的, 则删除掉
                    removeListener(listener);
                    //如果这个监听器是单次的, 而且已经触发过, 不能再次触发
                    if (listener.emitAndCount() > 0) {
                        return;
                    }
                } else {
                    listener.emitAndCount();
                }
                emitInternal(listener, event);
            }
        }
    }

    @Override
    public void addListener(AbstractListener<? extends E> listener) {
        listeners.put(listener.id(), (AbstractListener<E>) listener);
    }

    @Override
    public void removeListener(AbstractListener<? extends E> listener) {
        listeners.remove(listener.id());
    }

    public static void main(String[] args) throws Exception {
        AbstractEventEmitter<PageEvent> eventEmitter = new AbstractEventEmitter<PageEvent>() {
            @Override
            protected void emitInternal(AbstractListener<PageEvent> listener, PageEvent event) {
                listener.accept(event);
            }
        };

        eventEmitter.addListener(new AbstractListener<LoadedEvent>(true) {
            @Override
            public void accept(LoadedEvent event) {
                System.out.println(event.timestamp());
            }
        });

        new Thread() {
            @Override
            public void run() {
                LoadedEvent event = new LoadedEvent(BigDecimal.ZERO);
                eventEmitter.emit(event);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                LoadedEvent event = new LoadedEvent(BigDecimal.ONE);
                eventEmitter.emit(event);
            }
        }.start();

        TimeUnit.SECONDS.sleep(5);
    }
}
