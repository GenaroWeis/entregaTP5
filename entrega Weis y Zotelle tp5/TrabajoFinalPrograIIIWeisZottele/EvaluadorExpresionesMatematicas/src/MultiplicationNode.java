package EvaluadorExpresionesMatematicas.src;

public class MultiplicationNode extends OperatorNode {
    public MultiplicationNode(ExpressionNode left, ExpressionNode right) {
        super(left, right, '*');
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
