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

public class PROYECTO_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("Introduce un numero para calcular su factorial: ");
        int numero = scanner.nextInt();
        
        if (numero < 0) {
            System.out.println("El factorial no esta definido para numeros negativos.");
        } else {
            long factorial = 1;
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            System.out.println("El factorial de " + numero + " es: " + factorial);
        }
        
        scanner.close();
    }
}
