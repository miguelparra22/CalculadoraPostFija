/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {
    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static double evaluarPostFija(String expresion) {

        Stack<Double> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (Character.isDigit(caracter)) {
                pila.push(Double.parseDouble(String.valueOf(caracter)));
            } else {
                double operando2 = pila.pop();
                double operando1 = pila.pop();

                switch (caracter) {
                    case '+':
                        pila.push(operando1 + operando2);
                        break;
                    case '-':
                        pila.push(operando1 - operando2);
                        break;
                    case '*':
                        pila.push(operando1 * operando2);
                        break;
                    case '/':
                        pila.push(operando1 / operando2);
                        break;
                }
            }
        }

        return pila.pop();
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la expresión postfija: ");
        String postfixExpression = scanner.nextLine();
        double result = evaluarPostFija(postfixExpression);
        System.out.println("Resultado: " + result);

    }
}
