import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем окно
                JFrame frame = new JFrame("Выбор цвета");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);

                // Создаем надпись "Ответ"
                JLabel answerLabel = new JLabel("Ответ:");

                // Создаем выпадающий список с названиями любимых цветов
                String[] colors = {"Красный", "Зеленый", "Синий"};
                JComboBox<String> colorComboBox = new JComboBox<>(colors);

                // Создаем чекбокс и текстовое поле для ввода своего цвета
                JCheckBox customColorCheckBox = new JCheckBox("Свой цвет:");
                JTextField customColorTextField = new JTextField(10);
                customColorTextField.setEnabled(false);

                // Обработчик события изменения состояния чекбокса
                customColorCheckBox.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        customColorTextField.setEnabled(customColorCheckBox.isSelected());
                    }
                });

                // Создаем кнопку "Ответить"
                JButton answerButton = new JButton("Ответить");

                // Обработчик события нажатия на кнопку "Ответить"
                answerButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedColor;
                        if (customColorCheckBox.isSelected()) {
                            selectedColor = customColorTextField.getText();
                        } else {
                            selectedColor = (String) colorComboBox.getSelectedItem();
                        }
                        answerLabel.setText("Ответ: " + selectedColor);
                    }
                });

                // Создаем панель для размещения элементов
                JPanel panel = new JPanel();
                panel.add(colorComboBox);
                panel.add(customColorCheckBox);
                panel.add(customColorTextField);
                panel.add(answerButton);
                panel.add(answerLabel);

                // Добавляем панель в окно
                frame.getContentPane().add(panel);

                // Отображаем окно
                frame.setLocationRelativeTo(null); // Размещаем окно по центру экрана
                frame.setVisible(true);
            }
        });
    }
}