import javax.swing.*;

public class Main {
    private static final String[] RESOLUTIONS = {"800x600", "1280x720", "1920x1080"};

    public static void main(String[] args) {
        JFrame resolutionDialog = new JFrame("Выбор разрешения");
        resolutionDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resolutionDialog.setSize(300, 150);
        resolutionDialog.setLocationRelativeTo(null);

        JComboBox<String> resolutionComboBox = new JComboBox<>(RESOLUTIONS);
        resolutionComboBox.setSelectedIndex(0);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            String selectedResolution = (String) resolutionComboBox.getSelectedItem();
            String[] dimensions = selectedResolution.split("x");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);

            JFrame frame = new JFrame("Окно с выбранным разрешением");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(width, height);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            resolutionDialog.dispose();
        });

        JPanel panel = new JPanel();
        panel.add(resolutionComboBox);
        panel.add(okButton);
        resolutionDialog.getContentPane().add(panel);

        resolutionDialog.setVisible(true);
    }
}