package com.mycompany.calculadoratarea1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JButton[] numberButtons; // Array para los botones numéricos
    private JButton[] operatorButtons; // Array para los botones de operadores
    private Calculator calculator;

    public App() {
        // Configuración de la ventana principal y los componentes
        frame = new JFrame("Calculator");
        panel = new JPanel();
        inputField = new JTextField(10);
        inputField.setEditable(false); // Para evitar la edición directa del campo de entrada
        calculator = new Calculator(); // Inicialización de la instancia de Calculator
        
        // Crear botones numéricos
        numberButtons = new JButton[10]; // Crear un array de 10 botones numéricos
        for (int i = 0; i < numberButtons.length; i++) {
            final int digit = i; // Valor final para el ActionListener
            numberButtons[i] = new JButton(String.valueOf(i)); // Crear el botón con el dígito correspondiente
            numberButtons[i].addActionListener(e -> inputField.setText(inputField.getText() + digit)); // Agregar ActionListener para agregar el dígito al campo de entrada
        }
        
        // Crear botones de operadores
        operatorButtons = new JButton[]{
            new JButton("+"),
            new JButton("-"),
            new JButton("*"),
            new JButton("/"),
            new JButton("="),
            new JButton("C")
        };
        
        // Configurar el diseño del panel
        panel.setLayout(new GridLayout(4, 4)); // Diseño de cuadrícula para los botones
        
        // Agregar los botones numéricos al panel
        for (int i = 1; i < numberButtons.length; i++) {
            panel.add(numberButtons[i]);
        }
        
        // Agregar el botón "0" en la última fila y primera columna
        panel.add(numberButtons[0]);
        
        // Agregar los botones de operadores al panel
        for (JButton button : operatorButtons) {
            panel.add(button);
            button.addActionListener(new ButtonClickListener());
        }
        
        // Agregar el campo de entrada al panel
        panel.add(inputField);
        
        // Configuración de la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // Clase interna para manejar los eventos de los botones de operadores
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            // Manejar la lógica de cada botón
            if (command.equals("=")) {
                try {
                    // Evaluar la expresión y mostrar el resultado
                    double result = evaluateExpression(inputField.getText());
                    inputField.setText(String.valueOf(result));
                } catch (IllegalArgumentException ex) {
                    inputField.setText("Error: " + ex.getMessage());
                }
            } else if (command.equals("C")) {
                inputField.setText(""); // Limpiar el campo de entrada
            } else {
                // Agregar el operador al campo de entrada
                inputField.setText(inputField.getText() + " " + command + " ");
            }
        }

        // Método para evaluar la expresión ingresada y devolver el resultado
        private double evaluateExpression(String expression) {
            // La implementación de eval() debe ser adaptada
            return 0;
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
