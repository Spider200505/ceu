/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_1;

public class PROYECTO_1 {
    public static void main(String[] args) {
        int start = 1;
        int end = 100;
        int count = 0;
        
        System.out.println("Numeros pares entre " + start + "y" + end + ":");
        for(int number = start; number <= end; number++) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
                count++;
            }
        }
        System.out.println("\nLa cantidad de numeros pares entre " + start + " y " + end + "es: " + count);
    }
}
