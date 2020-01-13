package jpuppeteer.chrome;

import com.alibaba.fastjson.TypeReference;
import jpuppeteer.api.browser.ExecutionContext;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.entity.runtime.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeExecutionContext implements ExecutionContext {

    private static final Logger logger = LoggerFactory.getLogger(ChromeExecutionContext.class);

    private static final Pattern FUNCTION_DECLARATION_PATTERN = Pattern.compile("^(async\\s+)?function(\\s+[a-zA-Z0-9_]+)?\\s*\\(", Pattern.MULTILINE);

    private Runtime runtime;

    protected final Integer executionContextId;

    protected ChromeExecutionContext(Runtime runtime, Integer executionContextId) {
        this.runtime = runtime;
        this.executionContextId = executionContextId;
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

    protected static boolean isFunction(String expression) {
        expression = StringUtils.trim(expression);
        if (StringUtils.isEmpty(expression)) {
            return false;
        }
        Matcher matcher = FUNCTION_DECLARATION_PATTERN.matcher(expression);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    protected static void processException(ExceptionDetails exceptionDetails) throws Exception {
        if (exceptionDetails == null) {
            return;
        }
        String error = "null";
        if (StringUtils.isNotEmpty(exceptionDetails.getText())) {
            error = exceptionDetails.getText();
        }
        if (exceptionDetails.getException() != null && StringUtils.isNotEmpty(exceptionDetails.getException().getDescription())) {
            error = exceptionDetails.getException().getDescription();
        }
        throw new Exception(error);
    }

    protected ChromeBrowserObject doCall(String function, String objectId, boolean returnJSON, Object... args) throws Exception {
        CallFunctionOnRequest request = new CallFunctionOnRequest();
        request.setFunctionDeclaration(function);
        request.setArguments(Arrays.stream(args).map(arg -> buildArgument(arg)).collect(Collectors.toList()));
        request.setUserGesture(true);
        request.setReturnByValue(returnJSON);
        request.setAwaitPromise(true);
        request.setGeneratePreview(false);
        if (StringUtils.isNotEmpty(objectId)) {
            request.setObjectId(objectId);
        } else {
            request.setExecutionContextId(executionContextId);
        }
        CallFunctionOnResponse response = runtime.callFunctionOn(request, DEFAULT_TIMEOUT);

        processException(response.getExceptionDetails());

        return new ChromeBrowserObject(runtime, this, response.getResult());
    }

    protected ChromeBrowserObject doEvaluate(String expression, boolean returnJSON) throws Exception {
        EvaluateRequest request = new EvaluateRequest();
        request.setExpression(expression);
        request.setUserGesture(true);
        request.setReturnByValue(returnJSON);
        request.setAwaitPromise(true);
        request.setGeneratePreview(false);
        request.setTimeout(Long.valueOf(TimeUnit.SECONDS.toMillis(DEFAULT_TIMEOUT)).doubleValue());
        request.setContextId(executionContextId);
        EvaluateResponse response = runtime.evaluate(request, DEFAULT_TIMEOUT);

        processException(response.getExceptionDetails());

        return new ChromeBrowserObject(runtime, this, response.getResult());
    }

    private ChromeBrowserObject evaluate(String expression, boolean returnJSON, Object... args) throws Exception {
        if (isFunction(expression)) {
            return doCall(expression, null, returnJSON, args);
        } else {
            return doEvaluate(expression, returnJSON);
        }
    }

    @Override
    public <R> R evaluate(String expression, Class<R> clazz, Object... args) throws Exception {
        return evaluate(expression, true, args).toObject(clazz);
    }

    @Override
    public <R> R evaluate(String expression, TypeReference<R> type, Object... args) throws Exception {
        return evaluate(expression, true, args).toObject(type);
    }

    @Override
    public ChromeBrowserObject evaluate(String expression, Object... args) throws Exception {
        return evaluate(expression, false, args);
    }
}
