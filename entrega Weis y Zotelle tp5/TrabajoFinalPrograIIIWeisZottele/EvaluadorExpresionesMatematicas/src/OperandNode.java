package EvaluadorExpresionesMatematicas.src;

// Nodo Operando
public class OperandNode implements ExpressionNode {
    private double value;

    public OperandNode(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    
    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public void inOrder(StringBuilder sb) {
        sb.append(value);
    }

    @Override
    public void preOrder(StringBuilder sb) {
        sb.append(value);
    }

    @Override
    public void postOrder(StringBuilder sb) {
        sb.append(value);
    }
}