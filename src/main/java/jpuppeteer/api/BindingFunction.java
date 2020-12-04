package jpuppeteer.api;

@FunctionalInterface
public interface BindingFunction {

    void call(Isolate isolate, String payload);

}
