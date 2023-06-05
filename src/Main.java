import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем окно
                JFrame frame = new JFrame("Выбор количества книг");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);

                // Создаем надпись "Ответ"
                JLabel answerLabel = new JLabel("Ответ:");

                // Создаем элемент JSpinner для выбора количества книг
                SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
                JSpinner spinner = new JSpinner(spinnerModel);

                // Создаем кнопку "Ответить"
                JButton answerButton = new JButton("Ответить");

                // Обработчик события нажатия на кнопку "Ответить"
                answerButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int bookCount = (int) spinner.getValue();
                        answerLabel.setText("Ответ: " + bookCount);
                    }
                });

                // Создаем панель для размещения элементов
                JPanel panel = new JPanel();
                panel.add(spinner);
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