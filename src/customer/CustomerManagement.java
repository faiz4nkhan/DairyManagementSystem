package customer;

import javax.swing.*;

import ui.MainMenu;

import java.awt.*;

public class CustomerManagement extends JFrame {

    public CustomerManagement() {
        setTitle("Customer Management");
        setLayout(new FlowLayout());

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

        JButton btnAddCustomer = new JButton("Add Customer");
        JButton btnViewCustomers = new JButton("View Customers");

        add(btnAddCustomer);
        add(btnViewCustomers);

        setSize(300, 150);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
