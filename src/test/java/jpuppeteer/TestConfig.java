package jpuppeteer;

public class TestConfig {

    public static final String CHROME = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";

    public static final String[] CHROME_ARGS = new String[] {
            "--remote-debugging-port=9222"
    };

    private TestConfig() {}

}
