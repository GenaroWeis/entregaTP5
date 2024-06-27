package EvaluadorExpresionesMatematicas.src;

public class DivisionNode extends OperatorNode {
    public DivisionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right, '/');
    }

    @Override
    public double evaluate() {
        return left.evaluate() / right.evaluate();
    }
}
