package jpuppeteer.chrome;

import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import jpuppeteer.api.browser.ExecutionContext;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeExecutionContext implements ExecutionContext<CallArgument> {

    private static final Logger logger = LoggerFactory.getLogger(ChromeExecutionContext.class);

    protected Runtime runtime;

    protected final Integer executionContextId;

    protected ChromeExecutionContext(Runtime runtime, Integer executionContextId) {
        this.runtime = runtime;
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return executionContextId;
    }

    private ChromeBrowserObject evaluate(String expression, boolean returnJSON, CallArgument... args) throws Exception {
        CallFunctionOnRequest request = new CallFunctionOnRequest();
        request.setFunctionDeclaration(expression);
        request.setArguments(Lists.newArrayList(args));
        request.setExecutionContextId(executionContextId);
        request.setReturnByValue(true);
        request.setUserGesture(true);
        request.setReturnByValue(returnJSON);
        request.setAwaitPromise(true);
        CallFunctionOnResponse response = runtime.callFunctionOn(request, DEFAULT_TIMEOUT);
        if (response.getExceptionDetails() != null) {
            throw new Exception(response.getExceptionDetails().getException().getDescription());
        }
        return new ChromeBrowserObject(runtime, this, response.getResult());
    }

    @Override
    public <R> R evaluate(String expression, Class<R> clazz, CallArgument... args) throws Exception {
        ChromeBrowserObject object = evaluate(expression, true, args);
        if (Boolean.class.equals(clazz)) {
            return (R) object.toBoolean();
        } else if (Short.class.equals(clazz)) {
            return (R) object.toShort();
        } else if (Integer.class.equals(clazz)) {
            return (R) object.toInteger();
        } else if (Long.class.equals(clazz)) {
            return (R) object.toLong();
        } else if (Float.class.equals(clazz)) {
            return (R) object.toFloat();
        } else if (Double.class.equals(clazz)) {
            return (R) object.toDouble();
        } else if (BigDecimal.class.equals(clazz)) {
            return (R) object.toBigDecimal();
        } else if (BigInteger.class.equals(clazz)) {
            return (R) object.toBigInteger();
        } else if (String.class.equals(clazz)) {
            return (R) object.toStringValue();
        } else if (Date.class.equals(clazz)) {
            return (R) object.toDate();
        } else {
            return object.toObject(clazz);
        }
    }

    @Override
    public <R> R evaluate(String expression, TypeReference<R> type, CallArgument... args) throws Exception {
        ChromeBrowserObject object = evaluate(expression, true, args);
        return object.toObject(type);
    }

    @Override
    public ChromeBrowserObject evaluate(String expression, CallArgument... args) throws Exception {
        return evaluate(expression, false, args);
    }
}
