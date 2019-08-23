package jpuppeteer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.google.common.collect.Sets;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class CDPGenerator {

//    static String rootDir = "D:\\workspace\\jpuppeteer\\src\\main\\java";
    static String rootDir = "D:\\workspace\\jpuppeteer\\jpuppeteer-cdp\\src\\main\\java";
//    static String rootDir = "/Users/user/Documents/workspace/jpuppeteer/jpuppeteer-cdp/src/main/java";
    static String basePackage = "jpuppeteer.cdp.cdp";
    static String CRLF = "\r\n";
    static Map<String, Type> typeMap = new HashMap<>();
    static String connectionClassName = "jpuppeteer.cdp.CDPConnection";//CDPConnection.class.getName();
    static String sessionClassName = "jpuppeteer.cdp.CDPSession";//CDPSession.class.getName();

    public static void main(String... args) throws Exception {
        Document browserDoc = readProtocol("/browser_protocol.json");
        Document jsDoc = readProtocol("/js_protocol.json");
        if (!browserDoc.version.equals(jsDoc.version)) {
            throw new Exception("browser and js protocol not match");
        }
        browserDoc.domains.addAll(jsDoc.domains);
        System.out.println("protocol version "+browserDoc.version.major+"."+browserDoc.version.minor);
        //处理types的引用
        for(Domain domain : browserDoc.domains) {
            if (CollectionUtils.isNotEmpty(domain.types)) {
                for(Type type : domain.types) {
                    type.domain = domain;
                    typeMap.put(domain.domain + "." + type.id, type);
                }
            }
        }
        Map<String, Type> events = new LinkedHashMap<>();
        for(Domain domain : browserDoc.domains) {
            //生成type
            if (CollectionUtils.isNotEmpty(domain.types)) {
                for(Type type : domain.types) {
                    createType(domain, type);
                }
            }
            //生成接口
            createCommand(domain);
            //生成事件
            events.putAll(createEvent(domain));
        }
        createEventEnum(events);
        //生成键盘布局
//        InputStream is = CDPGenerator.class.getResourceAsStream("/USKeyboardLayout.json");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        StringBuffer sb = new StringBuffer();
//        String line;
//        while((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//        JSONObject json = JSON.parseObject(sb.toString(), Feature.OrderedField);
//        for(Map.Entry<String, Object> entry : json.entrySet()) {
//            JSONObject v = (JSONObject) entry.getValue();
//            String code = v.getString("code");
//            Integer keyCode = v.getInteger("keyCode");
//            Integer shiftKeyCode = v.getInteger("shiftKeyCode");
//            String key = v.getString("key");
//            String shiftKey = v.getString("shiftKey");
//            if (shiftKey == null) {
//                continue;
//            }
//            key = shiftKey;
//            shiftKey = null;
//            if (shiftKeyCode != null) {
//                keyCode = shiftKeyCode;
//            }
//            //shiftKeyCode = null;
//            Integer location = v.getInteger("location");
//            String l = "SHIFT_" + entry.getKey().toUpperCase();
//            l += "(";
//            l += (key != null ? "\""+ StringEscapeUtils.escapeJava(key)+"\"" : "null") + ", ";
//            l += (shiftKey != null ? "\""+StringEscapeUtils.escapeJava(shiftKey)+"\"" : "null") + ", ";
//            l += (keyCode != null ? keyCode : "null") + ", ";
//            l += (shiftKeyCode != null ? shiftKeyCode : "null") + ", ";
//            l += (code != null ? "\""+ StringEscapeUtils.escapeJava(code)+"\"" : "null") + ", ";
//            l += (location != null ? location : "null");
//            l += "),";
//            System.out.println(l);
//        }
    }

    private static void writeFile(String filename, StringBuffer sb) throws Exception {
        File java = new File(filename);
        if (java.exists()) {
            java.delete();
        }
        java.createNewFile();
        OutputStream os = new FileOutputStream(java);
        os.write(sb.toString().getBytes("UTF-8"));
        os.flush();
        os.close();
    }

    public static void createEventEnum(Map<String, Type> values) throws Exception {
        String pkg = basePackage;
        String dirName = rootDir + "/" + pkg.replace(".", "/");
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String enumClassName = "CDPEventType";
        StringBuffer sb = new StringBuffer();
        sb.append("package ");
        sb.append(pkg);
        sb.append(";");
        sb.append(CRLF);
        sb.append(CRLF);

        sb.append("public enum ");
        sb.append(enumClassName);
        sb.append(" {");
        sb.append(CRLF);
        sb.append(CRLF);
        for(Map.Entry<String, Type> entry : values.entrySet()) {
            Type clazz = entry.getValue();
            String name = entry.getKey().toUpperCase().replaceAll("[^a-zA-Z0-9_]", "_");
            if (clazz != null && StringUtils.isNotEmpty(clazz.description)) {
                sb.append("    /**");
                sb.append(CRLF);
                sb.append("    * ");
                sb.append(clazz.description.replaceAll("(\r\n|\n|\r)", " "));
                sb.append(CRLF);
                sb.append("    * @see ");
                sb.append(clazz.getPackage() + "." + clazz.id);
                sb.append(CRLF);
                sb.append("    */");
                sb.append(CRLF);
            }
            sb.append("    ");
            sb.append(name);
            sb.append("(\"");
            sb.append(entry.getKey());
            sb.append("\")");
            sb.append(",");
            sb.append(CRLF);
            sb.append(CRLF);
        }
        sb.append("    ;");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    private String value;");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    ");
        sb.append(enumClassName);
        sb.append("(String value) {");
        sb.append(CRLF);
        sb.append("        this.value = value;");
        sb.append(CRLF);
        sb.append("    }");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    public String getValue() {");
        sb.append(CRLF);
        sb.append("        return value;");
        sb.append(CRLF);
        sb.append("}");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    public static ");
        sb.append(enumClassName);
        sb.append(" findByValue(String value) {");
        sb.append(CRLF);
        sb.append("        for(");
        sb.append(enumClassName);
        sb.append(" val : values()) {");
        sb.append(CRLF);
        sb.append("            if (val.value.equals(value)) return val;");
        sb.append(CRLF);
        sb.append("        }");
        sb.append(CRLF);
        sb.append("        return null;");
        sb.append(CRLF);
        sb.append("    }");
        sb.append(CRLF);
        sb.append("}");

        writeFile(dirName + "/" + enumClassName + ".java", sb);
    }

    public static Map<String, Type> createEvent(Domain domain) throws Exception {
        if (CollectionUtils.isEmpty(domain.events)) {
            return new HashMap<>();
        }
        //生成class
        Map<String, Type> values = new LinkedHashMap<>();
        for(Event event : domain.events) {
            if (CollectionUtils.isNotEmpty(event.parameters)) {
                Type param = new Type();
                param.id = StringUtils.removeEndIgnoreCase(StringUtils.capitalize(event.name), "event") + "Event";
                param.description = event.description;
                param.properties = event.parameters;
                param.type = TypeType.OBJECT;
                param.domain = domain;
                createType(domain, param);
                values.put(domain.domain + "." + event.name, param);
            } else {
                values.put(domain.domain + "." + event.name, null);
            }
        }
        return values;
    }

    public static void createCommand(Domain domain) throws Exception {
        String pkg = basePackage + ".domain";
        String dirName = rootDir + "/" + pkg.replace(".", "/");
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        StringBuffer sb = new StringBuffer();
        //需要判断哪些是session的 哪些是不需要session的
        Set<String> withoutSessionDomain = Sets.newHashSet("Browser", "Target");

        sb.append("package ");
        sb.append(pkg);
        sb.append(";");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("/**");
        if (domain.experimental) {
            sb.append(CRLF);
            sb.append("* experimental");
        }
        sb.append(CRLF);
        sb.append("*/");
        sb.append(CRLF);
        sb.append("public class ");
        sb.append(domain.domain);
        sb.append(" {");
        sb.append(CRLF);
        sb.append(CRLF);
        //属性及构造方法

        String varName;
        if (withoutSessionDomain.contains(domain.domain)) {
            sb.append("    private ");
            sb.append(connectionClassName);
            sb.append(" connection;");
            sb.append(CRLF);
            sb.append(CRLF);
            sb.append("    public ");
            sb.append(domain.domain);
            sb.append("(");
            sb.append(connectionClassName);
            sb.append(" connection");
            sb.append(") {");
            sb.append(CRLF);
            sb.append("        this.connection = connection;");
            sb.append(CRLF);
            sb.append("    }");
            varName = "connection";
        } else {
            sb.append("    private ");
            sb.append(sessionClassName);
            sb.append(" session;");
            sb.append(CRLF);
            sb.append(CRLF);
            sb.append("    public ");
            sb.append(domain.domain);
            sb.append("(");
            sb.append(sessionClassName);
            sb.append(" session");
            sb.append(") {");
            sb.append(CRLF);
            sb.append("        this.session = session;");
            sb.append(CRLF);
            sb.append("    }");
            varName = "session";
        }
        //接口方法
        for(Command command : domain.commands) {
            sb.append(CRLF);
            sb.append(CRLF);
            sb.append("    /**");
            if (StringUtils.isNotEmpty(command.description)) {
                sb.append(CRLF);
                sb.append("    * ");
                sb.append(command.description.replaceAll("(\r\n|\n|\r)", " "));
            }
            if (domain.experimental) {
                sb.append(CRLF);
                sb.append("    * experimental");
            }
            sb.append(CRLF);
            sb.append("    */");
            sb.append(CRLF);
            sb.append("    public ");
            Type ret = null;
            if (CollectionUtils.isEmpty(command.returns)) {
                sb.append("void");
            } else {
                //生成返回值结构体
                ret = new Type();
                ret.id = StringUtils.capitalize(command.name) + "Response";
                ret.properties = command.returns;
                ret.type = TypeType.OBJECT;
                ret.domain = domain;
                createType(domain, ret);
                sb.append(ret.getPackage() + "." + ret.id);
            }
            sb.append(" ");
            sb.append(command.name);
            sb.append("(");
            //处理参数
            if (CollectionUtils.isNotEmpty(command.parameters)) {
                Type param = new Type();
                param.id = StringUtils.capitalize(command.name) + "Request";
                param.properties = command.parameters;
                param.type = TypeType.OBJECT;
                param.domain = domain;
                createType(domain, param);
                sb.append(param.getPackage() + "." + param.id + " request, ");
            }
            sb.append("int timeout");
            sb.append(")");
            sb.append(" throws Exception {");
            sb.append(CRLF);
            if (CollectionUtils.isNotEmpty(command.returns)) {
                sb.append("        return ");
                sb.append(varName);
                sb.append(".send(");
                sb.append("\"");
                sb.append(domain.domain);
                sb.append(".");
                sb.append(command.name);
                sb.append("\"");
                sb.append(", ");
                if (CollectionUtils.isNotEmpty(command.parameters)) {
                    sb.append("request, ");
                } else {
                    sb.append("null, ");
                }
                sb.append(ret.getPackage() + "." + ret.id + ".class, ");
                sb.append("timeout)");
            } else {
                sb.append("        ");
                sb.append(varName);
                sb.append(".send(");
                sb.append("\"");
                sb.append(domain.domain);
                sb.append(".");
                sb.append(command.name);
                sb.append("\"");
                sb.append(", ");
                if (CollectionUtils.isNotEmpty(command.parameters)) {
                    sb.append("request, ");
                } else {
                    sb.append("null, ");
                }
                sb.append("timeout)");
            }
            sb.append(";");
            sb.append(CRLF);
            sb.append("    }");
            sb.append(CRLF);
        }
        sb.append(CRLF);
        sb.append("}");

        writeFile(dirName + "/" + domain.domain + ".java", sb);
    }

    public static Document readProtocol(String file) throws Exception {
        InputStream is = CDPGenerator.class.getResourceAsStream(file);
        StringBuffer sb = new StringBuffer();
        byte[] bytes;
        while (true) {
            bytes = new byte[8192];
            int size = is.read(bytes);
            if (size == -1) {
                break;
            }
            sb.append(new String(bytes, 0, size));
        }
        return JSON.parseObject(sb.toString(), Document.class, Feature.DisableCircularReferenceDetect);
    }

    public static void createType(Domain domain, Type type) throws Exception {
        if (!(type.isEnum() || type.isObject())) {
            //不是枚举, 也不是类, 不需要生成
            return;
        }
        String dirName = rootDir + "/" + type.getPackage().replace(".", "/");
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        StringBuffer sb = new StringBuffer();
        sb.append("package ");
        sb.append(type.getPackage());
        sb.append(";");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("/**");
        if (StringUtils.isNotEmpty(type.description)) {
            sb.append(CRLF);
            sb.append("* ");
            sb.append(type.description.replaceAll("(\r\n|\n|\r)", " "));
        }
        if (domain.experimental) {
            sb.append(CRLF);
            sb.append("* experimental");
        }
        sb.append(CRLF);
        sb.append("*/");
        sb.append(CRLF);

        if (type.isEnum()) {
            sb.append(createEnum(domain, type));
        } else {
            sb.append(createObject(domain, type));
        }

        writeFile(dirName + "/" + type.id + ".java", sb);
    }

    public static StringBuffer createEnum(Domain domain, Type type) {
        StringBuffer sb = new StringBuffer();
        sb.append("public enum ");
        sb.append(type.id);
        sb.append(" {");
        sb.append(CRLF);
        sb.append(CRLF);
        for(String e : type.enums) {
            String name = e.toUpperCase().replaceAll("[^a-zA-Z0-9_]", "_");
            sb.append("    ");
            sb.append(name);
            sb.append("(\"");
            sb.append(e);
            sb.append("\")");
            sb.append(",");
            sb.append(CRLF);
        }
        sb.append("    ;");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    private String value;");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    ");
        sb.append(type.id);
        sb.append("(String value) {");
        sb.append(CRLF);
        sb.append("        this.value = value;");
        sb.append(CRLF);
        sb.append("    }");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    public String getValue() {");
        sb.append(CRLF);
        sb.append("        return value;");
        sb.append(CRLF);
        sb.append("}");
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("    public static ");
        sb.append(type.id);
        sb.append(" findByValue(String value) {");
        sb.append(CRLF);
        sb.append("        for(");
        sb.append(type.id);
        sb.append(" val : values()) {");
        sb.append(CRLF);
        sb.append("            if (val.value.equals(value)) return val;");
        sb.append(CRLF);
        sb.append("        }");
        sb.append(CRLF);
        sb.append("        return null;");
        sb.append(CRLF);
        sb.append("    }");
        sb.append(CRLF);
        sb.append("}");
        return sb;
    }

    public static String getType(Domain domain, Type prop, Type parent) throws Exception {
        if (prop == null) {
            throw new Exception("prop is null");
        }
        if (StringUtils.isNotEmpty(prop.ref)) {
            String[] ref = prop.ref.split("\\.");
            String pkg = ref.length == 2 ? ref[0] : domain.domain;
            String cls = ref.length == 2 ? ref[1] : ref[0];
            if (!typeMap.containsKey(pkg + "." + cls)) {
                throw new Exception("未知的引用");
            }
            return getType(domain, typeMap.get(pkg + "." + cls), prop);
        }
        switch (prop.type) {
            case OBJECT:
                if (StringUtils.isNotEmpty(prop.id) && CollectionUtils.isNotEmpty(prop.properties)) {
                    return prop.getPackage() + "." + prop.id;
                } else {
                    //对于这种情况的object统一处理为Map
                    return "java.util.Map<String, Object>";
                }
            case ARRAY:
                if (prop.items == null) {
                    throw new Exception("数组必须有items");
                }
                String typeName = "java.util.List<";
                typeName += getType(domain, prop.items, prop);
                typeName += ">";
                return typeName;
            case STRING:
                //此处存在枚举的情况
                if (CollectionUtils.isNotEmpty(prop.enums) && StringUtils.isEmpty(prop.id)) {
                    //枚举
                    if (StringUtils.isEmpty(parent.id)) {
                        throw new Exception("parent id is null");
                    }
                    Type type = new Type();
                    type.id = StringUtils.capitalize(parent.id) + StringUtils.capitalize(prop.name);
                    type.type = TypeType.STRING;
                    type.enums = prop.enums;
                    type.domain = domain;
                    createType(domain, type);
                }
                return "String";
            case ANY:
                return "Object";
            case NUMBER:
                return "Double";
            case BOOLEAN:
                return "Boolean";
            case INTEGER:
                return "Integer";
            default:
                throw new Exception("unknown type");
        }
    }

    public static StringBuffer createObject(Domain domain, Type type) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("@lombok.Setter");
        sb.append(CRLF);
        sb.append("@lombok.Getter");
        sb.append(CRLF);
        sb.append("@lombok.ToString");
        sb.append(CRLF);
        sb.append("public class ");
        sb.append(type.id);
        sb.append(" {");
        sb.append(CRLF);
        sb.append(CRLF);
        for(Type prop : type.properties) {
            sb.append("    /**");
            if (StringUtils.isNotEmpty(prop.description)) {
                sb.append(CRLF);
                sb.append("    * ");
                sb.append(prop.description.replaceAll("(\r\n|\n|\r)", " "));
            }
            sb.append(CRLF);
            sb.append("    */");
            sb.append(CRLF);
            sb.append("    private ");
            sb.append(getType(domain, prop, type));
            sb.append(" ");
            sb.append(prop.name.equals("this") ? "self" : prop.name);
            sb.append(";");
            sb.append(CRLF);
            sb.append(CRLF);
        }
        sb.append(CRLF);
        sb.append(CRLF);
        sb.append("}");
        return sb;
    }

    public static class Document {
        public Version version;
        public List<Domain> domains;
    }

    @EqualsAndHashCode(of = {"major", "minor"})
    public static class Version {
        public String major;
        public String minor;
    }

    public static class Domain {

        public String domain;

        public boolean experimental;

        public List<String> dependencies;

        public List<Type> types;

        public List<Command> commands;

        public List<Event> events;

    }

    public static class Event {

        public String name;

        public String description;

        public List<Type> parameters;

    }

    public static class Command {

        public String name;

        public String description;

        public boolean experimental;

        public List<Type> parameters;

        public List<Type> returns;

    }

    public static class Type {

        public Domain domain;

        public String id;

        public String name;

        public String description;

        public TypeType type;

        private String ref;

        @JSONField(name = "enum")
        public List<String> enums;

        public Type items;

        public List<Type> properties;

        @JSONField(name = "type")
        public void setType(String type) {
            this.type = TypeType.find(type);
        }

        @JSONField(name = "$ref")
        public void setRef(String ref) {
            this.ref = ref;
        }

        public boolean isEnum() {
            return TypeType.STRING.equals(type) && CollectionUtils.isNotEmpty(enums);
        }

        public boolean isObject() {
            return TypeType.OBJECT.equals(type) && CollectionUtils.isNotEmpty(properties);
        }

        public String getPackage() {
            return basePackage + "." + (isEnum() ? "constant" : "entity") + "." + domain.domain.toLowerCase();
        }
    }

    public enum TypeType {

        STRING, OBJECT, BOOLEAN, ANY, ARRAY, NUMBER, INTEGER

        ;

        static TypeType find(String value) {
            for(TypeType type : values()) {
                if (type.name().equalsIgnoreCase(value)) {
                    return type;
                }
            }
            return null;
        }
    }

}
