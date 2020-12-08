package jpuppeteer.util;

public class Tuple3<A, B, C> extends Tuple2<A, B> {

    public Tuple3() {
        super(3);
    }

    protected Tuple3(int size) {
        super(size);
    }

    public void setC(C c) {
        set(2, c);
    }

    public C getC() {
        return get(2);
    }
}
