package Settings;

import javax.swing.*;

import ui.MainMenu;

import java.awt.*;

public class Settings extends JFrame {

    public Settings() {
        setTitle("Settings");
        setSize(400, 300);
        setLayout(new GridLayout(4, 1, 10, 10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // TOP PANEL with Back Button
        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("← Back");
        backButton.setFocusPainted(false);
        backButton.setBackground(new Color(70, 130, 180)); // Optional color
        backButton.setForeground(Color.WHITE); // Optional text color

        backButton.addActionListener(e -> {
            new MainMenu();  // Open MainMenu
            dispose();       // Close this page
        });

        topPanel.add(backButton, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);

        JLabel lblTitle = new JLabel("Application Settings", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnProfile = new JButton("Edit Profile");
        JButton btnChangePassword = new JButton("Change Password");
        JButton btnLogout = new JButton("Logout");

        add(lblTitle);
        add(btnProfile);
        add(btnChangePassword);
        add(btnLogout);

        setVisible(true);
    }
}
