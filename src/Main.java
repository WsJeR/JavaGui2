import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем окно
                JFrame frame = new JFrame("Пример метки с изменяемым размером шрифта");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);

                // Создаем метку
                JLabel label = new JLabel("Моя первая надпись!");
                label.setFont(new Font("Arial", Font.ITALIC, 50));

                // Создаем слайдер для изменения размера шрифта
                JSlider slider = new JSlider(JSlider.HORIZONTAL, 5, 100, 50);
                slider.setMajorTickSpacing(10);
                slider.setMinorTickSpacing(5);
                slider.setPaintTicks(true);
                slider.setPaintLabels(true);
                slider.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        int fontSize = slider.getValue();
                        label.setFont(label.getFont().deriveFont((float) fontSize));
                    }
                });

                // Создаем панель для размещения метки и слайдера
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(label, BorderLayout.CENTER);
                panel.add(slider, BorderLayout.SOUTH);

                // Добавляем панель в окно
                frame.getContentPane().add(panel);

                // Отображаем окно
                frame.setLocationRelativeTo(null); // Размещаем окно по центру экрана
                frame.setVisible(true);
            }
        });
    }
}