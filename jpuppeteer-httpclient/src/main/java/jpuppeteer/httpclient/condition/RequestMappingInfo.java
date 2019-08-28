package jpuppeteer.httpclient.condition;

public class RequestMappingInfo implements RequestCondition<RequestMappingInfo> {

    private final MethodsRequestCondition methodsCondition;

    private final PathsRequestCondition pathsCondition;

    private final ParamsRequestCondition paramsCondition;

    public RequestMappingInfo(MethodsRequestCondition methodsCondition, PathsRequestCondition pathsCondition, ParamsRequestCondition paramsCondition) {
        this.methodsCondition = methodsCondition;
        this.pathsCondition = pathsCondition;
        this.paramsCondition = paramsCondition;
    }

    public MethodsRequestCondition getMethodsCondition() {
        return methodsCondition;
    }

    public PathsRequestCondition getPathsCondition() {
        return pathsCondition;
    }

    public ParamsRequestCondition getParamsCondition() {
        return paramsCondition;
    }

    @Override
    public boolean match(HttpRequestInfo request) {
        if (!methodsCondition.match(request)) {
            return false;
        }
        if (!pathsCondition.match(request)) {
            return false;
        }
        if (!paramsCondition.match(request)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(RequestMappingInfo other) {
        int result = methodsCondition.compareTo(other.methodsCondition);
        if (result != 0) {
            return result;
        }
        result = pathsCondition.compareTo(other.pathsCondition);
        if (result != 0) {
            return result;
        }
        return paramsCondition.compareTo(other.paramsCondition);
    }
}
