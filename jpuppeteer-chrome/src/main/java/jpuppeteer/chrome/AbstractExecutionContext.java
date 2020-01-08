package jpuppeteer.chrome;

import jpuppeteer.api.browser.ExecutionContext;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.entity.runtime.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public abstract class AbstractExecutionContext implements ExecutionContext {

    private static final Logger logger = LoggerFactory.getLogger(AbstractExecutionContext.class);

    private static final Pattern FUNCTION_DECLARATION_PATTERN = Pattern.compile("^(async\\s+)?function(\\s+[a-zA-Z0-9_]+)?\\s*\\(", Pattern.MULTILINE);

    protected Runtime runtime;

    protected AbstractExecutionContext(Runtime runtime) {
        this.runtime = runtime;
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
        if (FUNCTION_DECLARATION_PATTERN.matcher(expression).matches()) {
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

    protected ChromeBrowserObject doCall(String function, boolean returnJSON, Object... args) throws Exception {
        CallFunctionOnRequest request = new CallFunctionOnRequest();
        request.setFunctionDeclaration(function);
        request.setArguments(Arrays.stream(args).map(arg -> buildArgument(arg)).collect(Collectors.toList()));
        request.setUserGesture(true);
        request.setReturnByValue(returnJSON);
        request.setAwaitPromise(true);
        request.setGeneratePreview(false);
        pre(request);
        CallFunctionOnResponse response = runtime.callFunctionOn(request, DEFAULT_TIMEOUT);

        processException(response.getExceptionDetails());

        return new ChromeBrowserObject(runtime, response.getResult());
    }

    protected ChromeBrowserObject doEvaluate(String expression, boolean returnJSON) throws Exception {
        EvaluateRequest request = new EvaluateRequest();
        request.setExpression(expression);
        request.setUserGesture(true);
        request.setReturnByValue(returnJSON);
        request.setAwaitPromise(true);
        request.setGeneratePreview(false);
        request.setTimeout(Long.valueOf(TimeUnit.SECONDS.toMillis(DEFAULT_TIMEOUT)).doubleValue());
        pre(request);
        EvaluateResponse response = runtime.evaluate(request, DEFAULT_TIMEOUT);

        processException(response.getExceptionDetails());

        return new ChromeBrowserObject(runtime, response.getResult());
    }

    abstract void pre(CallFunctionOnRequest request);

    abstract void pre(EvaluateRequest request);
}
