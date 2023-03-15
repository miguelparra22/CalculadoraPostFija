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

    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
        //Recorremos la lista que traemos desde la expresion
        for (String elemento : expresion){
            if(elemento.matches("\\d+")){
                pila.push(Integer.parseInt(elemento));
            }else{
                int number2 = pila.pop();
                int number1 = pila.pop();

                switch (elemento){
                    case "+":
                        pila.push(number1+number2);
                        break;
                    case "-":
                        pila.push(number1 - number2);
                        break;
                    case "*":
                        pila.push(number1 * number2);
                        break;
                    case "/":
                        pila.push(number1 / number2);
                        break;
                    case "^":
                        pila.push((int) Math.pow(number1, number2));
                        break;
                }
            }
        }

        return pila.pop();
    }

    /**
     * Programa principal

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<String> expresion = List.of("5", "2", "^", "4", "*", "3", "-");
        //System.out.print("> ");
        //String linea = teclado.nextLine();
        try {
            int resultado = evaluarPostFija(expresion);
            System.out.println(resultado);
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }*/

    public static int evaluarExpresionPostfijo(List<String> expresion) {
        Stack<Integer> pila = new Stack<Integer>();
        for (String elemento : expresion) {
            //Validamos la expresion regular
            if (elemento.matches("\\d+")) {
                //Parseamos el elemento numero
                pila.push(Integer.parseInt(elemento));
            } else {
                int num2 = pila.pop();
                int num1 = pila.pop();
                switch (elemento) {
                    case "+":
                        pila.push(num1 + num2);
                        break;
                    case "-":
                        pila.push(num1 - num2);
                        break;
                    case "*":
                        pila.push(num1 * num2);
                        break;
                    case "/":
                        pila.push(num1 / num2);
                        break;
                    case "^":
                        pila.push((int) Math.pow(num1, num2));
                        break;
                }
            }
        }
        return pila.pop();
    }

    public static void main(String[] args) {
        List<String> expresion = List.of("(", "5", "2", "^", "4", "*", "3", "-");
        int resultado = evaluarExpresionPostfijo(expresion);
        System.out.println("El resultado es: " + resultado);
    }

}
