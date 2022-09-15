package expression;

import expression.handler.Handler;

public class Abs extends UnaryOperator {

    public Abs(Operator operator) {
        super(operator);
    }

    @Override
    public <T> T calc(T a, Handler<T> handler) {
        return handler.abs(a);
    }

    @Override
    public String getOperator() {
        return "abs";
    }
}
