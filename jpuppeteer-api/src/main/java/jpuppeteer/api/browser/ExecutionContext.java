package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;

public interface ExecutionContext {

    <R> R evaluate(String expression, Class<R> clazz, Object... args) throws Exception;

    <R> R evaluate(String expression, TypeReference<R> type, Object... args) throws Exception;

    BrowserObject evaluate(String expression, Object... args) throws Exception;

}
