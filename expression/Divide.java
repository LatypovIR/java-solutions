package expression;

import expression.handler.Handler;

public class Divide extends BinaryOperator {

    public Divide(Operator operator1, Operator operator2) {
        super(operator1, operator2);
    }

    @Override
    public String getOperator() {
        return "/";
    }

    @Override
    public int getPriority() {
        return 2 << 26;
    }

    @Override
    public boolean isReverseOperator() {
        return true;
    }

    @Override
    public <T> T calc(T x, T y, Handler<T> handler) {
        return handler.divide(x, y);
    }
}
