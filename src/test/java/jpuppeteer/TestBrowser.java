package jpuppeteer;

import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.cdp.client.entity.browser.GetVersionResponse;
import jpuppeteer.chrome.ChromeLauncher;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class TestBrowser {

    private static Browser browser;

    @BeforeClass
    public static void setUp() throws Exception {
        browser = new ChromeLauncher(TestConfig.CHROME).launch(TestConfig.CHROME_ARGS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        browser.close();
    }

    @Test
    public void version() throws ExecutionException, InterruptedException {
        GetVersionResponse version = browser.version().get();
        Assert.assertNotNull(version);
    }

    @Test
    public void defaultContext() {
        Assert.assertNotNull(browser.defaultContext());
    }

    @Test
    public void createContext() throws ExecutionException, InterruptedException {
        BrowserContext context = browser.createContext().get();
        Assert.assertNotNull(context);
        context.close().get();
    }

    @Test
    public void browserContexts() {
        Assert.assertEquals(0, browser.browserContexts().length);
    }

}
