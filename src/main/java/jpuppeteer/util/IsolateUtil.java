package jpuppeteer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import jpuppeteer.api.BrowserObject;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectSubtype;
import jpuppeteer.cdp.client.constant.runtime.RemoteObjectType;
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
            if (StringUtils.isNotEmpty(exceptionDetails.getText())) {
                error = exceptionDetails.getText();
            }
            if (exceptionDetails.getException() != null && StringUtils.isNotEmpty(exceptionDetails.getException().getDescription())) {
                error = exceptionDetails.getException().getDescription();
            }
            throw new ExecutionException(error, exceptionDetails.getStackTrace());
        }
    }

    public static EvaluateRequest buildEvaluateRequest(String expression, Integer isolateId, boolean returnValue, Integer timeout, String uniqueId) {
        BigDecimal tmOut = timeout != null ? BigDecimal.valueOf(timeout) : null;
        EvaluateRequest request = new EvaluateRequest();
        request.setExpression(expression);
        if (uniqueId != null) {
            request.setUniqueContextId(uniqueId);
        } else {
            request.setContextId(isolateId);
        }
        request.setReturnByValue(returnValue);
        request.setTimeout(tmOut);
        request.setIncludeCommandLineAPI(true);
        request.setSilent(true);
        request.setGeneratePreview(false);
        request.setUserGesture(true);
        request.setAwaitPromise(true);
        request.setThrowOnSideEffect(false);
        request.setDisableBreaks(true);
        request.setReplMode(true);

        return request;
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

    private static JsonNode remoteObjectToJson(RemoteObject object) {
        if (object.getObjectId() != null) {
            //对于objectId存在的，直接返回空
            return null;
        }
        Object value = object.getValue();
        if (RemoteObjectType.OBJECT.equals(object.getType()) &&
                RemoteObjectSubtype.DATE.equals(object.getSubtype())) {
            value = null;
        } else if (RemoteObjectType.NUMBER.equals(object.getType()) && StringUtils.isNotEmpty(object.getUnserializableValue())) {
            if (NEGATIVE_ZERO.equals(object.getUnserializableValue())) {
                value = -0;
            } else {
                value = null;
            }
        } else if (RemoteObjectType.BIGINT.equals(object.getType())) {
            value = new BigInteger(StringUtils.removeEnd(object.getUnserializableValue(), "n"));
        }
        return JacksonUtil.INSTANCE.valueToTree(value);
    }

    public static <R> R remoteObjectToValue(RemoteObject object, Class<R> clazz) {
        try {
            JsonNode node = remoteObjectToJson(object);
            return JacksonUtil.INSTANCE.treeToValue(node, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Object to JavaObject `"+clazz.getName()+"` failed", e);
        }
    }

    public static <R> R remoteObjectToValue(RemoteObject object, JavaType type) {
        try {
            JsonNode node = remoteObjectToJson(object);
            return JacksonUtil.INSTANCE.treeToValue(node, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Object to JavaType `"+type.toString()+"` failed", e);
        }
    }

}
