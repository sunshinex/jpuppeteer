package jpuppeteer.httpclient.condition;

public interface RequestCondition<T> extends Comparable<T> {

    boolean match(HttpRequestInfo request);

}
