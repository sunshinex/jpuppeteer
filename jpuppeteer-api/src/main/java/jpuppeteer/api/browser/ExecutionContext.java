package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;

public interface ExecutionContext<T> {

    <R> R evaluate(String expression, Class<R> clazz, T... args) throws Exception;

    <R> R evaluate(String expression, TypeReference<R> type, T... args) throws Exception;

    BrowserObject evaluate(String expression, T... args) throws Exception;

}
