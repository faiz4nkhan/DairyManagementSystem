package logout;

import javax.swing.*;

import ui.MainMenu;

import java.awt.*;

public class Logout extends JFrame {

    public Logout() {
        setTitle("Logout");
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Logging out...");

        add(label);

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

        // Add logout functionality (e.g., close app)
        System.exit(0); // Exit the application immediately

        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

