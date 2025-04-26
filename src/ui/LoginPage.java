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
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dairy_management", "admin", "1234"
            );
        
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);  // from your input field
            stmt.setString(2, password);  // from your input field
        
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "New User Registered Successfully!");
                dispose(); // Close the login page or open the dashboard
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Register User.");
            }
            
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
