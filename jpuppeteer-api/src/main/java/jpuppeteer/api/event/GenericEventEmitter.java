package jpuppeteer.api.event;

import com.alibaba.fastjson.JSON;
import jpuppeteer.api.future.DefaultPromise;
import jpuppeteer.api.future.Promise;
import jpuppeteer.api.util.ConcurrentHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class GenericEventEmitter implements EventEmitter {

    private static final Logger logger = LoggerFactory.getLogger(GenericEventEmitter.class);

    protected static final ThreadFactory THREAD_FACTORY = new GenericThreadFactory();

    /**
     * 默认的事件触发为单线程, 保证事件顺序处理
     */
    private static final Executor EXECUTOR = Executors.newSingleThreadExecutor(THREAD_FACTORY);

    private final Executor executor;

    private volatile Map<String, Set<Consumer<?>>> listenerMap;

    public GenericEventEmitter() {
        this(EXECUTOR);
    }

    public GenericEventEmitter(Executor executor) {
        this.executor = executor;
        this.listenerMap = new ConcurrentHashMap<>();
    }

    @Override
    public <E> void addListener(EventType<E> eventType, Consumer<E> consumer) {
        String eventName = eventType.eventName();
        Set<Consumer<?>> consumers = new ConcurrentHashSet<>();
        if (!listenerMap.containsKey(eventName)) {
            consumers.add(consumer);
            if (listenerMap.putIfAbsent(eventName, consumers) == null) {
                //如果写入set失败, 则使用add
                listenerMap.get(eventName).add(consumer);
            }
        } else {
            listenerMap.get(eventName).add(consumer);
        }
    }

    @Override
    public <E> void removeListener(EventType<E> eventType, Consumer<E> consumer) {
        //TODO 后续需要处理remove时候的并发问题
        String eventName = eventType.eventName();
        if (listenerMap.containsKey(eventName)) {
            listenerMap.get(eventName).remove(consumer);
        }
    }

    private <E> Future<E> await0(EventType<E> eventType, Predicate<E> predicate) {
        DefaultPromise<E> promise = new DefaultPromise<>();
        final Consumer<E> consumer = new Consumer<E>() {
            @Override
            public void accept(E e) {
                if (!predicate.test(e)) {
                    return;
                }
                promise.setSuccess(e);
                removeListener(eventType, this);
            }
        };
        addListener(eventType, consumer);
        return promise;
    }

    @Override
    public <E> Future<E> await(EventType<E> eventType) {
        return await0(eventType, e -> true);
    }

    @Override
    public <E> Future<E> await(EventType<E> eventType, Predicate<E> predicate) {
        return await(eventType, predicate);
    }

    @Override
    public <E> void emit(EventType<E> eventType, E event) {
        String eventName = eventType.eventName();
        if (!listenerMap.containsKey(eventName)) {
            return;
        }
        listenerMap.get(eventName)
                .iterator()
                .forEachRemaining(handler -> executor.execute(new EventTask(handler, event)));
    }

    static class EventTask<E> implements Runnable {

        private Consumer<E> consumer;

        private E event;

        EventTask(Consumer consumer, E event) {
            this.consumer = consumer;
            this.event = event;
        }

        @Override
        public void run() {
            try {
                logger.debug("publish event start, hanler={}, event={}", consumer.getClass().getName(), JSON.toJSONString(event));
                consumer.accept(event);
            } catch (Exception e) {
                logger.error("publish event error, event={}, error={}", JSON.toJSONString(event), e.getMessage(), e);
            }
        }
    }

    static class GenericThreadFactory implements ThreadFactory {

        private static final AtomicInteger threadCounter = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "EventExecutor-" + threadCounter.getAndIncrement());
        }
    }
}
