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
import java.util.*;

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

    public static int evaluarPostFija(List<String> expresion) {
        //Declaramos la Pila
        Stack<Integer> pila = new Stack<Integer>();
        for (String elemento : expresion) {
            //Validamos la expresion regular
            if (elemento.matches("\\d+")) {
                //Parseamos el elemento numero
                pila.push(Integer.parseInt(elemento));
            } else {
                //Tomamos lo valores que salen de la pila para operarlos entre si.
                int num2 = pila.pop();
                int num1 = pila.pop();
                //Elegimos el caso para la operacion correspondiente
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

        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingresa tu notación separada por comas. Ej: 2,3,+,4,*");
        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            //Dividimos el texto por medio de la coma debido a que queremos convertirlo en una lista.
           String[] divisionTexto = linea.split(",");
           //Convertirmos el texto separado por comas en una Lista
            List<String> lista = new ArrayList<>(Arrays.asList(divisionTexto));
            //Se llama a la operacion.
            System.out.println(evaluarPostFija(lista));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresión: %s", e.getMessage());
        }

    }

}
