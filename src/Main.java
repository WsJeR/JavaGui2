import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем окно
                JFrame frame = new JFrame("Кликер");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);

                // Создаем кнопку
                JButton button = new JButton("Нажми меня!");

                // Создаем надпись
                JLabel label = new JLabel("Количество нажатий: 0");

                // Обработчик события нажатия на кнопку
                button.addActionListener(new ActionListener() {
                    int count = 0;

                    public void actionPerformed(ActionEvent e) {
                        count++;
                        label.setText("Количество нажатий: " + count);
                    }
                });

                // Создаем панель для размещения кнопки и надписи
                JPanel panel = new JPanel();
                panel.add(button);
                panel.add(label);

                // Добавляем панель в окно
                frame.getContentPane().add(panel);

                // Отображаем окно
                frame.setLocationRelativeTo(null); // Размещаем окно по центру экрана
                frame.setVisible(true);
            }
        });
    }
}