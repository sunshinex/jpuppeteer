package jpuppeteer.httpclient.condition;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractRequestCondition<T extends AbstractRequestCondition<T>> implements RequestCondition<T> {

    public boolean isEmpty() {
        return getContent().isEmpty();
    }

    protected abstract Collection<?> getContent();

    protected abstract String getToStringInfix();


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return getContent().equals(((AbstractRequestCondition<?>) other).getContent());
    }

    @Override
    public int hashCode() {
        return getContent().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (Iterator<?> iterator = getContent().iterator(); iterator.hasNext();) {
            Object expression = iterator.next();
            builder.append(expression.toString());
            if (iterator.hasNext()) {
                builder.append(getToStringInfix());
            }
        }
        builder.append("]");
        return builder.toString();
    }

}
