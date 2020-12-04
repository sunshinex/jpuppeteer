package jpuppeteer.entity;

import jpuppeteer.api.HttpHeader;

public class BasicHttpHeader implements HttpHeader {

    private final String name;

    private final String value;

    public BasicHttpHeader(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return name + "=" + value;
    }
}
