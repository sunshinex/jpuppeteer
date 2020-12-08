package jpuppeteer.util;

public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {

    public Tuple4() {
        super(4);
    }

    protected Tuple4(int size) {
        super(size);
    }

    public void setD(D d) {
        set(3, d);
    }

    public D getD() {
        return get(3);
    }
}
