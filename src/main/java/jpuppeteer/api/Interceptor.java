package jpuppeteer.api;

@FunctionalInterface
public interface Interceptor<T extends InterceptedResponse> {

    void intercept(T request);

    default void authenticate(Authenticator authenticator) {
        //do nth...
    }

}
