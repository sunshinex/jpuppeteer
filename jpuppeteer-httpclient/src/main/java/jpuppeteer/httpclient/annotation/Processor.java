package jpuppeteer.httpclient.annotation;

import jpuppeteer.httpclient.constant.RequestProtocol;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Processor {

    RequestProtocol[] protocol() default {RequestProtocol.HTTP, RequestProtocol.HTTPS};

    /**
     * request host
     * @return
     */
    String[] value() default {};

}
