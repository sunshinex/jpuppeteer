package jpuppeteer.api.browser;

import java.net.URL;
import java.util.List;

public interface Response {

    <R extends Frame> R frame();

    boolean fromCache();

    //暂不支持
//    boolean fromServiceWorker();

    List<Header> headers();

    String remoteAddress();

    <R extends Request> R request();

    SecurityDetails securityDetails();

    int status();

    String statusText();

    byte[] content();

    URL url();

}
