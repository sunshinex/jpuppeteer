package jpuppeteer.api.event;

import com.alibaba.fastjson.JSON;
import jpuppeteer.api.util.ConcurrentHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public abstract class AbstractEventEmitter<E extends Enum<E>> implements EventEmitter<E> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractEventEmitter.class);

    private static final AtomicInteger threadCounter = new AtomicInteger(0);

    protected static final ThreadFactory THREAD_FACTORY = r -> new Thread(r, "EventExecutor-" + threadCounter.getAndIncrement());

    private static final Executor EXECUTOR = Executors.newSingleThreadExecutor(THREAD_FACTORY);

    private final Executor executor;

    private final Map<Enum<E>, Set<Consumer>> listenerMap;

    public AbstractEventEmitter() {
        this(EXECUTOR);
    }

    public AbstractEventEmitter(Executor executor) {
        this.executor = executor;
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
        consumers.iterator().forEachRemaining(consumer -> executor.execute(new EventTask(consumer, event)));
    }

    static class EventTask implements Runnable {

        private Consumer consumer;

        private Object event;

        EventTask(Consumer consumer, Object event) {
            this.consumer = consumer;
            this.event = event;
        }

        @Override
        public void run() {
            try {
                if (logger.isDebugEnabled()) {
                    logger.debug("publish event start, hanler={}, event={}", consumer.getClass().getName(), JSON.toJSONString(event));
                }
                consumer.accept(event);
            } catch (Exception e) {
                logger.error("publish event error, event={}, error={}", JSON.toJSONString(event), e.getMessage(), e);
            }
        }
    }
}
