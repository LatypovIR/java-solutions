package expression;

import expression.handler.Handler;

public interface GenericTripleExpression extends ToMiniString {
    <T> T evaluate(T x, T y, T z, Handler<T> handler);
}