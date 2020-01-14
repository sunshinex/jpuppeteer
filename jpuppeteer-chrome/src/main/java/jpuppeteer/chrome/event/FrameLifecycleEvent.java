package jpuppeteer.chrome.event;

import jpuppeteer.chrome.ChromeFrame;
import jpuppeteer.chrome.constant.LifecycleEventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class FrameLifecycleEvent {

    private LifecycleEventType type;

    private ChromeFrame frame;

}
