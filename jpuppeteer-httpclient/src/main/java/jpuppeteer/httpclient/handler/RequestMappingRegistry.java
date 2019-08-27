package jpuppeteer.httpclient.handler;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import jpuppeteer.httpclient.method.RequestMappingInfo;
import jpuppeteer.httpclient.method.support.HandlerMethod;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RequestMappingRegistry {

    private final Map<RequestMappingInfo, HandlerMethod> mappingLookup = new LinkedHashMap<>();

    private final Multimap<String, RequestMappingInfo> urlLookup = new LinkedListMultimap<>();

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Map<RequestMappingInfo, HandlerMethod> getMappings() {
        return this.mappingLookup;
    }

    public Collection<RequestMappingInfo> getMappingsByUrl(String urlPath) {
        return this.urlLookup.get(urlPath);
    }

    /**
     * Acquire the read lock when using getMappings and getMappingsByUrl.
     */
    public void acquireReadLock() {
        this.readWriteLock.readLock().lock();
    }

    public void releaseReadLock() {
        this.readWriteLock.readLock().unlock();
    }

    public void register(RequestMappingInfo mapping, Object handler, Method method) {
        this.readWriteLock.writeLock().lock();
        try {
            HandlerMethod handlerMethod = new HandlerMethod(method);
            assertUniqueMethodMapping(handlerMethod, mapping);
            this.mappingLookup.put(mapping, handlerMethod);

            List<String> directUrls = getDirectUrls(mapping);
            for (String url : directUrls) {
                this.urlLookup.add(url, mapping);
            }

            String name = null;
            if (getNamingStrategy() != null) {
                name = getNamingStrategy().getName(handlerMethod, mapping);
                addMappingName(name, handlerMethod);
            }

            CorsConfiguration corsConfig = initCorsConfiguration(handler, method, mapping);
            if (corsConfig != null) {
                this.corsLookup.put(handlerMethod, corsConfig);
            }

            this.registry.put(mapping, new MappingRegistration<>(mapping, handlerMethod, directUrls, name));
        }
        finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    private void assertUniqueMethodMapping(HandlerMethod newHandlerMethod, RequestMappingInfo mapping) {
        HandlerMethod handlerMethod = this.mappingLookup.get(mapping);
        if (handlerMethod != null && !handlerMethod.equals(newHandlerMethod)) {
            throw new IllegalStateException(
                    "Ambiguous mapping. Cannot map method \n" +
                            newHandlerMethod + "\nto " + mapping + ": There is already method\n" + handlerMethod + " mapped.");
        }
    }

    private List<String> getDirectUrls(RequestMappingInfo mapping) {
        List<String> urls = new ArrayList<>(1);
        for (String path : getMappingPathPatterns(mapping)) {
            if (!getPathMatcher().isPattern(path)) {
                urls.add(path);
            }
        }
        return urls;
    }

    private void addMappingName(String name, HandlerMethod handlerMethod) {
        List<HandlerMethod> oldList = this.nameLookup.get(name);
        if (oldList == null) {
            oldList = Collections.emptyList();
        }

        for (HandlerMethod current : oldList) {
            if (handlerMethod.equals(current)) {
                return;
            }
        }

        List<HandlerMethod> newList = new ArrayList<>(oldList.size() + 1);
        newList.addAll(oldList);
        newList.add(handlerMethod);
        this.nameLookup.put(name, newList);
    }

    public void unregister(T mapping) {
        this.readWriteLock.writeLock().lock();
        try {
            MappingRegistration<T> definition = this.registry.remove(mapping);
            if (definition == null) {
                return;
            }

            this.mappingLookup.remove(definition.getMapping());

            for (String url : definition.getDirectUrls()) {
                List<T> list = this.urlLookup.get(url);
                if (list != null) {
                    list.remove(definition.getMapping());
                    if (list.isEmpty()) {
                        this.urlLookup.remove(url);
                    }
                }
            }

            removeMappingName(definition);

            this.corsLookup.remove(definition.getHandlerMethod());
        }
        finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    private void removeMappingName(MappingRegistration<T> definition) {
        String name = definition.getMappingName();
        if (name == null) {
            return;
        }
        HandlerMethod handlerMethod = definition.getHandlerMethod();
        List<HandlerMethod> oldList = this.nameLookup.get(name);
        if (oldList == null) {
            return;
        }
        if (oldList.size() <= 1) {
            this.nameLookup.remove(name);
            return;
        }
        List<HandlerMethod> newList = new ArrayList<>(oldList.size() - 1);
        for (HandlerMethod current : oldList) {
            if (!current.equals(handlerMethod)) {
                newList.add(current);
            }
        }
        this.nameLookup.put(name, newList);
    }

}
