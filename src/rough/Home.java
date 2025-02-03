package rough;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new Home();
    }

    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size to 2/3 of the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width * 2 / 3, screenSize.height * 2 / 3);

        // Use a flexible layout manager
        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(new Color(128, 196, 233));
        setContentPane(contentPane);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Title Label
        JLabel lblTitle = new JLabel("Student Management System");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Book Antiqua", Font.PLAIN, 35));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(lblTitle, gbc);

        // Buttons
        JButton btnDisplayAllRecords = createButton("Display All Records", e -> {
            //new Display();
            dispose();
        });

        JButton btnCustomizedDisplay = createButton("Customized Display", e -> {
            //new CustomizeDisplay();
            dispose();
        });

        JButton btnDeleteRecord = createButton("Delete Record", e -> {
          //  new DeleteRecord();
            dispose();
        });

        JButton btnInsertRecord = createButton("Insert Record", e -> {
           // new InsertRecord();
            dispose();
        });

        JButton btnUpdateRecord = createButton("Update Record", e -> {
           // new UpdateRecord();
            dispose();
        });

        // Add buttons in a grid
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(btnDisplayAllRecords, gbc);

        gbc.gridx = 1;
        contentPane.add(btnCustomizedDisplay, gbc);

        gbc.gridx = 2;
        contentPane.add(btnDeleteRecord, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(btnInsertRecord, gbc);

        gbc.gridx = 1;
        contentPane.add(btnUpdateRecord, gbc);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Helper method to create buttons
    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        button.addActionListener(actionListener);
        return button;
    }
}
