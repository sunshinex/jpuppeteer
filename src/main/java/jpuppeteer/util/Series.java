package jpuppeteer.util;

import java.util.List;

@SuppressWarnings({"unchecked"})
public class Series {

    private final Object EMPTY = new Object();

    final List<Object> results;

    final int resultIndex;

    Series(List<Object> results, int resultIndex) {
        this.results = results;
        this.resultIndex = resultIndex;
    }

    public <T> T get(int index) {
        Object result = results.get(index);
        if (result == null || result == EMPTY) {
            return null;
        }
        return (T) result;
    }

    public <T> T get() {
        return get(resultIndex);
    }

    void set(int index, Object result) {
        if (result == null) {
            result = EMPTY;
        }
        results.add(index, result);
    }

    void set(Object result) {
        set(resultIndex, result);
    }

    public int size() {
        return this.results.size();
    }

    public int position() {
        return this.resultIndex;
    }
}
