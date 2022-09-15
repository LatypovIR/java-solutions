package expression.handler;

import expression.exceptions.DivisionByZero;
import expression.exceptions.OverflowException;

public class CheckedIntegerHandler extends IntegerHandler {

    public static boolean checkMul(final int a, final int b) {
        if (a > 0) {
            return Integer.MIN_VALUE / a > b || Integer.MAX_VALUE / a < b;
        }
        if (b > 0) {
            return Integer.MIN_VALUE / b > a;
        }
        return a != 0 && Integer.MAX_VALUE / a > b;
    }

    @Override
    public Integer sum(final Integer a, final Integer b) throws OverflowException {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b) {
            throw new OverflowException("sum in CheckedIntegerHandler");
        }
        if (a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            throw new OverflowException("sum in CheckedIntegerHandler");
        }
        return super.sum(a, b);
    }

    @Override
    public Integer sub(final Integer a, final Integer b) throws OverflowException {
        if (a >= 0 && b <= 0 && a > Integer.MAX_VALUE + b) {
            throw new OverflowException("subtract in CheckedIntegerHandler");
        }
        if (a <= 0 && b >= 0 && a < Integer.MIN_VALUE + b) {
            throw new OverflowException("subtract in CheckedIntegerHandler");
        }
        return super.sub(a, b);
    }

    @Override
    public Integer multiply(final Integer a, final Integer b) throws OverflowException {
        if (checkMul(a, b)) {
            throw new OverflowException("multiply in CheckedIntegerHandler");
        }
        return super.multiply(a, b);
    }

    @Override
    public Integer divide(final Integer a, final Integer b) throws DivisionByZero {
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new DivisionByZero("divide in CheckedIntegerHandler");
        }
        return super.divide(a, b);
    }

    @Override
    public Integer negative(final Integer a) throws OverflowException {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException("negative in CheckedIntegerHandler");
        }
        return super.negative(a);
    }

    @Override
    public Integer abs(Integer a) {
        return a < 0 ? negative(a) : a;
    }

    @Override
    public Integer sqr(Integer a) {
        return multiply(a, a);
    }
}
