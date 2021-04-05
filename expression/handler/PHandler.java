package expression.handler;

import expression.exceptions.DivisionByZero;

public class PHandler extends IntegerHandler {

    public static final int MOD = 1009;
    public static final int[] REVERSES = new int[MOD];

    static {
        for (int i = 0; i < MOD; i++) {
            REVERSES[i] = pow(i, MOD - 2);
        }
    }

    public static int pow(final int x, final int y) {
        if (y == 0) {
            return 1;
        }
        int ans = pow(x, y / 2);
        ans = mod (ans * ans);
        if (y % 2 == 1) {
            ans = mod(ans * x);
        }
        return ans;
    }

    @Override
    public Integer parseValue(final String value) {
        return mod(super.parseValue(value));
    }

    @Override
    public Integer valueOf(final int a) {
        return mod(super.valueOf(a));
    }

    @Override
    public Integer sum(final Integer a, final Integer b) {
        return mod(super.sum(a, b));
    }

    @Override
    public Integer sub(final Integer a, final Integer b) {
        return mod(super.sub(a, b));
    }

    @Override
    public Integer multiply(final Integer a, final Integer b) {
        return mod(super.multiply(a, b));
    }

    @Override
    public Integer divide(final Integer a, final Integer b) throws DivisionByZero {
        if (b == 0) {
            throw new DivisionByZero("divide in PHandler");
        }
        return multiply(a, REVERSES[b]);
    }

    @Override
    public Integer mod(final Integer a, final Integer b) {
        return mod(super.mod(a, b));
    }

    @Override
    public Integer negative(final Integer a) {
        return mod(super.negative(a));
    }

    @Override
    public Integer abs(final Integer a) {
        return mod(super.abs(a));
    }

    @Override
    public Integer sqr(final Integer a) {
        return mod(super.sqr(a));
    }

    private static Integer mod(final int a) {
        return (MOD + a % MOD) % MOD;
    }
}

