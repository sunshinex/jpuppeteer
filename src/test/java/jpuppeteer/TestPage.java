package jpuppeteer;

import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.Page;
import jpuppeteer.chrome.ChromeLauncher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestPage {

    private static Browser browser;

    @BeforeClass
    public static void setUpClass() throws Exception {
        browser = new ChromeLauncher(TestConfig.CHROME).launch(TestConfig.CHROME_ARGS);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        browser.close().get();
    }

    private BrowserContext context;

    private Page page;

    @Before
    public void setUp() throws Exception {
        context = browser.createContext().get();
        page = context.newPage().get();
    }

    @After
    public void tearDown() throws Exception {
        try {
            page.close().get();
        } finally {
            context.close().get();
        }
    }

}
