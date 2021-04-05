package expression;

import expression.handler.Handler;

public abstract class BinaryOperator implements Operator {

    private final Operator operator1, operator2;

    public BinaryOperator(final Operator operator1, final Operator operator2) {
        this.operator1 = operator1;
        this.operator2 = operator2;
    }

    public abstract String getOperator();

    public abstract <T> T calc(final T x, final T y, final Handler<T> handler);

    public boolean isReverseOperator() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("(%s %s %s)", operator1.toString(), getOperator(), operator2.toString());
    }

    @Override
    public String toMiniString() {
        return String.format("%s %s %s", toMiniStringLeft(), getOperator(), toMiniStringRight());
    }

    private String toMiniStringLeft() {
        if (operator1.getPriority() < getPriority()) {
            return String.format("(%s)", operator1.toMiniString());
        }
        return operator1.toMiniString();
    }

    private String toMiniStringRight() {
        if (operator2.getPriority() < getPriority()) {
            return String.format("(%s)", operator2.toMiniString());
        } else if (operator2.getPriority() > getPriority()) {
            return operator2.toMiniString();
        }
        if (isReverseOperator() || operator2 instanceof Divide) {
            return String.format("(%s)", operator2.toMiniString());
        }
        return operator2.toMiniString();
    }

    @Override
    public <T> T evaluate(final T x, final T y, final T z, final Handler<T> handler) {
        return calc(operator1.evaluate(x, y, z, handler), operator2.evaluate(x, y, z, handler), handler);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BinaryOperator that = (BinaryOperator) object;
        return operator1.equals(that.operator1) && operator2.equals(that.operator2);
    }

    @Override
    public int hashCode() {
        return operator1.hashCode() * operator2.hashCode() * getOperator().hashCode();
    }
}
