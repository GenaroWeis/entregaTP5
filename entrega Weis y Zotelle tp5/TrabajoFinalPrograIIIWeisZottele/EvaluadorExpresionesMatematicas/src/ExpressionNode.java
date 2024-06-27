package EvaluadorExpresionesMatematicas.src;


// Nodo de la expresión
public interface ExpressionNode {
    double evaluate();
    void inOrder(StringBuilder sb);
    void preOrder(StringBuilder sb);
    void postOrder(StringBuilder sb);
}