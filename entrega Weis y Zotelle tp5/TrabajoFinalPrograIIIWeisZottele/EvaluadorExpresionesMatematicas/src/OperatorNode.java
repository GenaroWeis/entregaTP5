package EvaluadorExpresionesMatematicas.src;

// Nodo Operador
public abstract class OperatorNode implements ExpressionNode {
    protected ExpressionNode left;
    protected ExpressionNode right;
    protected char operator;

    public OperatorNode(ExpressionNode left, ExpressionNode right, char operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    public char getOperator() {
        return operator;
    }

    @Override
    public void inOrder(StringBuilder sb) {
        sb.append("(");
        left.inOrder(sb);
        sb.append(" ").append(operator).append(" ");
        right.inOrder(sb);
        sb.append(")");
    }

    @Override
    public void preOrder(StringBuilder sb) {
        sb.append(operator).append(" ");
        left.preOrder(sb);
        sb.append(" ");
        right.preOrder(sb);
    }

    @Override
    public void postOrder(StringBuilder sb) {
        left.postOrder(sb);
        sb.append(" ");
        right.postOrder(sb);
        sb.append(" ").append(operator);
    }
}