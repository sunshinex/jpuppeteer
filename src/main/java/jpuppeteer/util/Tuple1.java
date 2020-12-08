package jpuppeteer.util;

public class Tuple1<A> extends Tuple {

    public Tuple1() {
        super(1);
    }

    protected Tuple1(int size) {
        super(size);
    }

    public void setA(A a) {
        set(0, a);
    }

    public A getA() {
        return get(0);
    }
}
