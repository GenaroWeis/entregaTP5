package EvaluadorExpresionesMatematicas.src;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ExpressionEvaluatorGUI extends JFrame {
    private JTextField expressionField;
    private JButton evaluateButton;
    private JButton inOrderButton;
    private JButton preOrderButton;
    private JButton postOrderButton;
    private JButton visualizeButton;
    private JLabel resultLabel;

    public ExpressionEvaluatorGUI() {
        setTitle("Evaluador de Expresiones Matemáticas");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {//gradiente de gris claro a gris oscuro para el fondo
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, Color.DARK_GRAY, 
                        0, getHeight(), Color.BLACK);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("EVALUADOR DE EXPRESIONES MATEMÁTICAS");//TITULO
        titleLabel.setBounds(12, 20, 360, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(Color.ORANGE);
        mainPanel.add(titleLabel);

        expressionField = new JTextField();//CAMPO DE TEXTO
        expressionField.setBounds(42, 70, 300, 40);
        expressionField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        expressionField.setBackground(new Color(173, 216, 230)); // Celeste claro
        Border border = BorderFactory.createCompoundBorder(//el borde 3d
                BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), 
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        expressionField.setBorder(border);
        mainPanel.add(expressionField);

        //botones posicion y texto
        inOrderButton = createGradientButton("IN ORDER");
        inOrderButton.setBounds(42, 130, 140, 40);
        mainPanel.add(inOrderButton);

        preOrderButton = createGradientButton("PRE ORDER");
        preOrderButton.setBounds(202, 130, 140, 40);
        mainPanel.add(preOrderButton);

        postOrderButton = createGradientButton("POST ORDER");
        postOrderButton.setBounds(42, 190, 140, 40);
        mainPanel.add(postOrderButton);

        visualizeButton = createGradientButton("VISUALIZAR ÁRBOL");
        visualizeButton.setBounds(202, 190, 140, 40);
        mainPanel.add(visualizeButton);

        evaluateButton = createGradientButton("EVALUAR");
        evaluateButton.setBounds(122, 250, 140, 40);
        mainPanel.add(evaluateButton);

        //label resultados
        JLabel resultTitleLabel = new JLabel("RESULTADOS");
        resultTitleLabel.setBounds(12, 310, 360, 30);
        resultTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resultTitleLabel.setForeground(Color.WHITE);
        mainPanel.add(resultTitleLabel);

        //resultados
        resultLabel = new JLabel("");
        resultLabel.setBounds(12, 350, 360, 40);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        resultLabel.setForeground(Color.WHITE);
        mainPanel.add(resultLabel);

        //marca
        JLabel footerLabel = new JLabel("WEIS & ZOTTELE");
        footerLabel.setBounds(145, 432, 360, 30);
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footerLabel.setForeground(Color.LIGHT_GRAY);
        mainPanel.add(footerLabel);

        add(mainPanel);

        // Agregar ActionListeners después de que todos los componentes han sido inicializados
        addActionListeners();
    }

    //BUTTON DESIGN
    private JButton createGradientButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
        button.setBorder(compound);
        return button;
    }

    private void addActionListeners() {
        evaluateButton.addActionListener(e -> {
            String expression = expressionField.getText();
            try {
                ExpressionTree tree = ExpressionParser.parse(expression);
                double result = tree.evaluate();
                resultLabel.setText("Resultado: " + result);
            } catch (IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Error inesperado: " + ex.getMessage());
            }
        });

        inOrderButton.addActionListener(e -> {
            String expression = expressionField.getText();
            try {
                ExpressionTree tree = ExpressionParser.parse(expression);
                resultLabel.setText("In-Order: " + tree.inOrder());
            } catch (IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Error inesperado: " + ex.getMessage());
            }
        });

        preOrderButton.addActionListener(e -> {
            String expression = expressionField.getText();
            try {
                ExpressionTree tree = ExpressionParser.parse(expression);
                resultLabel.setText("Pre-Order: " + tree.preOrder());
            } catch (IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Error inesperado: " + ex.getMessage());
            }
        });

        postOrderButton.addActionListener(e -> {
            String expression = expressionField.getText();
            try {
                ExpressionTree tree = ExpressionParser.parse(expression);
                resultLabel.setText("Post-Order: " + tree.postOrder());
            } catch (IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Error inesperado: " + ex.getMessage());
            }
        });

        visualizeButton.addActionListener(e -> {
            String expression = expressionField.getText();
            try {
                ExpressionTree tree = ExpressionParser.parse(expression);
                showTreeVisualization(tree.getRoot());
            } catch (IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Error inesperado: " + ex.getMessage());
            }
        });
    }

    private void showTreeVisualization(ExpressionNode root) {
        JFrame frame = new JFrame("Visualización del Árbol");
        TreeVisualizer visualizer = new TreeVisualizer(root);
        frame.add(visualizer);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExpressionEvaluatorGUI().setVisible(true);
        });
    }
}


