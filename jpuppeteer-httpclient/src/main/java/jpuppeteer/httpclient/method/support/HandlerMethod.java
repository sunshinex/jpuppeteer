package jpuppeteer.httpclient.method.support;

import java.lang.reflect.Method;

public class HandlerMethod {

    public final Object handler;

    public final Method method;

    public HandlerMethod(Object handler, Method method) {
        this.handler = handler;
        this.method = method;
    }
}
