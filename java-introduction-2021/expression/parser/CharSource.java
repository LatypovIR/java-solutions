package expression.parser;

public interface CharSource {
    boolean hasNext();

    char next();

    boolean find(String s);
}
