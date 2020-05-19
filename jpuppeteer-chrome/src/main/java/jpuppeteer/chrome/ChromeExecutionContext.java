package jpuppeteer.chrome;

import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.browser.ExecutionContext;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeExecutionContext implements ExecutionContext {

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

    protected static CallArgument buildArgument(Object object) {
        CallArgument argument = new CallArgument();
        if (object instanceof ChromeBrowserObject) {
            argument.setObjectId(((ChromeBrowserObject) object).getObjectId());
        } else if (object instanceof CallArgument) {
            logger.warn("use object instead of CallArgument");
            argument = (CallArgument) object;
        } else {
            argument.setValue(object);
        }
        return argument;
    }

    private ChromeBrowserObject evaluate(String expression, boolean returnJSON, Object... args) throws Exception {
        CallFunctionOnRequest request = new CallFunctionOnRequest();
        request.setFunctionDeclaration(expression);
        request.setArguments(Arrays.stream(args).map(arg -> buildArgument(arg)).collect(Collectors.toList()));
        request.setExecutionContextId(executionContextId);
        request.setUserGesture(true);
        request.setReturnByValue(returnJSON);
        request.setAwaitPromise(true);
        CallFunctionOnResponse response = runtime.callFunctionOn(request, DEFAULT_TIMEOUT);
        if (response.getExceptionDetails() != null) {
            String error = "null";
            if (StringUtils.isNotEmpty(response.getExceptionDetails().getText())) {
                error = response.getExceptionDetails().getText();
            }
            if (response.getExceptionDetails().getException() != null && StringUtils.isNotEmpty(response.getExceptionDetails().getException().getDescription())) {
                error = response.getExceptionDetails().getException().getDescription();
            }
            throw new Exception(error);
        }
        return new ChromeBrowserObject(runtime, this, response.getResult());
    }

    @Override
    public <R> R evaluate(String expression, Class<R> clazz, Object... args) throws Exception {
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
    public <R> R evaluate(String expression, TypeReference<R> type, Object... args) throws Exception {
        ChromeBrowserObject object = evaluate(expression, true, args);
        return object.toObject(type);
    }

    @Override
    public ChromeBrowserObject evaluate(String expression, Object... args) throws Exception {
        return evaluate(expression, false, args);
    }
}
