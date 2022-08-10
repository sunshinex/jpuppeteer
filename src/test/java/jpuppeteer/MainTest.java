package jpuppeteer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import jpuppeteer.api.Browser;
import jpuppeteer.api.Page;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.page.LoadedEvent;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.util.JacksonUtil;
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
        Browser browser = new ChromeLauncher("D:\\chrome93\\chrome.exe").launch();
        Page page = browser.newPage().get(30, TimeUnit.SECONDS);
        page.addListener(new AbstractListener<LoadedEvent>() {
            @Override
            public void accept(LoadedEvent event) {
                page.eval("(function(){return new Date();})()", JsonNode.class).addListener(f -> {
                    ObjectMapper mapper = JacksonUtil.INSTANCE;
                    JavaType mapType = mapper.getTypeFactory().constructMapType(HashMap.class, String.class, String.class);
                    JsonNode jsonNode = (JsonNode) f.getNow();
                    Map<String, String> map = mapper.treeToValue(jsonNode, mapType);
                    System.out.println(map);
                });
            }
        });
        page.navigate("https://www.baidu.com/");
        TimeUnit.DAYS.sleep(1);
    }

}
