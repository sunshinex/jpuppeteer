package jpuppeteer.chrome;

import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.browser.Launcher;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.WebSocketConnection;
import jpuppeteer.chrome.event.PageEvent;
import jpuppeteer.chrome.util.ScriptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChromeLauncher implements Launcher {

    private static final Logger logger = LoggerFactory.getLogger(ChromeLauncher.class);

    private static final Pattern LISTENING_PATTERN = Pattern.compile("^DevTools listening on (ws:\\/\\/.*)$");

    private final File executable;

    private Process process;

    private ChromeArguments chromeArguments;

    public ChromeLauncher(File executable) {
        this.executable = executable;
    }

    @Override
    public Browser launch(String... args) throws Exception {
        chromeArguments = ChromeArguments.parse(executable.getAbsolutePath(), args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //java进程退出的时候, 把chrome进程也一并退出
            if (process != null) {
                process.destroy();
            }
        }));
        process = Runtime.getRuntime().exec(chromeArguments.getCommand());
        CDPConnection connection;
        if (!chromeArguments.isPipe()) {
            //等待chrome启动成功的debug listening输出
            URI uri = waitForListening();
            if (uri == null) {
                throw new RuntimeException("parse listening error");
            }
            connection = new WebSocketConnection(uri);
        } else {
            throw new Exception("unsupport pipe debug mode");
        }
        ChromeBrowser browser = new ChromeBrowser(process, connection);
        logger.info("准备打开页面");
        ChromeContext context = browser.defaultContext();
        //for(int i = 0; i<20; i++) {
            ChromePage page = context.newPage();
            page.evaluateOnNewDocument(ScriptUtils.load("fake.js"));
            page.addListener(PageEvent.CLOSE, event -> {
                logger.info("type=CLOSE, event={}", event);
            });
            page.addListener(PageEvent.LOAD, event -> {
                logger.info("type=LOAD, event={}", event);
            });
            page.addListener(PageEvent.DOMCONTENTLOADED, event -> {
                logger.info("type=DOMCONTENTLOADED, event={}", event);
            });
            page.addListener(PageEvent.COOKIE, e -> logger.info("type=COOKIR, cookies={}", e.getCookies()));
            page.navigate("https://login.taobao.com/?useMobile=false", null);
            page.wait(PageEvent.DOMCONTENTLOADED);
//            System.out.println(-0);
//            System.out.println(page.evaluate("function(){return BigInt('12393249091902388912399');}").get());
            //page.setContent("<a href='http://www.baidu.com/' target='_blank'>点击打开新窗口</a>");
            //System.out.println(page.content());
            page.waitSelector("body", 10, TimeUnit.SECONDS);
            //page.querySelector("#TPL_password_1").input("1239091234", 50);
            //page.querySelector("#J_SubmitStatic").click();
            //page.wait(PageEvent.LOAD);
            //ChromeElement message = page.waitSelector("#J_Message", 5, TimeUnit.SECONDS);
            //System.out.println(message.getProperty("innerText").getString());
//            ChromeElement element = page.querySelector("head");
//            System.out.println(element);
            //logger.info("response={}", response);
            //page.close();
//            ChromeElement element = page.querySelector("#kw");
//            element.input("奥巴马", 50);
//            TimeUnit.SECONDS.sleep(5);
//            page.press(USKeyboardDefinition.ESCAPE, 50);
//            page.querySelector(".s_tab_inner a:nth-of-type(3)").click(ButtonType.LEFT);
//            List<ChromeElement> divs = page.querySelectorAll("div");
//            head.querySelector("title");
        //}
        //page.navigate("https://www.w3school.com.cn/tiy/t.asp?f=html_iframe", WaitUntil.NETWORKIDLE1, null);
//        browser.defaultContext().newPage().navigate("http://i.taobao.com/", WaitUntil.LOAD, null);
        logger.info("打开页面完成");
        //browser.defaultContext().newPage().navigate("https://www.baidu.com/", 10, null, null);
//        TargetCreation tc = new TargetCreation();
//        tc.setUrl("about:blank");
//        String targetId = browser.getTarget().createTarget(tc);
//        String sessionId = browser.getTarget().attachToTarget(targetId);
//        MPage page = browser.getPage(sessionId);
//        CDPSession session = new CDPSession(connection, TargetType.PAGE, sessionId);
//        session.send("Runtime.enable", null);
//        session.send("Network.enable", null);
//        session.send("Page.enable", null);
//        page.addScriptToEvaluateOnNewDocument("alert(123)");
//        System.out.println(page.navigate("http://www.baidu.com", null, null, null));
        //browser.getPage().bringToFront();
        return null;
    }

    private URI waitForListening() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Matcher matcher = LISTENING_PATTERN.matcher(line);
            if (matcher.matches()) {
                logger.debug("chrome startup output:{}", line);
                return URI.create(matcher.group(1));
            }
        }
        throw new RuntimeException("please ensure startup with arg --remote-debugging-pipe or --remote-debugging-port");
    }

    public static void main(String[] args) throws Exception {
        new ChromeLauncher(new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")).launch(args);
//        new ChromeLauncher(new File("D:\\workspace\\browser-driver\\bin\\chrome\\win32-x64\\chrome")).launch(args);
    }
}
