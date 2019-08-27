package jpuppeteer.httpclient.condition;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

public interface RequestCondition<T> {

    T combine(T other);

    T getMatchingCondition(HttpUriRequest request);

    int compareTo(T other, HttpUriRequest request);

}
