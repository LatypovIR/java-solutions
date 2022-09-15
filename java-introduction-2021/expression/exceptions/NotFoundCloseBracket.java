package expression.exceptions;

public class NotFoundCloseBracket extends ParseException {
    public NotFoundCloseBracket(String msg) {
        super(msg);
    }

    public NotFoundCloseBracket(int position, char ch) {
        super("Position " + position + " found '" + ch + "'");
    }

}
