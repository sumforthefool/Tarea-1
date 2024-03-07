package com.mycompany.calculadoratarea1;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * JavaFX App
 */
public class App  {
    
     private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton clearButton;
    private Calculator calculator;

     public App() {
        // Configuración de la ventana principal y los componentes
        frame = new JFrame("Calculator");
        panel = new JPanel();
        inputField = new JTextField(10);
        inputField.setEditable(false); // Para evitar la edición directa del campo de entrada
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        calculator = new Calculator(); // Inicialización de la instancia de Calculator
        
         panel.setLayout(new GridLayout(4, 4)); // Diseño de cuadrícula para los botones

        // Agregar los componentes al panel
        panel.add(inputField);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(equalsButton);
        panel.add(clearButton);
        
          // Agregar un ActionListener a cada botón
        addButton.addActionListener(new ButtonClickListener());
        subtractButton.addActionListener(new ButtonClickListener());
        multiplyButton.addActionListener(new ButtonClickListener());
        divideButton.addActionListener(new ButtonClickListener());
        equalsButton.addActionListener(new ButtonClickListener());
        clearButton.addActionListener(new ButtonClickListener());
        
         // Configuración de la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);

     }
     
     // Clase interna para manejar los eventos de los botones
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            // Manejar la lógica de cada botón
            if (command.equals("=")) {
                try {
                    // Evaluar la expresión y mostrar el resultado
                    int result = evaluateExpression(inputField.getText());
                    inputField.setText(Integer.toString(result));
                } catch (IllegalArgumentException ex) {
                    inputField.setText("Error: " + ex.getMessage());
                }
            } else if (command.equals("C")) {
                inputField.setText(""); // Limpiar el campo de entrada
            } else {
                // Agregar el operador o número al campo de entrada
                inputField.setText(inputField.getText() + command);
            }
        }

        // Método para evaluar la expresión ingresada y devolver el resultado
        private int evaluateExpression(String expression) {
            // Dividir la expresión en operandos y operadores
            String[] elements = expression.split(" ");
            // Convertir los operandos de String a int
            int operand1 = Integer.parseInt(elements[0]);
            int operand2 = Integer.parseInt(elements[2]);
            // Realizar la operación según el operador
            switch (elements[1]) {
                case "+":
                    return calculator.add(operand1, operand2);
                case "-":
                    return calculator.subtract(operand1, operand2);
                case "*":
                    return calculator.multiply(operand1, operand2);
                case "/":
                    return calculator.divide(operand1, operand2);
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        }
    }

    public static void main(String[] args) {
        new App();
    }
}