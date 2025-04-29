package ui;

import javax.swing.*;
import java.awt.*;
import customer.CustomerManagement;
import milkentry.MilkEntry;
import billing.Billing;
import Settings.Settings;
import Inventory.Inventory;
import SupplierManagement.SupplierManagement;



public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Dairy Management System");
        setSize(600, 500);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel - Title and Login Button
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(70, 130, 180)); // Steel Blue Color

        JLabel titleLabel = new JLabel("DAIRY MANAGEMENT SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.setFocusPainted(false);
        topPanel.add(loginButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Action to open Login Page
        loginButton.addActionListener(e -> {
            new LoginPage();  // Replace with your login page class
            dispose();
        });

        // Center Panel - Menu Buttons
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        String[] buttons = {
            "Customer Management",
            "Milk Entry",
            "Billing & Reports",
            "Supplier Management",
            "Inventory",
            "Settings"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFocusPainted(false);

            // Add navigation logic
            button.addActionListener(e -> {
                switch (text) {
                    case "Customer Management":
                        new CustomerManagement();
                        break;
                    case "Milk Entry":
                        new MilkEntry();
                        break;
                    case "Billing & Reports":
                        new Billing();
                        break;
                        case "Supplier Management":
                        new SupplierManagement();
                        break;
                    case "Inventory":
                        new Inventory();
                        break;
                    case "Settings":
                        new Settings();
                        break;    
                    
                    }
                dispose();
            });

            centerPanel.add(button);
        }

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel - Summary
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 250, 240));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel summaryTitle = new JLabel("Today's Summary:");
        JLabel milkCollected = new JLabel("- Total Milk Collected: 120 Litres");
        JLabel totalCustomers = new JLabel("- Total Customers: 15");
        JLabel todaysRevenue = new JLabel("- Today's Revenue: ₹3,600");

        summaryTitle.setFont(new Font("Arial", Font.BOLD, 14));
        milkCollected.setFont(new Font("Arial", Font.PLAIN, 13));
        totalCustomers.setFont(new Font("Arial", Font.PLAIN, 13));
        todaysRevenue.setFont(new Font("Arial", Font.PLAIN, 13));

        bottomPanel.add(summaryTitle);
        bottomPanel.add(milkCollected);
        bottomPanel.add(totalCustomers);
        bottomPanel.add(todaysRevenue);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
