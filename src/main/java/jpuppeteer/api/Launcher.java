package jpuppeteer.api;

public interface Launcher {

    Browser launch(String... args) throws Exception;

}
