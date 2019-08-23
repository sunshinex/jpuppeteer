package jpuppeteer.api.browser;

import java.net.URL;
import java.util.List;

public interface Response {

    Frame frame();

    boolean fromCache();

    //暂不支持
//    boolean fromServiceWorker();

    List<Header> headers();

    String remoteAddress();

    Request request();

    SecurityDetails securityDetails();

    int status();

    String statusText();

    String content();

    URL url();

}
