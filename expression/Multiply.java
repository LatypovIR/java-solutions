package expression;

import expression.handler.Handler;

public class Multiply extends BinaryOperator {

    public Multiply(Operator operator1, Operator operator2) {
        super(operator1, operator2);
    }

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 2 << 26;
    }

    @Override
    public <T> T calc(T x, T y, Handler<T> handler) {
        return handler.multiply(x, y);
    }
}