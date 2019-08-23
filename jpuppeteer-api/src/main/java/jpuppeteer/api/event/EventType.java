package jpuppeteer.api.event;

public interface EventType<E> {

    /**
     * 事件类型的名称
     * @return
     */
    String eventName();

    /**
     * 事件的实体类
     * @return
     */
    Class<E> eventClass();

}
