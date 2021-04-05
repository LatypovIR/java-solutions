package expression.parser;

public class StringSource implements CharSource {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
        pos = -1;
    }

    @Override
    public boolean hasNext() {
        return pos + 1 < data.length();
    }

    @Override
    public char next() {
        return data.charAt(++pos);
    }

    @Override
    public boolean find(String s) {
        return data.startsWith(s, pos);
    }
}
