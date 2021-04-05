package expression;

import expression.handler.Handler;

public class Square extends UnaryOperator {

    public Square(Operator operator) {
        super(operator);
    }

    @Override
    public <T> T calc(T a, Handler<T> handler) {
        return handler.sqr(a);
    }

    @Override
    public String getOperator() {
        return "square";
    }
}
