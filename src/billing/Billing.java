package billing;

import javax.swing.*;

import ui.MainMenu;

import java.awt.*;

public class Billing extends JFrame {

    public Billing() {
        setTitle("Billing");
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Billing Form");
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

        // Add more components here to calculate bills

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

