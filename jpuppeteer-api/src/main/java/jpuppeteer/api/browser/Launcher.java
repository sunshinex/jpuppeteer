package jpuppeteer.api.browser;

public interface Launcher {

    <R extends Browser> R launch(String... args) throws Exception;

}
