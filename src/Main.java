import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Input Dialog Example");
        frame.setSize(300, 200);

        JButton button = new JButton("Открыть диалоговое окно");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Введите ваше имя:");
                if (name != null && !name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ваше имя: " + name);
                }
            }
        });

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}