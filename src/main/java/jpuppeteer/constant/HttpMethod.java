package jpuppeteer.constant;

public enum HttpMethod {

    OPTIONS("options"),
    GET("get"),
    HEAD("head"),
    POST("post"),
    PUT("put"),
    PATCH("patch"),
    DELETE("delete"),
    TRACE("trace"),
    CONNECT("connect"),
    ;

    private final String value;

    HttpMethod(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static HttpMethod findByValue(String value) {
        if (value == null) {
            return null;
        }
        String lowerValue = value.toLowerCase();
        for(HttpMethod method : values()) {
            if (lowerValue.equals(method.value)) {
                return method;
            }
        }
        return null;
    }
}
