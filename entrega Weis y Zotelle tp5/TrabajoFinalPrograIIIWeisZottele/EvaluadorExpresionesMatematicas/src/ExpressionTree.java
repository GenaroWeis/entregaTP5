package EvaluadorExpresionesMatematicas.src;

public class ExpressionTree {
    private ExpressionNode root;

    public ExpressionTree(ExpressionNode root) {
        this.root = root;
    }

    public double evaluate() {
        return root.evaluate();
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        root.inOrder(sb);
        return sb.toString();
    }

    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        root.preOrder(sb);
        return sb.toString();
    }

    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        root.postOrder(sb);
        return sb.toString();
    }

    public ExpressionNode getRoot() {
        return root;
    }
}