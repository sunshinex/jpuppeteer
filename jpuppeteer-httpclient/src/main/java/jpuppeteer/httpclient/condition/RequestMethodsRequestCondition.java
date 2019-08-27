package jpuppeteer.httpclient.condition;

import jpuppeteer.httpclient.constant.RequestMethod;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.*;

public final class RequestMethodsRequestCondition extends AbstractRequestCondition<RequestMethodsRequestCondition> {

    private static final RequestMethodsRequestCondition GET_CONDITION =
            new RequestMethodsRequestCondition(RequestMethod.GET);

    private final Set<RequestMethod> methods;

    public RequestMethodsRequestCondition(RequestMethod... requestMethods) {
        this(Arrays.asList(requestMethods));
    }

    private RequestMethodsRequestCondition(Collection<RequestMethod> requestMethods) {
        this.methods = Collections.unmodifiableSet(new LinkedHashSet<>(requestMethods));
    }

    public Set<RequestMethod> getMethods() {
        return this.methods;
    }

    @Override
    protected Collection<RequestMethod> getContent() {
        return this.methods;
    }

    @Override
    protected String getToStringInfix() {
        return " || ";
    }

    @Override
    public RequestMethodsRequestCondition combine(RequestMethodsRequestCondition other) {
        Set<RequestMethod> set = new LinkedHashSet<>(this.methods);
        set.addAll(other.methods);
        return new RequestMethodsRequestCondition(set);
    }

    @Override
    public RequestMethodsRequestCondition getMatchingCondition(HttpUriRequest request) {
        RequestMethod requestMethod = RequestMethod.valueOf(request.getMethod());
        if (requestMethod != null) {
            for (RequestMethod method : getMethods()) {
                if (method.equals(requestMethod)) {
                    return new RequestMethodsRequestCondition(method);
                }
            }
            if (RequestMethod.HEAD.equals(requestMethod) && getMethods().contains(RequestMethod.GET)) {
                return GET_CONDITION;
            }
        }
        return null;
    }

    @Override
    public int compareTo(RequestMethodsRequestCondition other, HttpUriRequest request) {
        if (other.methods.size() != this.methods.size()) {
            return other.methods.size() - this.methods.size();
        }
        else if (this.methods.size() == 1) {
            if (this.methods.contains(RequestMethod.HEAD) && other.methods.contains(RequestMethod.GET)) {
                return -1;
            }
            else if (this.methods.contains(RequestMethod.GET) && other.methods.contains(RequestMethod.HEAD)) {
                return 1;
            }
        }
        return 0;
    }

}
