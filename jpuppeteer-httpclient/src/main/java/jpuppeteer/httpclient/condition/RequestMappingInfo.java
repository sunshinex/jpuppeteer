package jpuppeteer.httpclient.condition;

import org.apache.http.client.methods.HttpUriRequest;

public class RequestMappingInfo implements RequestCondition<RequestMappingInfo> {

    private final MethodsRequestCondition methodsCondition;

    private final ParamsRequestCondition paramsCondition;

    public RequestMappingInfo(MethodsRequestCondition methodsCondition, ParamsRequestCondition paramsCondition) {
        this.methodsCondition = methodsCondition;
        this.paramsCondition = paramsCondition;
    }

    public MethodsRequestCondition getMethodsCondition() {
        return methodsCondition;
    }

    public ParamsRequestCondition getParamsCondition() {
        return paramsCondition;
    }

    @Override
    public RequestMappingInfo combine(RequestMappingInfo other) {
        MethodsRequestCondition methods = methodsCondition.combine(other.methodsCondition);
        ParamsRequestCondition params = paramsCondition.combine(other.paramsCondition);
        return new RequestMappingInfo(methods, params);
    }

    @Override
    public RequestMappingInfo getMatchingCondition(HttpRequestInfo request) {
        MethodsRequestCondition methods = methodsCondition.getMatchingCondition(request);
        if (methods == null) {
            return null;
        }
        ParamsRequestCondition params = paramsCondition.getMatchingCondition(request);
        if (params == null) {
            return null;
        }
        return new RequestMappingInfo(methods, params);
    }

    @Override
    public int compareTo(RequestMappingInfo other, HttpRequestInfo request) {
        int methodCompareResult = methodsCondition.compareTo(other.methodsCondition, request);
        if (methodCompareResult != 0) {
            return methodCompareResult;
        }
        return paramsCondition.compareTo(other.paramsCondition, request);
    }
}
