package expression;

import expression.handler.Handler;

public class Variable implements Operator {

    private final String name;

    public Variable(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public <T> T evaluate(T x, T y, T z, Handler<T> handler) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            default:
                return z;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Variable variable = (Variable) object;
        return name.equals(variable.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}