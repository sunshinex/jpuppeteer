package jpuppeteer.httpclient.handler;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import jpuppeteer.httpclient.condition.RequestMappingInfo;
import jpuppeteer.httpclient.method.support.HandlerMethod;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RequestMappingRegistry {

    private final Map<RequestMappingInfo, HandlerMethod> mappingLookup = new LinkedHashMap<>();

    private final Multimap<String, RequestMappingInfo> urlLookup = LinkedListMultimap.create();

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
            HandlerMethod handlerMethod = new HandlerMethod(handler, method);
            assertUniqueMethodMapping(handlerMethod, mapping);
            this.mappingLookup.put(mapping, handlerMethod);

            for (String host : mapping.getPathsCondition().getHosts()) {
                for (String path : mapping.getPathsCondition().getPaths()) {
                    this.urlLookup.put(host + path, mapping);
                }
            }
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

    public void unregister(RequestMappingInfo mapping) {
        this.readWriteLock.writeLock().lock();
        try {

            this.mappingLookup.remove(mapping);
            for (String host : mapping.getPathsCondition().getHosts()) {
                for (String path : mapping.getPathsCondition().getPaths()) {
                    this.urlLookup.remove(host + path, mapping);
                }
            }
        }
        finally {
            this.readWriteLock.writeLock().unlock();
        }
    }


}
