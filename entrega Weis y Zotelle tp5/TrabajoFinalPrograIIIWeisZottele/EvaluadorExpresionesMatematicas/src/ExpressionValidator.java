package EvaluadorExpresionesMatematicas.src;

import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final String VALID_CHARS = "0123456789+-*/. ";
    private static final Pattern VALID_EXPRESSION = Pattern.compile("^\\s*-?\\d+(\\.\\d+)?(\\s*[-+*/]\\s*-?\\d+(\\.\\d+)?)*\\s*$");

    public static void validate(String expression) throws IllegalArgumentException {
        // Verificar caracteres válidos
        for (char c : expression.toCharArray()) {
            if (VALID_CHARS.indexOf(c) == -1) {
                throw new IllegalArgumentException("Carácter inválido: " + c);
            }
        }

        // Verificar formato general de la expresión
        if (!VALID_EXPRESSION.matcher(expression).matches()) {
            throw new IllegalArgumentException("Formato de expresión inválido");
        }

        // Verificar operadores consecutivos
        if (expression.matches(".*[-+*/]\\s*[-+*/].*")) {
            throw new IllegalArgumentException("Operadores consecutivos no permitidos");
        }

        // Verificar división por cero
        if (expression.matches(".*/(\\s*)?0(\\.0*)?.*")) {
            throw new IllegalArgumentException("División por cero no permitida");
        }
    }
}
