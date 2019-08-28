package jpuppeteer.httpclient.taobao.login;

import jpuppeteer.httpclient.SmartRequestExecutor;
import jpuppeteer.httpclient.annotation.Processor;
import jpuppeteer.httpclient.annotation.RequestProcessor;
import jpuppeteer.httpclient.constant.RequestMethod;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;


@Processor("login.taobao.com")
public class TaobaoLogin {

    @RequestProcessor(method = RequestMethod.GET, value = {"/", "/member/login.jhtml"})
    HttpResponse login(SmartRequestExecutor executor, HttpRequest request, HttpClientConnection conn, HttpContext context) {
        System.out.println(executor);
        return null;
    }

}
