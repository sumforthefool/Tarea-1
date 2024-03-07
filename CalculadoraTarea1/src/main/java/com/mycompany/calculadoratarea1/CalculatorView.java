/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoratarea1;

import java.awt.Insets;
import java.awt.TextField;
import javafx.scene.layout.GridPane;
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

        // Crear el campo de texto
        display = new TextField();
        display.setEditable(false); // Hacer que el campo de texto no sea editable
        display.setPrefHeight(50); // Establecer la altura del campo de texto

        // Crear el diseño de la calculadora con botones
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10)); // Agregar relleno alrededor del layout
        gridPane.setHgap(5); // Espacio horizontal entre las columnas
        gridPane.setVgap(5); // Espacio vertical entre las filas

        // Crear botones para los números y operaciones
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Agregar botones al layout
        for (int i = 0; i < buttonLabels.length; i++) {
            Button button = new Button(buttonLabels[i]);
            button.setPrefWidth(50); // Establecer el ancho del botón
            button.setPrefHeight(50); // Establecer la altura del botón

            // Manejar el evento del clic del botón
            button.setOnAction(event -> handleButtonClick(buttonLabels[i]));

            // Agregar el botón al layout en la posición correspondiente
            gridPane.add(button, i % 4, i / 4);
        }

        // Crear la escena y agregar el layout
        Scene scene = new Scene(new GridPane(), 220, 220); // Crear una nueva escena
        ((GridPane) scene.getRoot()).add(display, 0, 0, 4, 1); // Agregar el campo de texto a la escena
        ((GridPane) scene.getRoot()).add(gridPane, 0, 1, 4, 1); // Agregar el layout con los botones a la escena

        primaryStage.setScene(scene); // Establecer la escena en la ventana principal
        primaryStage.show(); // Mostrar la ventana
    }

    // Método para manejar los clics en los botones
    private void handleButtonClick(String input) {
        switch (input) {
            case "=":
                evaluate(); // Evaluar la expresión y mostrar el resultado
                break;
            case "C":
                clear(); // Borrar la entrada actual
                break;
            default:
                currentInput += input; // Agregar la entrada al string actual
                display.setText(currentInput); // Mostrar la entrada en el campo de texto
                break;
        }
    }

    // Método para evaluar la expresión y mostrar el resultado
    private void evaluate() {
        try {
            // Evaluar la expresión y convertir el resultado a un string
            String result = String.valueOf(eval(currentInput));
            display.setText(result); // Mostrar el resultado en el campo de texto
            currentInput = result; // Establecer el resultado como la entrada actual para nuevas operaciones
        } catch (NumberFormatException | ArithmeticException e) {
            // Manejar errores de formato o división por cero
            display.setText("Error");
            currentInput = ""; // Restablecer la entrada actual
        }
    }

    // Método para borrar la entrada actual
    private void clear() {
        currentInput = ""; // Restablecer la entrada actual
        display.setText(""); // Borrar el contenido del campo de texto
    }

    // Método para borrar la entrada actual
    private void clear() {
        currentInput = ""; // Restablecer la entrada actual
        display.setText(""); // Borrar el contenido del campo de texto
    }

    // Método para evaluar una expresión matemática
    private double eval(String expression) {
        return new Object() {
            int pos = -1, ch;

            // Método para avanzar al siguiente carácter de la expresión
            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }
        }
    }

}
