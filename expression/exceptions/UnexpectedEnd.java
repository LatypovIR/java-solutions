package expression.exceptions;

public class UnexpectedEnd extends ParseException {
    public UnexpectedEnd(String msg) {
        super(msg);
    }

    public UnexpectedEnd(int position) {
        super("Position " + position + ", expected '(' or variable/number/unary operator");
    }
}
