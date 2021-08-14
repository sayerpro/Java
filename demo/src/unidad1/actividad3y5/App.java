package unidad1.actividad3y5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        imprimirMensaje("Calculadora");
        imprimirMensaje("1.Suma");
        imprimirMensaje("2.Resta");
        imprimirMensaje("3.Multiplicación");
        imprimirMensaje("4.División");
        imprimirMensaje("5.Residuo");
        imprimirMensaje("6.Salir");
        imprimirMensaje("7.Formula del estudiante");
        imprimirMensaje("8.Validar número primo");
        imprimirMensaje("Digite un número según la opción: ");
        int decision = whileValidation(true, "Por favor digite un número dentro del rango de opciones");

        int numero1 = 0;
        int numero2 = 0;

        if (validarRangosNumericos(decision, 1, 5)) {
            imprimirMensaje("Digite el primer número: ");
            numero1 = whileValidation(false, "Por favor digite un número dentro del rango de opciones");
            imprimirMensaje("Digite el segundo número: ");
            numero2 = whileValidation(false, "Por favor digite un número dentro del rango de opciones");
        }

        switch (decision) {
            case 1:
                imprimirMensaje("Suma");
                int suma = suma(numero1, numero2);
                imprimirMensaje(numero1 + " + " + numero2 + " = " + suma);
                break;
            case 2:
                imprimirMensaje("Resta");
                int resta = resta(numero1, numero2);
                imprimirMensaje(numero1 + " - " + numero2 + " = " + resta);
                break;
            case 3:
                imprimirMensaje("Multiplicación");
                int multiplicacion = multiplicacion(numero1, numero2);
                imprimirMensaje(numero1 + " x " + numero2 + " = " + multiplicacion);
                break;
            case 4:
                imprimirMensaje("División");
                int division = division(numero1, numero2);
                imprimirMensaje(numero1 + " ÷ " + numero2 + " = " + division);
                break;
            case 5:
                imprimirMensaje("Residuo");
                int residuo = residuo(numero1, numero2);
                imprimirMensaje(numero1 + " % " + numero2 + " = " + residuo);
                break;
            case 6:
                finalizarEjecucion();
                break;
            case 7:
                formulaEstudiante();
                break;
            case 8:
                numerosPrimos();
                break;
        }
    }

    private static int suma(int n1, int n2) {
        return n1 + n2;
    }

    private static int resta(int n1, int n2) {
        return n1 - n2;
    }

    private static int multiplicacion(int n1, int n2) {
        return n1 * n2;
    }

    private static int division(int n1, int n2) {
        return n1 / n2;
    }

    private static int residuo(int n1, int n2) {
        return n1 % n2;
    }

    private static boolean validarEntradaNumerica(String numero, String mensaje) {
        boolean result = false;
        try {
            Integer.parseInt(numero);
            result = true;
        } catch (NumberFormatException exception) {
            imprimirMensaje(mensaje);
        }
        return result;
    }

    private static boolean validarRangosNumericos(int numero, int n1, int n2) {
        boolean result = false;
        if (numero >= n1 && numero <= n2) {
            result = true;
        }
        return result;
    }

    private static String tomarEntradas() {
        Scanner in = new Scanner(System.in);
        String entrada = in.nextLine();
        return entrada;
    }

    private static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    private static void finalizarEjecucion() {
        System.exit(0);
    }

    // No entiendo cual es el objetivo de realizar esta solución que requiere la
    // Actividad 5, en la unidad 1 del ciclo 2, pero bueno hay esta, full copy
    // paste, porque no entendi que tiene que ver la formula del estudiante en la
    // actividad
    private static void formulaEstudiante() {
        double a = 1, b = 6, c = 4, temp, x1, x2;
        temp = b * b - 4 * a * c;

        if (temp >= 0) {
            if (2 * a != 0) {
                x1 = -b - Math.sqrt(temp) / (2 * a);
                x2 = -b + Math.sqrt(temp) / (2 * a);
                imprimirMensaje("Las raices son: ");
                imprimirMensaje("x1 -: " + x1);
                imprimirMensaje("x2 +: " + x2);
            } else {
                imprimirMensaje("Error división por cero(0)");
            }
        }
        finalizarEjecucion();
    }

    // No entiendo cual es el objetivo de realizar esta solución que requiere la
    // Actividad 5, en la unidad 1 del ciclo 2, pero bueno hay esta, full copy
    // paste, porque no entendi que tiene que ver la formula del estudiante en la
    // actividad
    private static void numerosPrimos() {
        int divisores = 2;
        int cont = 2;
        imprimirMensaje("Por favor digite el número a validar si es primo o no: ");
        int numero = whileValidation(false, "Por favor digite un número");
        while (cont < numero) {
            if (numero % cont == 0) {
                divisores++;
                break;
            } else {
                cont++;
            }
        }
        if (divisores > 2) {
            imprimirMensaje(numero + ", No es un número primo");
        } else {
            imprimirMensaje(numero + ", Es un número primo");
        }
    }

    private static int whileValidation(boolean rango, String mensaje) {
        String dato = "";
        boolean whileDecision = true;
        while (whileDecision) {
            dato = tomarEntradas();
            if (validarEntradaNumerica(dato, mensaje)) {
                if (rango) {
                    int decisionNumber = Integer.parseInt(dato);
                    if (validarRangosNumericos(decisionNumber, 1, 8)) {
                        whileDecision = false;
                    } else {
                        imprimirMensaje("Por favor digite un número dentro del rango de opciones");
                    }
                } else {
                    whileDecision = false;
                }
            }
        }
        return Integer.parseInt(dato);
    }
}
