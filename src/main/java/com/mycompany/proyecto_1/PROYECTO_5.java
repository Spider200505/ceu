package com.mycompany.proyecto_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alejandro.esteban1
 */
public class PROYECTO_5 {
    // Funcion para convertir grados Celsius a Fahreheit
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32; // Formula de conversion: (c x 9/5) + 32
    }
    
    public static void main(String[] args) {
        //Ejemplo de uso
        double celsius = 25.0;
        double fahrenheit = celsiusAFahrenheit(celsius);
        System.out.println(+ celsius + "conversion a fahrenheit" + fahrenheit);
    }
}
