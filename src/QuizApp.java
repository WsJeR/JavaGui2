import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] answerOptions;
    private JButton submitButton;
    private int currentQuestionIndex;
    private int score;

    // Вопросы и ответы для викторины
    private String[] questions = {
            "Какой год сейчас?",
            "Сколько планет в Солнечной системе?",
            "Как называется столица Франции?"
    };

    private String[][] choices = {
            {"2020", "2021", "2022", "2023"},
            {"6", "7", "8", "9"},
            {"Париж", "Мадрид", "Лондон", "Рим"}
    };

    private int[] correctAnswers = {1, 3, 0};

    public QuizApp() {
        super("Викторина");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel questionPanel = new JPanel(new FlowLayout());
        questionLabel = new JLabel(questions[0]);
        questionPanel.add(questionLabel);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        ButtonGroup buttonGroup = new ButtonGroup();
        answerOptions = new JRadioButton[4];
        for (int i = 0; i < answerOptions.length; i++) {
            answerOptions[i] = new JRadioButton(choices[0][i]);
            buttonGroup.add(answerOptions[i]);
            optionsPanel.add(answerOptions[i]);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("Ответить");
        buttonPanel.add(submitButton);

        add(questionPanel, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showNextQuestion();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void checkAnswer() {
        if (answerOptions[correctAnswers[currentQuestionIndex]].isSelected()) {
            score++;
        }
    }

    private void showNextQuestion() {
        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);

            for (int i = 0; i < answerOptions.length; i++) {
                answerOptions[i].setText(choices[currentQuestionIndex][i]);
                answerOptions[i].setSelected(false);
            }
        } else {
            showResult();
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Вы завершили викторину.\nВаш результат: " + score + " из " + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuizApp quizApp = new QuizApp();
                quizApp.setVisible(true);
            }
        });
    }
}