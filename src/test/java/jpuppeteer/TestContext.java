package jpuppeteer;

import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.util.CookieParamBuilder;
import org.junit.*;

import java.util.concurrent.ExecutionException;

public class TestContext {

    private static Browser browser;

    @BeforeClass
    public static void setUpClass() throws Exception {
        browser = new ChromeLauncher(TestConfig.CHROME).launch(TestConfig.CHROME_ARGS);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        browser.close();
    }

    private BrowserContext context;

    @Before
    public void setUp() throws Exception {
        context = browser.createContext().get();
    }

    @After
    public void tearDown() throws Exception {
        context.close().get();
    }

    @Test
    public void browser() {
        Assert.assertEquals(browser, context.browser());
    }

    @Test
    public void grantPermissions() throws ExecutionException, InterruptedException {
        context.grantPermissions("https://www.baidu.com", PermissionType.GEOLOCATION).get();
    }

    @Test
    public void resetPermissions() throws ExecutionException, InterruptedException {
        context.resetPermissions().get();
    }

    @Test
    public void newPage() throws ExecutionException, InterruptedException {
        Assert.assertNotNull(context.newPage().get());
    }

    @Test
    public void pages() {
        Assert.assertEquals(0, context.pages().length);
    }

    @Test
    public void setCookies() throws ExecutionException, InterruptedException {
        CookieParam cookie = CookieParamBuilder.newBuilder()
                .name("cookie_name")
                .value("cookie_value")
                .domain("www.baidu.com")
                .build();
        context.setCookies(cookie).get();
    }

    @Test
    public void clearCookies() throws ExecutionException, InterruptedException {
        context.clearCookies().get();
    }

    @Test
    public void getCookies() throws ExecutionException, InterruptedException {
        Assert.assertEquals(0, context.getCookies().get().length);
    }

}
