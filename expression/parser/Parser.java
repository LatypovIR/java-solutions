package expression.parser;

import expression.GenericTripleExpression;
import expression.exceptions.ParseException;

public interface Parser {
    GenericTripleExpression parse(String expression) throws ParseException;
}