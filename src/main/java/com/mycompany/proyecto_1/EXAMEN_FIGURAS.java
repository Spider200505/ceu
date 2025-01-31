/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_1;

/**
 *
 * @author alejandro.esteban1
 */
import java.util.Scanner;

public class EXAMEN_FIGURAS {
    // FUNCION PARA CALCULAR EL AREA DE UN CIRCULO
    public static double areaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2); // FORMULA DEL CIRCULO PI POR RADIO AL CUADRADO
    }

    // FUNCION PARA CALCULAR EL AREA DE UN CUADRADO
    public static double areaCuadrado(double lado) {
        return lado * lado; // FORMULA DEL CUADRADO LADO POR LADO
    }

    // FUNCION PARA CALCULAR EL AREA DE UN RECTANGULO
    public static double areaRectangulo(double base, double altura) {
        return base * altura; // FORMULA DEL RECTANGULO BASE POR ALTURA
    }

    // FUNCION PARA CALCULAR EL AREA DE UN TRIANGULO
    public static double areaTriangulo(double base, double altura) {
        return (base * altura) / 2; // FORMULA DEL TRIANGULO BASE POR ALTURA DIVIDIDO ENTRE DOS
    }

    // FUNCION PARA CALCULAR EL AREA DE UN TRAPECIO
    public static double areaTrapecio(double baseMayor, double baseMenor, double altura) {
        return ((baseMayor + baseMenor) * altura) / 2; // FORMULA DEL TRAPECIO SUMA DE BASES POR ALTURA DIVIDIDO ENTRE DOS
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSeleccione una figura para calcular su area:");
            System.out.println("1. Circulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Rectangulo");
            System.out.println("4. Triangulo");
            System.out.println("5. Trapecio");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) { 
                case 1:
                    System.out.print("Ingrese el radio del circulo: ");
                    double radio = scanner.nextDouble();
                    System.out.println("El area del circulo es: " + areaCirculo(radio));
                    break;
                case 2:
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    System.out.println("El area del cuadrado es: " + areaCuadrado(lado));
                    break;
                case 3:
                    System.out.print("Ingrese la base del rectangulo: ");
                    double baseRect = scanner.nextDouble();
                    System.out.print("Ingrese la altura del rectangulo: ");
                    double alturaRect = scanner.nextDouble();
                    System.out.println("El area del rectangulo es: " + areaRectangulo(baseRect, alturaRect));
                    break;
                case 4:
                    System.out.print("Ingrese la base del triangulo: ");
                    double baseTri = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triangulo: ");
                    double alturaTri = scanner.nextDouble();
                    System.out.println("El area del triangulo es: " + areaTriangulo(baseTri, alturaTri));
                    break;
                case 5:
                    System.out.print("Ingrese la base mayor del trapecio: ");
                    double baseMayor = scanner.nextDouble();
                    System.out.print("Ingrese la base menor del trapecio: ");
                    double baseMenor = scanner.nextDouble();
                    System.out.print("Ingrese la altura del trapecio: ");
                    double alturaTrap = scanner.nextDouble();
                    System.out.println("El area del trapecio es: " + areaTrapecio(baseMayor, baseMenor, alturaTrap));
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Adios!");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
