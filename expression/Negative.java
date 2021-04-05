package expression;

import expression.handler.Handler;

public class Negative extends UnaryOperator {

    public Negative(Operator operator) {
        super(operator);
    }

    @Override
    public <T> T calc(T a, Handler<T> handler) {
        return handler.negative(a);
    }

    @Override
    public String getOperator() {
        return "-";
    }
}
