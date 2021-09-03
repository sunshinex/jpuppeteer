package jpuppeteer;

public class TestConfig {

    public static final String CHROME = "D:\\chrome87\\chrome.exe";

    public static final String[] CHROME_ARGS = new String[] {
            "--remote-debugging-port=9222",
            "--ignore-urlfetcher-cert-requests",
            "--ignore-certificate-errors",
            "--lang=\"zh-CN\"",
            "--proxy-server="
    };

    private TestConfig() {}

}
