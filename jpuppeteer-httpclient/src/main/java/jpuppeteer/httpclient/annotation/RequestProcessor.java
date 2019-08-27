package jpuppeteer.httpclient.annotation;

import jpuppeteer.httpclient.constant.RequestMethod;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestProcessor {

    RequestMethod[] method() default {};

    /**
     * request path
     * @return
     */
    String[] value() default {};

    String[] params() default {};

}
