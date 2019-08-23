package jpuppeteer;

import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.CDPSession;
import jpuppeteer.cdp.WebSocketConnection;
import jpuppeteer.cdp.cdp.CDPEventType;
import jpuppeteer.cdp.cdp.domain.Page;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.domain.Target;
import jpuppeteer.cdp.cdp.entity.runtime.EvaluateRequest;
import jpuppeteer.cdp.cdp.entity.runtime.EvaluateResponse;
import jpuppeteer.cdp.cdp.entity.runtime.ExecutionContextCreatedEvent;
import jpuppeteer.cdp.cdp.entity.target.AttachToTargetRequest;
import jpuppeteer.cdp.cdp.entity.target.AttachToTargetResponse;
import jpuppeteer.cdp.cdp.entity.target.CreateTargetRequest;
import jpuppeteer.cdp.cdp.entity.target.CreateTargetResponse;
import org.junit.Test;

import java.net.URI;
import java.util.concurrent.TimeUnit;

public class CDPTest {

    @Test
    public void test() throws Exception {
        CDPConnection connection = new WebSocketConnection(URI.create("ws://127.0.0.1:9222/devtools/browser/e1f2660c-8ff5-4eed-886c-d160002847a7"));
        connection.open();
        Target target = new Target(connection);
        CreateTargetRequest createReq = new CreateTargetRequest();
        createReq.setUrl("about:blank");
        CreateTargetResponse createResp = target.createTarget(createReq, 30);

        String targetId = createResp.getTargetId();

        AttachToTargetRequest attachReq = new AttachToTargetRequest();
        attachReq.setFlatten(true);
        attachReq.setTargetId(targetId);

        AttachToTargetResponse attachResp = target.attachToTarget(attachReq, 30);
        CDPSession session = connection.createSession(attachResp.getSessionId());

        Runtime runtime = new Runtime(session);

        session.addListener(CDPEventType.RUNTIME_EXECUTIONCONTEXTCREATED, ev -> {
            ExecutionContextCreatedEvent execution = ev.getParams().toJavaObject(ExecutionContextCreatedEvent.class);
            System.out.println(execution);
            if (execution.getContext() == null || execution.getContext().getAuxData() == null || !targetId.equals(execution.getContext().getAuxData().get("frameId"))) {
                return;
            }
            EvaluateRequest request = new EvaluateRequest();
            request.setContextId(execution.getContext().getId());
            request.setAwaitPromise(true);
            request.setExpression("document.querySelector('body')");
            request.setIncludeCommandLineAPI(true);
            request.setReturnByValue(false);
            request.setUserGesture(true);
            try {
                EvaluateResponse response = runtime.evaluate(request, 30);
                System.out.println(response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        runtime.enable(30);

        Page page = new Page(session);
        page.enable(30);

//        NavigateRequest request = new NavigateRequest();
//        request.setUrl("https://www.baidu.com/");
//        page.navigate(request, 30);

        TimeUnit.DAYS.sleep(1);

//        Runtime runtime = new Runtime(session);
//        EvaluateRequest request = new EvaluateRequest();
//        runtime.evaluate("-0", 30);
    }

}
