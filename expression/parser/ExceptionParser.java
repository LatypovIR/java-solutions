package expression.parser;

import expression.*;
import expression.exceptions.IncorrectInput;
import expression.exceptions.NotFoundCloseBracket;
import expression.exceptions.ParseException;
import expression.exceptions.UnexpectedEnd;

import java.util.Map;
import java.util.Set;

public class ExceptionParser extends BaseParser {

    private static final Map<String, Integer> BIN_OPERATORS = Map.of(
            "+", 1 << 26,
            "-", 1 << 26,
            "*", 2 << 26,
            "/", 2 << 26,
            "mod",2 << 26
    );

    private static final Set<String> UNO_OPERATORS = Set.of(
            "abs",
            "square"
    );

    private final Integer[] priories = {1 << 26, 2 << 26};

    private final int MIN_PRIORY = 0;
    private final int MAX_PRIORY = priories.length;

    public ExceptionParser(final String source) {
        super(new StringSource(source));
    }

    public GenericTripleExpression parse() throws ParseException {
        final GenericTripleExpression ans = parseForPriory(MIN_PRIORY);
        if (!eof()) {
            throw new IncorrectInput(
                    "Expected end of string in position " + position + ", but found '" + ch + "'"
            );
        }
        return ans;
    }

    private Operator parseForPriory(final int priory) throws ParseException {
        skipWhiteSpace();
        if (eof()) {
            throw new UnexpectedEnd(position);
        }
        if (priory == MAX_PRIORY) {
            return parseNextBlock();
        }
        Operator operator = parseForPriory(priory + 1);
        for (String operation = testPriority(priory); operation != null; operation = testPriority(priory)) {
            operator = getBinaryOperator(operator, parseForPriory(priory + 1), operation);
        }
        return operator;
    }

    private String testPriority(final int priory) {
        skipWhiteSpace();
        for (final String operand : BIN_OPERATORS.keySet()) {
            if (priories[priory].equals(BIN_OPERATORS.get(operand)) && find(operand)) {
                return operand;
            }
        }
        return null;
    }

    private Operator getBinaryOperator(final Operator operator1, final Operator operator2, final String op) {
        switch (op) {
            case "+":
                return new Add(operator1, operator2);
            case "-":
                return new Subtract(operator1, operator2);
            case "*":
                return new Multiply(operator1, operator2);
            case "/":
                return new Divide(operator1, operator2);
            case "mod":
                return new Mod(operator1, operator2);
            default:
                throw new AssertionError();
        }
    }

    private Operator getUnaryOperator(final Operator operator, final String op) {
        switch (op) {
            case "abs":
                return new Abs(operator);
            case "square":
                return new Square(operator);
            default:
                throw new AssertionError();
        }
    }

    private Operator parseNextBlock() throws ParseException {
        skipWhiteSpace();
        if (eof()) {
            throw new UnexpectedEnd(position);
        }
        final Operator operator;
        if (test('(')) {
            operator = parseForPriory(MIN_PRIORY);
            skipWhiteSpace();
            if (!test(')')) {
                throw new NotFoundCloseBracket(position, ch);
            }
        } else {
            operator = parseOperand();
        }
        return operator;
    }

    private Operator parseOperand() throws ParseException {
        skipWhiteSpace();
        if (eof()) {
            throw new UnexpectedEnd(position);
        }

        for (String operator : UNO_OPERATORS) {
            if (find(operator)) {
                return getUnaryOperator(parseNextBlock(), operator);
            }
        }

        if (test('x')) {
            return new Variable("x");
        } else if (test('y')) {
            return new Variable("y");
        } else if (test('z')) {
            return new Variable("z");
        }

        final StringBuilder stringBuilder = new StringBuilder();

        if (test('-')) {
            skipWhiteSpace();
            if (!isNumber()) {
                return new Negative(parseNextBlock());
            }
            stringBuilder.append('-');
        }
        skipWhiteSpace();

        while (isNumber()) {
            stringBuilder.append(ch);
            nextChar();
        }

        return new Const(stringBuilder.toString());
    }
}
