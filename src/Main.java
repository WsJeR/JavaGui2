import javax.swing.*;
import java.awt.*;


public class Main extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем окно
                JFrame frame = new JFrame("Пример метки");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);

                // Создаем метку
                JLabel label = new JLabel("Моя первая надпись!");
                label.setFont(new Font("Arial", Font.ITALIC, 50));

                // Размещаем метку в центре окна
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);

                // Добавляем метку в окно
                frame.getContentPane().add(label);

                // Отображаем окно
                frame.setLocationRelativeTo(null); // Размещаем окно по центру экрана
                frame.setVisible(true);
            }
        });
    }
}