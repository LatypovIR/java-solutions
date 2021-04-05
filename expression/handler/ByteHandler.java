package expression.handler;

import expression.exceptions.DivisionByZero;

public class ByteHandler implements Handler<Byte> {
    @Override
    public Byte parseValue(final String value) {
        return Byte.parseByte(value);
    }

    @Override
    public Byte valueOf(final int a) {
        return (byte) a;
    }

    @Override
    public Byte sum(final Byte a, final Byte b) {
        return (byte)(a + b);
    }

    @Override
    public Byte sub(final Byte a, final Byte b) {
        return (byte)(a - b);
    }

    @Override
    public Byte multiply(final Byte a, final Byte b) {
        return (byte)(a * b);
    }

    @Override
    public Byte divide(final Byte a, final Byte b) throws DivisionByZero {
        if (b == 0) {
            throw new DivisionByZero("divide in ByteHandler");
        }
        return (byte)(a / b);
    }

    @Override
    public Byte mod(final Byte a, final Byte b) {
        if (b == 0) {
            throw new DivisionByZero("mod in ByteHandler");
        }
        return (byte)(a % b);
    }

    @Override
    public Byte negative(final Byte a) {
        return (byte)(-a);
    }

    @Override
    public Byte abs(final Byte a) {
        return (byte)(a < 0 ? -a : a);
    }

    @Override
    public Byte sqr(final Byte a) {
        return (byte)(a * a);
    }
}
