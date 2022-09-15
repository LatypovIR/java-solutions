package expression;

import expression.handler.Handler;

public class Mod extends BinaryOperator {
    public Mod(Operator operator1, Operator operator2) {
        super(operator1, operator2);
    }

    @Override
    public String getOperator() {
        return "mod";
    }

    @Override
    public <T> T calc(T x, T y, Handler<T> handler) {
        return handler.mod(x, y);
    }

    @Override
    public int getPriority() {
        return 2 << 26;
    }
}
