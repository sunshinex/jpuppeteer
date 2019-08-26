package jpuppeteer.chrome;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import jpuppeteer.api.browser.BrowserObject;
import jpuppeteer.api.browser.ExecutionContext;
import jpuppeteer.cdp.cdp.constant.runtime.RemoteObjectSubtype;
import jpuppeteer.cdp.cdp.constant.runtime.RemoteObjectType;
import jpuppeteer.cdp.cdp.domain.Runtime;
import jpuppeteer.cdp.cdp.entity.runtime.*;
import jpuppeteer.chrome.util.ArgUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeBrowserObject implements BrowserObject {

    private static final String NEGATIVE_ZERO = "-0";

    private static final String NAN = "NaN";

    private static final String INFINITY = "Infinity";

    private static final String NEGATIVE_INFINITY = "-Infinity";

    protected Runtime runtime;

    protected ChromeExecutionContext executionContext;

    protected String objectId;

    protected RemoteObjectType type;

    protected RemoteObjectSubtype subType;

    protected RemoteObject object;

    public ChromeBrowserObject(Runtime runtime, ChromeExecutionContext executionContext, RemoteObject object) {
        this.runtime = runtime;
        this.executionContext = executionContext;
        this.objectId = object.getObjectId();
        this.type = RemoteObjectType.findByValue(object.getType());
        this.subType = RemoteObjectSubtype.findByValue(object.getSubtype());
        this.object = object;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public ExecutionContext executionContext() {
        return executionContext;
    }

    @Override
    public List<ChromeBrowserObject> getProperties() throws Exception {
        GetPropertiesRequest request = new GetPropertiesRequest();
        request.setObjectId(objectId);
        request.setOwnProperties(true);
        GetPropertiesResponse response = runtime.getProperties(request, DEFAULT_TIMEOUT);
        if (response.getExceptionDetails() != null) {
            throw new Exception(response.getExceptionDetails().getException().getDescription());
        }
        List<ChromeBrowserObject> objects = new ArrayList<>(response.getResult().size());
        for (PropertyDescriptor descriptor : response.getResult()) {
            if (!descriptor.getEnumerable()) {
                continue;
            }
            objects.add(new ChromeBrowserObject(runtime, executionContext, descriptor.getValue()));
        }
        return objects;
    }

    @Override
    public ChromeBrowserObject getProperty(String name) throws Exception {
        CallArgument object = ArgUtils.createFromObjectId(objectId);
        CallArgument prop = ArgUtils.createFromValue(name);
        return executionContext.evaluate(
                "function(object, prop){return object[prop];}",
                object, prop
                );
    }

    @Override
    public void release() throws Exception {
        ReleaseObjectRequest request = new ReleaseObjectRequest();
        request.setObjectId(objectId);
        runtime.releaseObject(request, DEFAULT_TIMEOUT);
    }

    @Override
    public Object get() {
        if (object.getValue() != null) {
            return object.getValue();
        }
        String origin = object.getUnserializableValue();
        if (NEGATIVE_ZERO.equals(origin)) {
            return -0;
        } else if (origin == null || NAN.equals(origin) || INFINITY.equals(origin) || NEGATIVE_INFINITY.equals(origin)) {
            //解析不了的数字, 正无穷, 负无穷 全部返回null
            return null;
        } else {
            //BigInt
            return new BigInteger(StringUtils.removeEnd(origin, "n"));
        }
    }

    @Override
    public Boolean getBoolean() {
        return TypeUtils.castToBoolean(get());
    }

    @Override
    public boolean getBooleanValue() {
        Boolean value = getBoolean();
        return value != null ? value.booleanValue() : false;
    }

    @Override
    public Short getShort() {
        return TypeUtils.castToShort(get());
    }

    @Override
    public short getShortValue() {
        Short value = getShort();
        return value != null ? value.shortValue() : 0;
    }

    @Override
    public Integer getInteger() {
        return TypeUtils.castToInt(get());
    }

    @Override
    public int getIntValue() {
        Integer value = getInteger();
        return value != null ? value.intValue() : 0;
    }

    @Override
    public Long getLong() {
        return TypeUtils.castToLong(get());
    }

    @Override
    public long getLongValue() {
        Long value = getLong();
        return value != null ? value.longValue() : 0;
    }

    @Override
    public Float getFloat() {
        return TypeUtils.castToFloat(get());
    }

    @Override
    public float getFloatValue() {
        Float value = getFloat();
        return value != null ? value.floatValue() : 0;
    }

    @Override
    public Double getDouble() {
        return TypeUtils.castToDouble(get());
    }

    @Override
    public double getDoubleValue() {
        Double value = getDouble();
        return value != null ? value.doubleValue() : 0;
    }

    @Override
    public BigDecimal getBigDecimal() {
        return TypeUtils.castToBigDecimal(get());
    }

    @Override
    public BigInteger getBigInteger() {
        return TypeUtils.castToBigInteger(get());
    }

    @Override
    public String getString() {
        return TypeUtils.castToString(get());
    }

    @Override
    public Date getDate() {
        return TypeUtils.castToDate(get());
    }

    @Override
    public <T> T getObject(Class<T> clazz) {
        Object value = get();
        if (value == null) {
            return null;
        }
        return TypeUtils.cast(get(), clazz, ParserConfig.getGlobalInstance());
    }

    @Override
    public <T> T getObject(TypeReference<T> type) {
        Object value = get();
        if (value == null) {
            return null;
        }
        return TypeUtils.cast(get(), type.getType(), ParserConfig.getGlobalInstance());
    }
}
