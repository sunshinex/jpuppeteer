package jpuppeteer.api.browser;

import com.alibaba.fastjson.TypeReference;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface BrowserObject {

    ExecutionContext executionContext();

    List<? extends BrowserObject> getProperties() throws Exception;

    BrowserObject getProperty(String name) throws Exception;

    void release() throws Exception;

    /**
     * 原始值
     * @return
     */
    Object get();

    Boolean getBoolean();

    boolean getBooleanValue();

    Short getShort();

    short getShortValue();

    Integer getInteger();

    int getIntValue();

    Long getLong();

    long getLongValue();

    Float getFloat();

    float getFloatValue();

    Double getDouble();

    double getDoubleValue();

    BigDecimal getBigDecimal();

    BigInteger getBigInteger();

    String getString();

    Date getDate();

    <T> T getObject(Class<T> clazz);

    <T> T getObject(TypeReference<T> type);

}
