package jpuppeteer.util;

public class Tuple2<A, B> extends Tuple1<A> {

    public Tuple2() {
        super(2);
    }

    protected Tuple2(int size) {
        super(size);
    }

    public void setB(B b) {
        set(1, b);
    }

    public B getB() {
        return get(1);
    }
}
