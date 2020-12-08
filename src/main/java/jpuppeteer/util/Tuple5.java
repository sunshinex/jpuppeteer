package jpuppeteer.util;

public class Tuple5<A, B, C, D, E> extends Tuple4<A, B, C, D> {

    public Tuple5() {
        super(5);
    }

    protected Tuple5(int size) {
        super(size);
    }

    public void setE(E e) {
        set(4, e);
    }

    public E getE() {
        return get(4);
    }
}
