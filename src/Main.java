import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем окно
                JFrame frame = new JFrame("Выбор времени года");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 200);

                // Создаем надпись "Ответ"
                JLabel answerLabel = new JLabel("Ответ:");

                // Создаем радиокнопки для выбора времени года
                JRadioButton springRadioButton = new JRadioButton("Весна");
                JRadioButton summerRadioButton = new JRadioButton("Лето");
                JRadioButton autumnRadioButton = new JRadioButton("Осень");
                JRadioButton winterRadioButton = new JRadioButton("Зима");

                // Объединяем радиокнопки в одну группу
                ButtonGroup seasonButtonGroup = new ButtonGroup();
                seasonButtonGroup.add(springRadioButton);
                seasonButtonGroup.add(summerRadioButton);
                seasonButtonGroup.add(autumnRadioButton);
                seasonButtonGroup.add(winterRadioButton);

                // Создаем кнопку "Ответить"
                JButton answerButton = new JButton("Ответить");

                // Обработчик события нажатия на кнопку "Ответить"
                answerButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedSeason;
                        if (springRadioButton.isSelected()) {
                            selectedSeason = "Весна";
                        } else if (summerRadioButton.isSelected()) {
                            selectedSeason = "Лето";
                        } else if (autumnRadioButton.isSelected()) {
                            selectedSeason = "Осень";
                        } else if (winterRadioButton.isSelected()) {
                            selectedSeason = "Зима";
                        } else {
                            selectedSeason = "Ничего не выбрано";
                        }
                        answerLabel.setText("Ответ: " + selectedSeason);
                    }
                });

                // Создаем панель для размещения элементов
                JPanel panel = new JPanel();
                panel.add(springRadioButton);
                panel.add(summerRadioButton);
                panel.add(autumnRadioButton);
                panel.add(winterRadioButton);
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