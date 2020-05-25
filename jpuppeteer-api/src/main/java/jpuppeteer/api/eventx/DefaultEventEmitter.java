package jpuppeteer.api.eventx;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class DefaultEventEmitter<E extends Enum<E>> extends AbstractEventEmitter<E> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultEventEmitter.class);

    private final ExecutorService executor;

    public DefaultEventEmitter(ExecutorService executor) {
        super();
        this.executor = executor;
    }

    @Override
    protected void emitInternal(Consumer<Object> consumer, Object event) {
        executor.execute(new EventTask(consumer, event));
    }

    public void close() throws Exception {
        executor.shutdown();
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
                consumer.accept(event);
            } catch (Exception e) {
                logger.error("publish event error, event={}, error={}", JSON.toJSONString(event), e.getMessage(), e);
            }
        }
    }
}
