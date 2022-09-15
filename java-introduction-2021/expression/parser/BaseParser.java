package expression.parser;

public class BaseParser {
    public static final char END = '\0';
    private final CharSource source;
    protected char ch = 0xffff;
    protected int position = 0;

    protected BaseParser(final CharSource source) {
        this.source = source;
        nextChar();
    }

    protected void nextChar() {
        if (source.hasNext()) {
            ch = source.next();
            position++;
            return;
        }
        ch = END;
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean eof() {
        return ch == END;
    }

    protected void skipWhiteSpace() {
        while (Character.isWhitespace(ch)) {
            nextChar();
        }
    }

    protected boolean find(String s) {
        boolean res = source.find(s);
        if (res){
            test(s);
        }
        return res;
    }

    protected boolean test(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!test(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    protected boolean isNumber() {
        return isDigit() || ch == '.';
    }

    protected boolean isDigit() {
        return between('0', '9');
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}
