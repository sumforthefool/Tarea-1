/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoratarea1;

/**
 *
 * @author Usuario
 */
public class Calculator {
     // Método para sumar dos números enteros
    public int add(int a, int b) {
        return a + b;
    }

    // Método para restar el segundo número del primero
    public int subtract(int a, int b) {
        return a - b;
    }

    // Método para multiplicar dos números enteros
    public int multiply(int a, int b) {
        return a * b;
    }

    // Método para dividir el primer número por el segundo número
    // Se verifica si el segundo número es cero para evitar una división por cero
    // En caso de división por cero, se lanza una excepción IllegalArgumentException
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divide 0");
        }
        return a / b;
    }
    
}
