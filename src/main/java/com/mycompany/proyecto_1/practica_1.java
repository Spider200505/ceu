/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_1;

/**
 *
 * @author alejandro.esteban1
 */


import java.util.Arrays;
import java.util.Scanner;

public class practica_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10]; // Array con capacidad para 10 números
        int count = 0; // Contador de elementos en el array

        while (true) {
            System.out.println("\nMenu de Opciones:");
            System.out.println("1. Agregar un Numero");
            System.out.println("2. Eliminar un Numero");
            System.out.println("3. Buscar un Numero");
            System.out.println("4. Mostrar Todos los Numeros");
            System.out.println("5. Ordenar Numeros");
            System.out.println("6. Sumatorio de los Numeros");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1: // Agregar un número
                    if (count < numbers.length) {
                        System.out.print("Ingrese un numero para agregar: ");
                        int numToAdd = scanner.nextInt();
                        numbers[count] = numToAdd;
                        count++;
                        System.out.println("Numero agregado correctamente.");
                    } else {
                        System.out.println("El array esta lleno. No se pueden agregar mas numeros.");
                    }
                    break;
                
                case 2: // Eliminar un número
                    System.out.print("Ingrese un numero para eliminar: ");
                    int numToRemove = scanner.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (numbers[i] == numToRemove) {
                            found = true;
                            // Desplazar los elementos
                            for (int j = i; j < count - 1; j++) {
                                numbers[j] = numbers[j + 1];
                            }
                            count--;
                            System.out.println("Numero eliminado correctamente.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("El numero no se encuentra en el array.");
                    }
                    break;
                
                case 3: // Buscar un número
                    System.out.print("Ingrese un numero para buscar: ");
                    int numToFind = scanner.nextInt();
                    found = false;

                    for (int i = 0; i < count; i++) {
                        if (numbers[i] == numToFind) {
                            found = true;
                            System.out.println("El numero se encuentra en el array.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("El numero no se encuentra en el array.");
                    }
                    break;
                
                case 4: // Mostrar todos los números
                    System.out.println("Numeros en el array: " + Arrays.toString(Arrays.copyOf(numbers, count)));
                    break;
                
                case 5: // Ordenar números
                    Arrays.sort(numbers, 0, count);
                    System.out.println("Numeros ordenados correctamente.");
                    break;
                
                case 6: // Sumatorio de los números
                    int sum = 0;
                    for (int i = 0; i < count; i++) {
                        sum += numbers[i];
                    }
                    System.out.println("La suma de los números es: " + sum);
                    break;
                
                case 7: // Salir
                    System.out.println("Saliendo del programa. ADIOSSS!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no valida. Intente nuevamente.");
                    break;
            }
        }
    }
}
