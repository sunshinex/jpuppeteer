package jpuppeteer.api.event;

public class Events extends AbstractEventEmitter<Events.BrowserEvent> {

    public static void main(String[] args) {
        Events events = new Events();
        events.addListener(BrowserEvent.A, (String evt) -> {
            System.out.println(evt);
        });
        events.emit(BrowserEvent.A, "test");
    }

    enum BrowserEvent {
        A, B;

        static BrowserEvent create() throws IllegalAccessException, InstantiationException {
            return BrowserEvent.class.newInstance();
        }
    }

}
