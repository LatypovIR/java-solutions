package expression.handler;

public class DoubleHandler implements Handler<Double> {
    @Override
    public Double parseValue(final String value) {
        return Double.parseDouble(value);
    }

    @Override
    public Double valueOf(final int a) {
        return (double) a;
    }

    @Override
    public Double sum(final Double a, final Double b) {
        return a + b;
    }

    @Override
    public Double sub(final Double a, final Double b) {
        return a - b;
    }

    @Override
    public Double multiply(final Double a, final Double b) {
        return a * b;
    }

    @Override
    public Double divide(final Double a, final Double b) {
        return a / b;
    }

    @Override
    public Double mod(final Double a, final Double b) {
        return a % b;
    }

    @Override
    public Double negative(final Double a) {
        return -a;
    }

    @Override
    public Double abs(final Double a) {
        return a < 0 ? -a : a;
    }

    @Override
    public Double sqr(final Double a) {
        return a * a;
    }
}
