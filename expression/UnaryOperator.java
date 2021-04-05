package expression;

import expression.handler.Handler;

public abstract class UnaryOperator implements Operator {

    private final Operator operator;

    public UnaryOperator(Operator operator) {
        this.operator = operator;
    }

    public abstract <T> T calc(T a, Handler<T> handler);

    public abstract String getOperator();

    @Override
    public <T> T evaluate(T x, T y, T z, Handler<T> handler) {
        return calc(operator.evaluate(x, y, z, handler), handler);
    }

    @Override
    public String toString() {
        return getOperator() + " ( " + operator.toString() + " )";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UnaryOperator that = (UnaryOperator) object;
        return operator.equals(that.operator);
    }

    @Override
    public int hashCode() {
        return operator.hashCode() * getOperator().hashCode();
    }
}
