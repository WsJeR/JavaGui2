import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResolutionDialog extends JDialog {
    private final JRadioButton radioButton800x600;
    private final JRadioButton radioButton1024x768;
    private final JRadioButton radioButton1280x1024;
    private final JRadioButton radioButton1920x1080;

    public ResolutionDialog(Frame owner) {
        super(owner, "Выберите разрешение", true);

        ButtonGroup buttonGroup = new ButtonGroup();

        radioButton800x600 = new JRadioButton("800x600");
        radioButton1024x768 = new JRadioButton("1024x768");
        radioButton1280x1024 = new JRadioButton("1280x1024");
        radioButton1920x1080 = new JRadioButton("1920x1080");

        buttonGroup.add(radioButton800x600);
        buttonGroup.add(radioButton1024x768);
        buttonGroup.add(radioButton1280x1024);
        buttonGroup.add(radioButton1920x1080);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(radioButton800x600);
        panel.add(radioButton1024x768);
        panel.add(radioButton1280x1024);
        panel.add(radioButton1920x1080);

        JButton button = new JButton("Выбрать");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resolution = getSelectedResolution();
                if (resolution != -1) {
                    setSizeForResolution(resolution);
                    setVisible(false);
                    dispose();
                    showApplicationWindow();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    private int getSelectedResolution() {
        if (radioButton800x600.isSelected()) {
            return 800;
        } else if (radioButton1024x768.isSelected()) {
            return 1024;
        } else if (radioButton1280x1024.isSelected()) {
            return 1280;
        } else if (radioButton1920x1080.isSelected()) {
            return 1920;
        }
        return -1;
    }

    private void setSizeForResolution(int resolution) {
        switch (resolution) {
            case 800:
                setSize(800, 600);
                break;
            case 1024:
                setSize(1024, 768);
                break;
            case 1280:
                setSize(1280, 1024);
                break;
            case 1920:
                setSize(1920, 1080);
                break;
            default:
                break;
        }
    }

    private void showApplicationWindow() {
        JFrame frame = new JFrame("Мое приложение");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ResolutionDialog dialog = new ResolutionDialog(null);
                dialog.setVisible(true);
            }
        });
    }
}