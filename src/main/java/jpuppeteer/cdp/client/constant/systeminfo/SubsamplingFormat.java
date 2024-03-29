package jpuppeteer.cdp.client.constant.systeminfo;

/**
* YUV subsampling type of the pixels of a given image.
* experimental
*/
public enum SubsamplingFormat implements jpuppeteer.cdp.client.CDPEnum {

    YUV420("yuv420"),
    YUV422("yuv422"),
    YUV444("yuv444"),
    ;

    private String value;

    SubsamplingFormat(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static SubsamplingFormat findByValue(String value) {
        for(SubsamplingFormat val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}