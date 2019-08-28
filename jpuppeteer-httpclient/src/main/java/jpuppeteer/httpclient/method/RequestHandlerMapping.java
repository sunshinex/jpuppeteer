package jpuppeteer.httpclient.method;

import jpuppeteer.httpclient.annotation.Processor;
import jpuppeteer.httpclient.annotation.RequestProcessor;
import jpuppeteer.httpclient.condition.*;
import jpuppeteer.httpclient.handler.RequestMappingRegistry;
import jpuppeteer.httpclient.method.support.HandlerMethod;
import jpuppeteer.httpclient.taobao.login.TaobaoLogin;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.*;

public class RequestHandlerMapping {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandlerMapping.class);

    private final RequestMappingRegistry registry;

    public RequestHandlerMapping() {
        registry = new RequestMappingRegistry();
    }

    public void addMappingClass(Class clazz) {
        Processor processor = (Processor) clazz.getAnnotation(Processor.class);
        if (processor == null) {
            return;
        }
        String[] hosts = processor.value();
        if (hosts.length == 0) {
            return;
        }
        for(Method method : clazz.getDeclaredMethods()) {
            RequestProcessor requestProcessor = method.getAnnotation(RequestProcessor.class);
            if (requestProcessor == null) {
                continue;
            }
            addMapping(hosts, clazz, method, requestProcessor);
        }
    }

    public HandlerMethod getHandler(HttpRequestInfo request) {
        registry.acquireReadLock();
        try {
            URI uri = request.getURI();
            String urlPath = uri.getHost() + uri.getPath();
            Collection<RequestMappingInfo> mappings = registry.getMappingsByUrl(urlPath);
            if (CollectionUtils.isEmpty(mappings)) {
                return null;
            }
            Map<RequestMappingInfo, HandlerMethod> mappingHandlers = registry.getMappings();
            List<RequestMappingInfo> matches = new ArrayList<>(1);
            for (RequestMappingInfo mapping : mappings) {
                if (!mapping.match(request)) {
                    continue;
                }
                matches.add(mapping);
            }
            if (matches.size() == 0) {
                return null;
            }
            if (matches.size() > 1) {
                matches.sort(Comparator.naturalOrder());
            }
            return mappingHandlers.get(matches.get(0));
        } finally {
            registry.releaseReadLock();
        }
    }

    private void addMapping(String[] hosts, Class clazz, Method method, RequestProcessor processor) {
        MethodsRequestCondition methodsCondition = new MethodsRequestCondition(processor.method());
        PathsRequestCondition pathsCondition = new PathsRequestCondition(hosts, processor.value());
        ParamsRequestCondition paramsCondition = new ParamsRequestCondition(processor.params());
        RequestMappingInfo mapping = new RequestMappingInfo(methodsCondition, pathsCondition, paramsCondition);
        try {
            Object handler = clazz.newInstance();
            registry.register(mapping, handler, method);
        } catch (Exception e) {
            logger.warn("add mapping failed, error={}", e.getMessage(), e);
        }
    }

}
