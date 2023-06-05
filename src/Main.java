import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Listener Example");
        frame.setSize(300, 200);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(frame, "Меня зовут так");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}