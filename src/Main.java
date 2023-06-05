import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        showWelcomeDialog();
    }

    private static void showWelcomeDialog() {
        int option = JOptionPane.showConfirmDialog(null, "Добро пожаловать! Хотите зарегистрироваться в программе?",
                "Регистрация", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            showLoginDialog();
        } else {
            System.exit(0);
        }
    }

    private static void showLoginDialog() {
        String login = "";
        while (login.length() <= 5 || login.contains(" ")) {
            login = JOptionPane.showInputDialog(null, "Введите логин (длина должна быть больше 5 символов и не должен содержать пробелов):",
                    "Логин", JOptionPane.PLAIN_MESSAGE);
            if (login == null) {
                System.exit(0);
            }
        }
        showPasswordDialog();
    }

    private static void showPasswordDialog() {
        String password = "";
        while (!isValidPassword(password)) {
            JPasswordField passwordField = new JPasswordField();
            Object[] message = {"Введите пароль (длина должна быть больше 8 символов, не должен содержать пробелов, " +
                    "должен содержать хотя бы одну цифру и хотя бы одну букву):", passwordField};
            int option = JOptionPane.showConfirmDialog(null, message, "Пароль", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.CANCEL_OPTION) {
                System.exit(0);
            }
            password = String.valueOf(passwordField.getPassword());
        }
        showConfirmPasswordDialog(password);
    }

    private static void showConfirmPasswordDialog(String password) {
        String confirmPassword = "";
        while (!password.equals(confirmPassword)) {
            JPasswordField passwordField = new JPasswordField();
            Object[] message = {"Повторите пароль:", passwordField};
            int option = JOptionPane.showConfirmDialog(null, message, "Повтор пароля", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.CANCEL_OPTION) {
                System.exit(0);
            }
            confirmPassword = String.valueOf(passwordField.getPassword());
        }
        showRegistrationSuccessDialog();
    }

    private static void showRegistrationSuccessDialog() {
        JOptionPane.showMessageDialog(null, "Регистрация успешно завершена!", "Успешная регистрация",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.contains(" ")) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) {
                hasLetter = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (hasLetter && hasDigit) {
                return true;
            }
        }
        return false;
    }
}