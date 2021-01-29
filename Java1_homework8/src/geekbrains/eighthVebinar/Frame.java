package geekbrains.eighthVebinar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Frame extends JFrame {
    private final JTextField textField;
    private char symbol;
    private double tempDigit;
    private double total;
    private boolean isFirstDigit;


    public void action(ActionEvent event) {
        textField.setText (textField.getText()+event.getActionCommand());
        if (textField.getText().contains("++"))
            textField.setText("Error");
        else if (textField.getText().contains("--"))
            textField.setText("Error");
        else if (textField.getText().contains("**"))
            textField.setText("Error");
        else if (textField.getText().contains("//"))
            textField.setText("Error");
        else if (textField.getText().contains("+-"))
            textField.setText("Error");
        else if (textField.getText().contains("+*"))
            textField.setText("Error");
        else if (textField.getText().contains("+/"))
            textField.setText("Error");
        else if (textField.getText().contains("-+"))
            textField.setText("Error");
        else if (textField.getText().contains("-*"))
            textField.setText("Error");
        else if (textField.getText().contains("-/"))
            textField.setText("Error");
        else if (textField.getText().contains("*+"))
            textField.setText("Error");
        else if (textField.getText().contains("*-"))
            textField.setText("Error");
        else if (textField.getText().contains("*/"))
            textField.setText("Error");
        else if (textField.getText().contains("/+"))
            textField.setText("Error");
        else if (textField.getText().contains("/-"))
            textField.setText("Error");
        else if (textField.getText().contains("/*"))
            textField.setText("Error");

    }

    public void square (ActionEvent event) {
        String text = textField.getText();
        double digit = Double.valueOf(text);

        total += Math.pow(digit,2);
        tempDigit = 0;
        textField.setText(String.valueOf(total));
        total = 0;
    }

    public void sqrt (ActionEvent event) {
        String text = textField.getText();
        double digit = Double.valueOf(text);

        total += Math.sqrt(digit);
        tempDigit = 0;
        textField.setText(String.valueOf(total));
        total = 0;
    }

    public void calculation(ActionEvent event) {

        String text = textField.getText();
        String digit = "";

        for (char c : text.toCharArray()) {
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                symbol = c;

                double currentValue = Double.valueOf(digit);
                tempDigit += currentValue;
                digit = "";
                continue;
            }
            digit += c;
        }

        switch (this.symbol) {

            case '+':
            total += Double.parseDouble(digit) + tempDigit;
            tempDigit = 0;
            textField.setText(String.valueOf(total));
            total = 0;
            break;

            case '-':
                total += tempDigit - Double.parseDouble(digit);
                tempDigit = 0;
                textField.setText(String.valueOf(total));
                total = 0;
                break;

            case '*':
                total += Double.parseDouble(digit) * tempDigit;
                tempDigit = 0;
                textField.setText(String.valueOf(total));
                total = 0;
                break;

            case '/':
                total += tempDigit / Double.parseDouble(digit);
                tempDigit = 0;
                textField.setText(String.valueOf(total));
                total = 0;
                break;
        }
    }

    public void empty(ActionEvent e) {
        textField.setText(String.valueOf(""));
    }


    public Frame() {

        setTitle("Calculator");
        setBounds(700, 300, 300, 310);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        tempDigit = 0;
        isFirstDigit = true;

        JPanel jPanel = new JPanel();

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        JButton minusButton = new JButton("-");
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        JButton multiplicationButton = new JButton("*");
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        JButton devideButton = new JButton("/");
        devideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculation(e);
            }
        });

        JButton dotButton = new JButton(".");
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        JButton squareButton = new JButton("x^2");
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                square(e);
            }
        });

        JButton sqrtButton = new JButton("sqrt");
        sqrtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sqrt(e);
            }
        });

        JButton emptyField = new JButton("clear input field".toUpperCase(Locale.ROOT));
        emptyField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empty(e);
            }
        });

        textField = new JTextField(25);
        textField.setEditable(false);

        jPanel.add(textField);
        JButton[] jButtons = new JButton[9];
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(String.valueOf(i + 1));
            jButtons[i].setPreferredSize(new Dimension(50,50));
            jButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(e);
                }
            });
            jPanel.add(jButtons[i]);
        }
        jPanel.add(zeroButton);
        zeroButton.setPreferredSize(new Dimension(50,50));
        jPanel.add(minusButton);
        minusButton.setPreferredSize(new Dimension(50,50));
        jPanel.add(plusButton);
        plusButton.setPreferredSize(new Dimension(50,50));
        jPanel.add(multiplicationButton);
        multiplicationButton.setPreferredSize(new Dimension(50,50));
        jPanel.add(devideButton);
        devideButton.setPreferredSize(new Dimension(50,50));
        jPanel.add(equalsButton);
        equalsButton.setPreferredSize(new Dimension(50,50));
        jPanel.add(dotButton);
        dotButton.setPreferredSize((new Dimension(86,30)));
        jPanel.add(squareButton);
        squareButton.setPreferredSize(new Dimension(87,30));
        jPanel.add(sqrtButton);
        sqrtButton.setPreferredSize(new Dimension(86,30));
        jPanel.add(emptyField);
        emptyField.setPreferredSize(new Dimension(270,30));


        add(jPanel);

        setVisible(true);

    }

}

