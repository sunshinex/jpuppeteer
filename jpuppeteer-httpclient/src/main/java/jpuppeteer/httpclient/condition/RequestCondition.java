package jpuppeteer.httpclient.condition;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

public interface RequestCondition<T> {

    T combine(T other);

    T getMatchingCondition(HttpRequestInfo request);

    int compareTo(T other, HttpRequestInfo request);

}
