package Inventory;



import javax.swing.*;

import ui.MainMenu;

import java.awt.*;

public class Inventory extends JFrame {

    public Inventory() {
        setTitle("Inventory Management");
        setSize(500, 350);
        setLayout(new BorderLayout());
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

        JLabel lblTitle = new JLabel("Inventory Overview", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(lblTitle, BorderLayout.NORTH);

        String[] columns = {"Item Name", "Quantity", "Unit"};
        String[][] data = {
            {"Milk Cans", "50", "Units"},
            {"Packaging Bags", "200", "Pieces"},
            {"Cleaning Solutions", "10", "Litres"}
        };

        JTable inventoryTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(inventoryTable);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
