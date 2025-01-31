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

public class PROYECTO_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce un numero para ver su tabla de multiplicar: ");
        int numero = scanner.nextInt();
        
        System.out.println("Tabla de multiplicar del " + numero + ":");
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        
        scanner.close();
    }
}
