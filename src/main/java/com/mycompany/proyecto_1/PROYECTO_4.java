/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_1;

/**
 *
 * @author alejandro.esteban1
 */
public class PROYECTO_4 {
    // FUNCION PARA CALCULAR EL AREA DE UN CIRCULO
    public static double areaTriangulo(double base, double altura) {
        return base * altura /2; //FORMULA DEL TRIANGULO BASE POR ALTURA
    }
    public static void main (String[] args) {
        //EJEMPLO DE USO
        double base = 6.0; //Cambia este valor para probar
        double altura = 4.0;
        double areaTriangulo = areaTriangulo(base, altura);
        System.out.println(" EL AREA DEL TRIANGULO con base: " + base + " con altura: " + altura + " es: " + areaTriangulo );
    }
}
