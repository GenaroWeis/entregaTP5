package EvaluadorExpresionesMatematicas.src;

public class AdditionNode extends OperatorNode {
    public AdditionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right, '+');
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}