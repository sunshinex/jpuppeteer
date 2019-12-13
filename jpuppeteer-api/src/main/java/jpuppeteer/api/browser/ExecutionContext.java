package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;

public interface ExecutionContext<P> {

    <R> R evaluate(String expression, Class<R> clazz, P... args) throws Exception;

    <R> R evaluate(String expression, TypeReference<R> type, P... args) throws Exception;

    <R extends BrowserObject<P>> R evaluate(String expression, P... args) throws Exception;

}
