package jpuppeteer.util;

public class Tuple {

    private final Object[] values;

    protected Tuple(int size) {
        this.values = new Object[size];
    }

    private void checkBound(int i) {
        if (i < 0 || i >= values.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void set(int i, Object value) {
        checkBound(i);
        this.values[i] = value;
    }

    @SuppressWarnings("unchecked")
    public <V> V get(int i) {
        checkBound(i);
        return (V) this.values[i];
    }

}
