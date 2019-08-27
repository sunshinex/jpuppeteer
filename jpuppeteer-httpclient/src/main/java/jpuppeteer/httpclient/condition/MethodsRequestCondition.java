package jpuppeteer.httpclient.condition;

import com.google.common.collect.ImmutableSet;
import jpuppeteer.httpclient.constant.RequestMethod;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.*;

public final class MethodsRequestCondition extends AbstractRequestCondition<MethodsRequestCondition> {

    private static final MethodsRequestCondition GET_CONDITION =
            new MethodsRequestCondition(RequestMethod.GET);

    private final Set<RequestMethod> methods;

    public MethodsRequestCondition(RequestMethod... requestMethods) {
        this(Arrays.asList(requestMethods));
    }

    private MethodsRequestCondition(Collection<RequestMethod> requestMethods) {
        this.methods = ImmutableSet.copyOf(requestMethods);
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
    public MethodsRequestCondition combine(MethodsRequestCondition other) {
        Set<RequestMethod> set = new LinkedHashSet<>(this.methods);
        set.addAll(other.methods);
        return new MethodsRequestCondition(set);
    }

    @Override
    public MethodsRequestCondition getMatchingCondition(HttpRequestInfo request) {
        RequestMethod requestMethod = request.getMethod();
        if (requestMethod != null) {
            for (RequestMethod method : getMethods()) {
                if (method.equals(requestMethod)) {
                    return new MethodsRequestCondition(method);
                }
            }
            if (RequestMethod.HEAD.equals(requestMethod) && getMethods().contains(RequestMethod.GET)) {
                return GET_CONDITION;
            }
        }
        return null;
    }

    @Override
    public int compareTo(MethodsRequestCondition other, HttpRequestInfo request) {
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
