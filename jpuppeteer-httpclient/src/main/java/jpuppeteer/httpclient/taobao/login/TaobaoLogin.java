package jpuppeteer.httpclient.taobao.login;

import jpuppeteer.httpclient.annotation.Processor;
import jpuppeteer.httpclient.annotation.RequestProcessor;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;


@Processor("login.taobao.com")
public class TaobaoLogin {

    @RequestProcessor(path = {"/", "/member/login.jhtml"})
    void login(HttpRequest request, HttpContext context) {

    }

}
