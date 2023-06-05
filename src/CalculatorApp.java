import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorApp {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private JButton decimalButton;
    private double firstNumber;
    private double secondNumber;
    private double result;
    private String operator;

    public CalculatorApp() {
        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 30, 240, 30);
        frame.add(textField);

        numberButtons = new JButton[10];
        operatorButtons = new JButton[4];

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");

        equalsButton = new JButton("=");
        clearButton = new JButton("С");
        decimalButton = new JButton(".");

        numberButtons[0].setBounds(30, 90, 50, 50);
        frame.add(numberButtons[0]);

        decimalButton.setBounds(90, 90, 50, 50);
        frame.add(decimalButton);

        clearButton.setBounds(150, 90, 50, 50);
        frame.add(clearButton);

        for (int i = 1; i < numberButtons.length; i++) {
            int row = (i - 1) / 3;
            int col = (i - 1) % 3;
            numberButtons[i].setBounds(30 + col * 60, 150 + row * 60, 50, 50);
            frame.add(numberButtons[i]);
        }

        for (int i = 0; i < operatorButtons.length; i++) {
            operatorButtons[i].setBounds(210, 150 + i * 60, 50, 50);
            frame.add(operatorButtons[i]);
        }

        equalsButton.setBounds(90, 330, 130, 50);
        frame.add(equalsButton);

        frame.setVisible(true);
        frame.setResizable(false);

        for (int i = 0; i < numberButtons.length; i++) {
            int number = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + number);
                }
            });
        }

        decimalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().contains(".")) {
                    textField.setText(textField.getText() + ".");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        for (int i = 0; i < operatorButtons.length; i++) {
            int index = i;
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    firstNumber = Double.parseDouble(textField.getText());
                    operator = operatorButtons[index].getText();
                    textField.setText("");
                }
            });
        }

        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondNumber = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            result = 0; // Здесь можно добавить обработку деления на 0
                        } else {
                            result = firstNumber / secondNumber;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApp();
            }
        });
    }
}