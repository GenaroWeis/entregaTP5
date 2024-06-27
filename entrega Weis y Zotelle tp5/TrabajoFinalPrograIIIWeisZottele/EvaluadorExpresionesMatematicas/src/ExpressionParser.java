package EvaluadorExpresionesMatematicas.src;

import java.util.Stack;

public class ExpressionParser {
    public static ExpressionTree parse(String expression) {

        ExpressionValidator.validate(expression);//validaciones

        Stack<ExpressionNode> nodes = new Stack<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder operand = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                operand.append(c);
            } else if (c == ' ') {
                continue;
            } else {
                if (operand.length() > 0) {
                    nodes.push(new OperandNode(Double.parseDouble(operand.toString())));
                    operand.setLength(0);
                }
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    nodes.push(createOperatorNode(operators.pop(), nodes.pop(), nodes.pop()));
                }
                operators.push(c);
            }
        }
        if (operand.length() > 0) {
            nodes.push(new OperandNode(Double.parseDouble(operand.toString())));
        }
        while (!operators.isEmpty()) {
            nodes.push(createOperatorNode(operators.pop(), nodes.pop(), nodes.pop()));
        }
        return new ExpressionTree(nodes.pop());
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static ExpressionNode createOperatorNode(char operator, ExpressionNode right, ExpressionNode left) {
        switch (operator) {
            case '+':
                return new AdditionNode(left, right);
            case '-':
                return new SubtractionNode(left, right);
            case '*':
                return new MultiplicationNode(left, right);
            case '/':
                return new DivisionNode(left, right);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
