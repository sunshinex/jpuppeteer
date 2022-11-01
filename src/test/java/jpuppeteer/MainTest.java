package jpuppeteer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import jpuppeteer.api.Browser;
import jpuppeteer.api.Page;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.page.LoadedEvent;
import jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.client.entity.emulation.UserAgentBrandVersion;
import jpuppeteer.cdp.client.entity.emulation.UserAgentMetadata;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.util.JacksonUtil;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.XFuture;
import jpuppeteer.util.XPromise;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainTest {

    @Test
    public void test() throws Exception {
        Browser browser = new ChromeLauncher("D:\\chrome93\\chrome.exe").launch(/*new String[]{"--proxy-server=58.215.100.180:20154"}*/);
        Page page = browser.createContext()
                .get(30, TimeUnit.SECONDS)
                .newPage()
                .get(30, TimeUnit.SECONDS);
        page.addScriptToEvaluateOnNewDocument("window.fakeRandom = " + Math.random())
                .get(5, TimeUnit.SECONDS);
        page.addScriptToEvaluateOnNewDocument(ScriptUtil.load("script/fake.js"))
                .get(5, TimeUnit.SECONDS);
        SetUserAgentOverrideRequest userAgent = new SetUserAgentOverrideRequest(
                "Mozilla/5.0 (Linux; Android 12; Redmi K30 5G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36",
                "zh-CN,zh",
                "Linux aarch64",
                null
        );
        page.setUserAgent(userAgent).get(5, TimeUnit.SECONDS);
        page.setDevice(ScreenOrientationType.PORTRAITPRIMARY, 393, 873, 393, 873, 2.75, true)
                        .get(5, TimeUnit.SECONDS);
        page.enableTouchEmulation(true, 5).get(5, TimeUnit.SECONDS);
        page.enableEmitTouchEventsForMouse(true, SetEmitTouchEventsForMouseRequestConfiguration.MOBILE).get(5, TimeUnit.SECONDS);
        page.navigate("https://m.dewu.com/router/");
        TimeUnit.DAYS.sleep(1);
    }

}
