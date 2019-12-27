package jpuppeteer.chrome.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class RequestFinished {

    private String requestId;

    //可能会没有request, request不会一直保存, 当进行垃圾回收的时候 会释放request
    private Request request;

    private Double encodedDataLength;

    private Boolean shouldReportCorbBlocking;
}
