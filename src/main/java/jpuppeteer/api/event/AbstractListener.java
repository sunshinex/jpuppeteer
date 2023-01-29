package jpuppeteer.api.event;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public abstract class AbstractListener<E> implements Consumer<E> {

    private static final AtomicLong COUNTER = new AtomicLong(0);

    private final long id;

    private final Class<E> type;

    private final boolean once;

    private final AtomicLong emitCount;

    protected AbstractListener(boolean once, Class<E> clazz) {
        this.id = COUNTER.getAndIncrement();
        this.type = clazz;
        this.once = once;
        this.emitCount = new AtomicLong(0);
    }

    @SuppressWarnings("unchecked")
    protected AbstractListener(boolean once) {
        this.id = COUNTER.getAndIncrement();
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type eType = parameterizedType.getActualTypeArguments()[0];
        if (eType instanceof ParameterizedType) {
            this.type = (Class<E>) ((ParameterizedType) eType).getRawType();
        } else if (eType instanceof Class) {
            this.type = (Class<E>) eType;
        } else {
            throw new RuntimeException("unknown actual type:" + eType.getTypeName());
        }
        this.once = once;
        this.emitCount = new AtomicLong(0);
    }

    protected AbstractListener() {
        this(false);
    }

    public final Class<E> type() {
        return type;
    }

    public final long id() {
        return id;
    }

    public final boolean once() {
        return once;
    }

    protected final long emitAndCount() {
        return emitCount.getAndIncrement();
    }

}
