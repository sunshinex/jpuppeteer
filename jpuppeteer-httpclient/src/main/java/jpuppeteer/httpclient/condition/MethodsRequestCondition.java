package jpuppeteer.httpclient.condition;

import com.google.common.collect.ImmutableSet;
import jpuppeteer.httpclient.constant.RequestMethod;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.*;

public final class MethodsRequestCondition extends AbstractRequestCondition<MethodsRequestCondition> {

    private final Set<RequestMethod> methods;

    public MethodsRequestCondition(RequestMethod... requestMethods) {
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
    public boolean match(HttpRequestInfo request) {
        RequestMethod requestMethod = request.getMethod();
        if (requestMethod != null) {
            for (RequestMethod method : getMethods()) {
                if (method.equals(requestMethod)) {
                    return true;
                }
            }
            if (RequestMethod.HEAD.equals(requestMethod) && getMethods().contains(RequestMethod.GET)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(MethodsRequestCondition other) {
        return this.methods.size() - other.methods.size();
    }

}
