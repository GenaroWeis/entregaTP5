package EvaluadorExpresionesMatematicas.src;



public class SubtractionNode extends OperatorNode {
    public SubtractionNode(ExpressionNode left, ExpressionNode right) {
        super(left, right,  '-');
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}



