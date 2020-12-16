package jpuppeteer.util;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

public class CDPParserConfig extends ParserConfig {

    public CDPParserConfig() {
        super();
    }

    public CDPParserConfig(boolean fieldBase) {
        super(fieldBase);
    }

    public CDPParserConfig(ClassLoader parentClassLoader) {
        super(parentClassLoader);
    }

    public CDPParserConfig(ASMDeserializerFactory asmFactory) {
        super(asmFactory);
    }

    @Override
    public ObjectDeserializer getDeserializer(Class<?> clazz, Type type) {
        ObjectDeserializer deserializer = super.getDeserializer(clazz, type);
        if (deserializer instanceof EnumDeserializer) {
            deserializer = new CDPEnumDeserializer(deserializer);
        }
        return deserializer;
    }
}
