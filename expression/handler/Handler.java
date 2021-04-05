package expression.handler;

public interface Handler<T> {
    T parseValue(String value);

    T valueOf(int a);

    T sum(T a, T b);

    T sub(T a, T b);

    T multiply(T a, T b);

    T divide(T a, T b);

    T mod(T a, T b);

    T negative(T a);

    T abs(T a);

    T sqr(T a);
}
