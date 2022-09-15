package expression;

public interface Operator extends GenericTripleExpression {
    default int getPriority() {
        return 3 << 26;
    }
}
