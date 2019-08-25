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

    private volatile Integer executionContextId;

    protected ChromeExecutionContext(Runtime runtime, Integer executionContextId) {
        this.runtime = runtime;
        this.executionContextId = executionContextId;
    }

    public void setExecutionContextId(Integer executionContextId) {
        boolean init = this.executionContextId == null;
        this.executionContextId = executionContextId;
        if (init) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public Integer getExecutionContextId() {
        return executionContextId;
    }

    private ChromeBrowserObject evaluate(String expression, boolean returnJSON, CallArgument... args) throws Exception {
        if (executionContextId == null) {
            synchronized (this) {
                //等待
                logger.info("wait for execution context create");
                wait();
                logger.info("execution context created, id={}", executionContextId);
            }
        }
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
            return (R) object.getBoolean();
        } else if (Short.class.equals(clazz)) {
            return (R) object.getShort();
        } else if (Integer.class.equals(clazz)) {
            return (R) object.getInteger();
        } else if (Long.class.equals(clazz)) {
            return (R) object.getLong();
        } else if (Float.class.equals(clazz)) {
            return (R) object.getFloat();
        } else if (Double.class.equals(clazz)) {
            return (R) object.getDouble();
        } else if (BigDecimal.class.equals(clazz)) {
            return (R) object.getBigDecimal();
        } else if (BigInteger.class.equals(clazz)) {
            return (R) object.getBigInteger();
        } else if (String.class.equals(clazz)) {
            return (R) object.getString();
        } else if (Date.class.equals(clazz)) {
            return (R) object.getDate();
        } else {
            return object.getObject(clazz);
        }
    }

    @Override
    public <R> R evaluate(String expression, TypeReference<R> type, CallArgument... args) throws Exception {
        ChromeBrowserObject object = evaluate(expression, true, args);
        return object.getObject(type);
    }

    @Override
    public ChromeBrowserObject evaluate(String expression, CallArgument... args) throws Exception {
        return evaluate(expression, false, args);
    }
}
