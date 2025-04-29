package SupplierManagement;


import ui.MainMenu;

import javax.swing.*;
import java.awt.*;

public class SupplierManagement extends JFrame {

    public SupplierManagement() {
        setTitle("Supplier Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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

        // CENTER PANEL with your page content
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Supplier Management Content Here"));
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
