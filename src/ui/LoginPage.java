package ui;



import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPage() {
        setTitle("Dairy Management Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center screen

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

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkLogin();
            }
        });

        setVisible(true);
    }

    private void checkLogin() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dairy_management", "admin", "admin123"
            );
            
            // Query to check if the username and password exist
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);  // Set the username from the input field
            stmt.setString(2, password);  // Set the password from the input field
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // User found, login successful
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();  // Close the login page
                new MainMenu();  // Open the main menu (or whatever your next screen is)
            } else {
                // No matching user found
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
            
            // Close the connection
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
