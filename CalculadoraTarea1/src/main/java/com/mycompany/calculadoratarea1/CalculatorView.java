/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoratarea1;

import java.awt.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class CalculatorView {
    private TextField display; // Campo de texto para mostrar los números y resultados
    private String currentInput = ""; // Almacena la entrada actual del usuario
    
     @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator"); // Título de la ventana
        
    }
}
