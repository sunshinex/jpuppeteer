package jpuppeteer.constant;

import jpuppeteer.cdp.client.CDPEnum;

public enum HttpMethod implements CDPEnum {

    OPTIONS("OPTIONS"),
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE"),
    TRACE("TRACE"),
    CONNECT("CONNECT"),
    ;

    private final String value;

    HttpMethod(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static HttpMethod findByValue(String value) {
        if (value == null) {
            return null;
        }
        String lowerValue = value.toUpperCase();
        for(HttpMethod method : values()) {
            if (lowerValue.equals(method.value)) {
                return method;
            }
        }
        return null;
    }
}
