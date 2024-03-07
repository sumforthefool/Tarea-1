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

    public static void main(String[] args) {
        new App();
    }

}