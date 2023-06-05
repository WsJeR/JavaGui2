import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем окно
                JFrame frame = new JFrame("Запись строк");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);

                // Создаем JTextArea и добавляем в JScrollPane
                JTextArea textArea = new JTextArea(10, 20);
                JScrollPane scrollPane = new JScrollPane(textArea);

                // Создаем JTextField для ввода строки
                JTextField textField = new JTextField(20);

                // Создаем кнопку "Записать"
                JButton writeButton = new JButton("Записать");

                // Обработчик события нажатия на кнопку "Записать"
                writeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String text = textField.getText();
                        if (!text.isEmpty()) {
                            textArea.append(text + "\n");
                            textField.setText("");
                        }
                    }
                });

                // Создаем панель для размещения элементов
                JPanel panel = new JPanel();
                panel.add(textField);
                panel.add(writeButton);
                panel.add(scrollPane);

                // Добавляем панель в окно
                frame.getContentPane().add(panel);

                // Отображаем окно
                frame.setLocationRelativeTo(null); // Размещаем окно по центру экрана
                frame.setVisible(true);
            }
        });
    }
}