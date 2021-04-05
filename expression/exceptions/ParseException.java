package expression.exceptions;

public abstract class ParseException extends Exception {
    protected ParseException(String msg) {
        super(msg);
    }
}
