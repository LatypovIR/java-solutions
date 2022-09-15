package expression.generic;

import expression.GenericTripleExpression;
import expression.exceptions.ArithmeticException;
import expression.exceptions.IncorrectInput;
import expression.exceptions.ParseException;
import expression.handler.*;
import expression.parser.ExceptionParser;

import java.util.Map;

public class GenericTabulator implements Tabulator {

    public static final Map<String, Handler<?>> TAGS = Map.of(
            "i", new CheckedIntegerHandler(),
            "d", new DoubleHandler(),
            "bi", new BigIntegerHandler(),
            "u", new IntegerHandler(),
            "p", new PHandler(),
            "b", new ByteHandler()

    );

    public static void main(final String[] args) {
        if (args.length != 2 || args[0].length() == 0) {
            System.out.println("Incorrect args!");
            return;
        }
        args[0] = args[0].substring(1);

        if (!TAGS.containsKey(args[0])) {
            System.out.println("Incorrect first arg!");
            return;
        }

        final int range = 2;
        final Tabulator tabulator = new GenericTabulator();
        final Object[][][] result;
        try {
            result = tabulator.tabulate(args[0], args[1], -range, range, -range, range, -range, range);
        } catch (final Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        for (final Object[][] objects : result) {
            for (final Object[] object : objects) {
                for (final Object o : object) {
                    System.out.print(o + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    @Override
    public Object[][][] tabulate(final String mode, final String expression, final int x1, final int x2, final int y1, final int y2, final int z1, final int z2) throws ParseException {
        return solve(expression, x1, x2, y1, y2, z1, z2, TAGS.getOrDefault(mode, null));
    }

    private static <T> Object[][][] solve(final String expression, final int x1, final int x2, final int y1, final int y2, final int z1, final int z2, final Handler<T> handler) throws ParseException {
        if (x2 < x1 || y2 < y1 || z2 < z1) {
            return new Object[0][0][0];
        }

        if (handler == null) {
            throw new IncorrectInput("Incorrect mode!");
        }

        final GenericTripleExpression operator = new ExceptionParser(expression).parse();
        final Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    try {
                        result[x - x1][y - y1][z - z1] = operator.evaluate(
                                handler.valueOf(x),
                                handler.valueOf(y),
                                handler.valueOf(z),
                                handler
                        );
                    } catch (final ArithmeticException ignore) {
                    }
                }
            }
        }
        return result;
    }
}
