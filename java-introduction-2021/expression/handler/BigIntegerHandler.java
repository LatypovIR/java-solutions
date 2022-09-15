package expression.handler;

import expression.exceptions.DivisionByZero;

import java.math.BigInteger;

public class BigIntegerHandler implements Handler<BigInteger> {
    @Override
    public BigInteger parseValue(final String value) {
        return new BigInteger(value);
    }

    @Override
    public BigInteger valueOf(final int a) {
        return BigInteger.valueOf(a);
    }

    @Override
    public BigInteger sum(final BigInteger a, final BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger sub(final BigInteger a, final BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger multiply(final BigInteger a, final BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger divide(final BigInteger a, final BigInteger b) throws DivisionByZero {
        if (b.equals(BigInteger.ZERO)) {
            throw new DivisionByZero("divide in BigIntegerHandle");
        }
        return a.divide(b);
    }

    @Override
    public BigInteger mod(final BigInteger a, final BigInteger b) throws DivisionByZero {
        if (b.compareTo(BigInteger.ZERO) <= 0) {
            throw new DivisionByZero("mod in BigIntegerHandle");
        }
        return a.mod(b.abs());
    }

    @Override
    public BigInteger negative(final BigInteger a) {
        return a.negate();
    }

    @Override
    public BigInteger abs(final BigInteger a) {
        return a.abs();
    }

    @Override
    public BigInteger sqr(final BigInteger a) {
        return multiply(a, a);
    }
}
