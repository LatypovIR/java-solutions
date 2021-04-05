package expression.exceptions;

public abstract class ArithmeticException extends IllegalArgumentException {
    protected ArithmeticException(String msg) {
        super(msg);
    }
}
