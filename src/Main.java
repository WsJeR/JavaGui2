import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int firstAnswer = JOptionPane.showConfirmDialog(null, "Вы любите программирование?", "Вопрос 1", JOptionPane.YES_NO_OPTION);
        int secondAnswer = JOptionPane.showConfirmDialog(null, "Вы готовы изучать новые технологии?", "Вопрос 2", JOptionPane.YES_NO_OPTION);

        String result;
        if (firstAnswer == JOptionPane.YES_OPTION && secondAnswer == JOptionPane.YES_OPTION) {
            result = "Отлично, продолжайте развиваться!";
        } else if (firstAnswer == JOptionPane.YES_OPTION && secondAnswer == JOptionPane.NO_OPTION) {
            result = "Вы любите программирование, но не готовы изучать новые технологии.";
        } else if (firstAnswer == JOptionPane.NO_OPTION && secondAnswer == JOptionPane.YES_OPTION) {
            result = "Вы не любите программирование, но готовы изучать новые технологии.";
        } else {
            result = "Программирование и новые технологии не для вас.";
        }

        JOptionPane.showMessageDialog(null, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
    }
}