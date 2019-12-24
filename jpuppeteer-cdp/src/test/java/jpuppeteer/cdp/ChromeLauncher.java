package jpuppeteer.cdp;

import com.alibaba.fastjson.JSONObject;
import jpuppeteer.cdp.cdp.CDPEventType;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.target.SetDiscoverTargetsRequest;
import jpuppeteer.cdp.cdp.entity.target.TargetCreatedEvent;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChromeLauncher {

    private static final Pattern LISTENING_PATTERN = Pattern.compile("^DevTools listening on (ws:\\/\\/.*)$");

    @Test
    public void test() throws Exception {
        //String executable = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        String executable = "D:\\workspace\\win32-x64\\chrome.exe";
        ChromeArguments chromeArguments = ChromeArguments.parse(executable);
        String[] command = chromeArguments.getCommand();
        File exec = new File(executable);
        System.out.println("command line: " + StringUtils.join(command, " "));
        Process process = Runtime.getRuntime().exec(command, null, exec.getParentFile());
        CDPConnection connection;
        if (!chromeArguments.isPipe()) {
            //等待chrome启动成功的debug listening输出
            URI uri = waitForListening(process);
            connection = new WebSocketCDPConnection(uri);
        } else {
            throw new Exception("unsupport pipe debug mode");
        }
        connection.open();
//        for(CDPEventType eventType : CDPEventType.values()) {
//            connection.addListener(eventType, evt -> {
//                System.out.println(evt);
//            });
//        }
        connection.addListener(CDPEventType.TARGET_TARGETCREATED, (JSONObject object) -> {
            TargetCreatedEvent event = object.getObject("params", TargetCreatedEvent.class);
            System.out.println(event);
        });
        Target target = new Target(connection);
        SetDiscoverTargetsRequest request = new SetDiscoverTargetsRequest();
        request.setDiscover(true);
        target.setDiscoverTargets(request, 30);
        TimeUnit.DAYS.sleep(1);
    }

    private URI waitForListening(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Matcher matcher = LISTENING_PATTERN.matcher(line);
            if (matcher.matches()) {
                System.out.println(line);
                return URI.create(matcher.group(1));
            }
        }
        throw new RuntimeException("please ensure startup with arg --remote-debugging-pipe or --remote-debugging-port");
    }
}
