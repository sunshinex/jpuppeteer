package jpuppeteer.util;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import io.netty.util.concurrent.EventExecutor;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.api.Element;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectType;
import jpuppeteer.cdp.client.domain.DOM;
import jpuppeteer.cdp.client.entity.runtime.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class IsolateUtil {

    private static final String NEGATIVE_ZERO = "-0";

    private static final String NAN = "NaN";

    private static final String INFINITY = "Infinity";

    private static final String NEGATIVE_INFINITY = "-Infinity";

    private IsolateUtil() {

    }

    public static void checkException(ExceptionDetails exceptionDetails) throws ExecutionException {
        if (exceptionDetails != null) {
            String error = "null";
            if (StringUtils.isNotEmpty(exceptionDetails.text)) {
                error = exceptionDetails.text;
            }
            if (exceptionDetails.exception != null && StringUtils.isNotEmpty(exceptionDetails.exception.description)) {
                error = exceptionDetails.exception.description;
            }
            throw new ExecutionException(error, exceptionDetails.stackTrace);
        }
    }

    public static EvaluateRequest buildEvaluateRequest(String expression, Integer isolateId, boolean returnValue, Integer timeout, String uniqueId) {
        BigDecimal tmOut = timeout != null ? BigDecimal.valueOf(timeout) : null;
        EvaluateRequestBuilder builder = EvaluateRequestBuilder.newBuilder()
                .expression(expression);
        if (uniqueId != null) {
            builder.uniqueContextId(uniqueId);
        } else {
            builder.contextId(isolateId);
        }
        return builder.returnByValue(returnValue)
                .timeout(tmOut)
                .includeCommandLineAPI(true)
                .silent(true)
                .generatePreview(false)
                .userGesture(true)
                .awaitPromise(true)
                .throwOnSideEffect(false)
                .disableBreaks(true)
                .replMode(true)
                .build();
    }

    public static CallFunctionOnRequest buildCallRequest(String declaration, String objectId, boolean returnValue, Integer isolateId, Object... args) {
        return new CallFunctionOnRequest(
                declaration, objectId,
                Arrays.stream(args)
                        .map(arg -> buildArgument(arg))
                        .collect(Collectors.toList()),
                true, returnValue, false, true,
                true, isolateId, null
        );
    }

    public static CallArgument buildArgument(Object object) {
        CallArgument argument;
        if (object instanceof BrowserObject) {
            argument = new CallArgument(null, null, ((BrowserObject) object).objectId());
        } else if (object instanceof CallArgument) {
            argument = (CallArgument) object;
        } else {
            argument = new CallArgument(object, null, null);
        }
        return argument;
    }

    public static <R> R remoteObjectToValue(RemoteObject object, Class<R> clazz) {
        if (object.objectId != null) {
            //对于objectId存在的，直接返回空
            return null;
        }
        Object value = object.value;
        if (RemoteObjectType.OBJECT.equals(object.type) &&
                RemoteObjectSubtype.DATE.equals(object.subtype)) {
            value = null;
        } else if (RemoteObjectType.NUMBER.equals(object.type) && StringUtils.isNotEmpty(object.unserializableValue)) {
            if (NEGATIVE_ZERO.equals(object.unserializableValue)) {
                value = -0;
            } else {
                value = null;
            }
        } else if (RemoteObjectType.BIGINT.equals(object.type)) {
            value = new BigInteger(StringUtils.removeEnd(object.unserializableValue, "n"));
        }
        return TypeUtils.cast(value, clazz, ParserConfig.getGlobalInstance());
    }

}
