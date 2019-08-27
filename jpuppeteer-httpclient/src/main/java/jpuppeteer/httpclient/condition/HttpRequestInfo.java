package jpuppeteer.httpclient.condition;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import jpuppeteer.httpclient.constant.Constants;
import jpuppeteer.httpclient.constant.RequestMethod;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HttpRequestInfo {

    private final HttpUriRequest request;

    private final RequestMethod method;

    private final Multimap<String, String> query;

    public HttpRequestInfo(HttpUriRequest request) {
        this.request = request;
        this.method = RequestMethod.valueOf(request.getMethod().toUpperCase());
        Multimap<String, String> multimap = LinkedHashMultimap.create();
        List<NameValuePair> kvs = URLEncodedUtils.parse(request.getURI(), StandardCharsets.UTF_8);
        for(NameValuePair kv : kvs) {
            multimap.put(kv.getName(), kv.getValue() != null ? kv.getValue() : Constants.EMPTY_STRING);
        }
        this.query = ImmutableSetMultimap.copyOf(multimap);
    }

    public RequestMethod getMethod() {
        return method;
    }

    public Multimap<String, String> getQuery() {
        return query;
    }
}
