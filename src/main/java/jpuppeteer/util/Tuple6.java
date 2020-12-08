package jpuppeteer.util;

public class Tuple6<A, B, C, D, E, F> extends Tuple5<A, B, C, D, E> {

    public Tuple6() {
        super(6);
    }

    protected Tuple6(int size) {
        super(size);
    }

    public void setF(F f) {
        set(5, f);
    }

    public F getF() {
        return get(5);
    }
}
