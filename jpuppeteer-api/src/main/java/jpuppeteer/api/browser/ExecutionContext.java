package jpuppeteer.api.browser;

public interface ExecutionContext {

    BrowserObject evaluate(String expression) throws Exception;

}
