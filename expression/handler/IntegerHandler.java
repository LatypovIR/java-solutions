package expression.handler;

import expression.exceptions.DivisionByZero;

public class IntegerHandler implements Handler<Integer> {

    @Override
    public Integer parseValue(final String value) {
        return Integer.parseInt(value);
    }

    @Override
    public Integer valueOf(final int a) {
        return a;
    }

    @Override
    public Integer sum(final Integer a, final Integer b) {
        return a + b;
    }

    @Override
    public Integer sub(final Integer a, final Integer b) {
        return a - b;
    }

    @Override
    public Integer multiply(final Integer a, final Integer b) {
        return a * b;
    }

    @Override
    public Integer divide(final Integer a, final Integer b) throws DivisionByZero {
        if (b == 0) {
            throw new DivisionByZero("divide in IntegerHandler");
        }
        return a / b;
    }

    @Override
    public Integer mod(final Integer a, final Integer b) {
        if (b == 0) {
            throw new DivisionByZero("mod in IntegerHandler");
        }
        return a % b;
    }

    @Override
    public Integer negative(final Integer a) {
        return -a;
    }

    @Override
    public Integer abs(final Integer a) {
        return a < 0 ? -a : a;
    }

    @Override
    public Integer sqr(final Integer a) {
        return a * a;
    }
}
