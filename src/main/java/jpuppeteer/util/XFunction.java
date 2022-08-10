package jpuppeteer.util;

public interface XFunction<T, R> {

    R apply(Series series, T t);
}
