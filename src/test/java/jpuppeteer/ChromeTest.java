package jpuppeteer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import jpuppeteer.api.Browser;
import jpuppeteer.api.Page;
import jpuppeteer.cdp.client.constant.browser.PermissionType;
import jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.entity.emulation.*;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.entity.HttpResource;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.SetDeviceMetricsOverrideRequestBuilder;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    @Test
    public void test() throws Exception {
        Browser browser = new ChromeLauncher("D:\\chrome93\\chrome.exe").launch("--enable-virtual-keyboard", "--disable-gpu", "--lang=\"zh-CN\"");
        Page page = browser.createContext().get().newPage().get();
        page.browserContext().grantPermissions(
                "https://h5.m.taobao.com",
                PermissionType.NOTIFICATIONS,
                PermissionType.SENSORS
        ).get();
        page.browserContext().grantPermissions(
                "https://h5api.m.taobao.com",
                PermissionType.NOTIFICATIONS,
                PermissionType.SENSORS
        ).get();
        page.enableTouchEmulation(true, 5).get();
        SetDeviceMetricsOverrideRequest request = SetDeviceMetricsOverrideRequestBuilder.newBuilder()
                .width(393)
                .height(680)
                .deviceScaleFactor(BigDecimal.valueOf(2.75))
                .mobile(true)
                .screenOrientation(new ScreenOrientation(ScreenOrientationType.PORTRAITPRIMARY, 0))
                .build();
        page.setDevice(request).get();
        page.setUserAgent(new SetUserAgentOverrideRequest(
                "Mozilla/5.0 (Linux; Android 12; Redmi K30 5G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Mobile Safari/537.36",
                "zh-CN",
                "Linux aarch64",
                new UserAgentMetadata(
                        Lists.newArrayList(
                                new UserAgentBrandVersion(" Not A;Brand", "99"),
                                new UserAgentBrandVersion("Chromium", "101"),
                                new UserAgentBrandVersion("Google Chrome", "101")
                        ),
                        "101.0.4951.41", "Android", "12",
                        "aarch64", "Redmi K30 5G", true
                )
        )).get();
        page.enableEmitTouchEventsForMouse(true, SetEmitTouchEventsForMouseRequestConfiguration.MOBILE).get();
        page.addScriptToEvaluateOnNewDocument("window.fakeRandom=" + Math.random() + ";");
        page.addScriptToEvaluateOnNewDocument(ScriptUtil.load("script/fake.js"));
        new Thread() {
            @Override
            public void run() {
                List<JSONObject> sensorLogs = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader("D:\\tmp\\sensor.log"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (StringUtils.isBlank(line)) {
                            continue;
                        }
                        sensorLogs.add(JSON.parseObject(line));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                int idx = 0;
                long lastTime = 0;
                while (true) {
                    try {
                        idx = (idx + 1) % sensorLogs.size();
                        JSONObject sensorData = sensorLogs.get(idx);
                        JSONArray values = sensorData.getJSONArray("values");
                        page.setOrientation(values.getDoubleValue(0), values.getDoubleValue(1), values.getDoubleValue(2)).get();
                        if (lastTime > 0) {
                            long sleepTime = sensorData.getLongValue("timestamp") - lastTime;
                            if (sleepTime > 0) {
                                TimeUnit.NANOSECONDS.sleep(sleepTime);
                            }
                        }
                        lastTime = sensorData.getLongValue("timestamp");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        TimeUnit.DAYS.sleep(1);
    }

}
