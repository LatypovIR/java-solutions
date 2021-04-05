package expression;

import expression.handler.Handler;

public class Subtract extends BinaryOperator {

    public Subtract(Operator operator1, Operator operator2) {
        super(operator1, operator2);
    }

    @Override
    public String getOperator() {
        return "-";
    }

    @Override
    public int getPriority() {
        return 1 << 26;
    }

    @Override
    public boolean isReverseOperator() {
        return true;
    }

    @Override
    public <T> T calc(T x, T y, Handler<T> handler) {
        return handler.sub(x, y);
    }
}
