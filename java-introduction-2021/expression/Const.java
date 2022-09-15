package expression;

import expression.handler.Handler;

public class Const implements Operator {

    private final String value;

    public Const(final String c) {
        value = c;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public <T> T evaluate(T x, T y, T z, Handler<T> handler) {
        return handler.parseValue(value);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Const aConst = (Const) object;
        return value.equals(aConst.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
