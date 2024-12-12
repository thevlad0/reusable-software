package mobile.filters;

public class ComplexFilter<T> implements Filter<T> {
    private enum Operator {
        AND, OR
    }

    Filter<T> left;
    Filter<T> right;
    Operator operator;

    public ComplexFilter(Filter<T> left, Filter<T> right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = Operator.valueOf(operator.toUpperCase());
    }

    @Override
    public boolean matches(T item) {
        return switch (operator) {
            case AND -> left.matches(item) && right.matches(item);
            case OR -> left.matches(item) || right.matches(item);
        };
    }
}
