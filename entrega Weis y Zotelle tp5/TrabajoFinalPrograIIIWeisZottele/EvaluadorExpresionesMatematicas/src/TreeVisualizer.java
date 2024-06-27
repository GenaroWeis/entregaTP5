package EvaluadorExpresionesMatematicas.src;

import javax.swing.*;
import java.awt.*;

public class TreeVisualizer extends JPanel {
    private ExpressionNode root;
    private final int VERTICAL_GAP = 50;
    private final int HORIZONTAL_GAP = 30;

    public TreeVisualizer(ExpressionNode root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 30, getWidth() / 4);
        }
    }

     private void drawTree(Graphics g, ExpressionNode node, int x, int y, int xOffset) {
        if (node instanceof OperatorNode) {
            OperatorNode opNode = (OperatorNode) node;
            String value = String.valueOf(opNode.getOperator());
            g.setColor(Color.BLUE);  // Nodos operadores en azul
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(value, x - 5, y + 5);

            // Dibuja líneas a los hijos
            g.setColor(Color.BLACK);
            g.drawLine(x, y + 15, x - xOffset, y + VERTICAL_GAP - 15);
            g.drawLine(x, y + 15, x + xOffset, y + VERTICAL_GAP - 15);

            // Dibuja los hijos recursivamente
            drawTree(g, opNode.getLeft(), x - xOffset, y + VERTICAL_GAP, xOffset / 2);
            drawTree(g, opNode.getRight(), x + xOffset, y + VERTICAL_GAP, xOffset / 2);
        } else if (node instanceof OperandNode) {
            OperandNode opNode = (OperandNode) node;
            String value = String.valueOf(opNode.getValue());
            g.setColor(Color.GREEN);  // Nodos operandos en verde
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawString(value, x - 10, y + 5);
        }

        
    }
}