package expression;

import expression.handler.Handler;

public class Add extends BinaryOperator {

    public Add(final Operator operator1, final Operator operator2) {
        super(operator1, operator2);
    }

    @Override
    public String getOperator() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 1 << 26;
    }

    @Override
    public <T> T calc(T x, T y, Handler<T> handler) {
        return handler.sum(x, y);
    }
}
