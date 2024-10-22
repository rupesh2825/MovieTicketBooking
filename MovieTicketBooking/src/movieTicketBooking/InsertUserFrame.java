package movieTicketBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertUserFrame extends JFrame {

    public InsertUserFrame(Connection conn) {
        setTitle("Insert User");
        setSize(400, 250); // Increased size
        setLocationRelativeTo(null); // Center the frame
        setLayout(null);
        getContentPane().setBackground(new Color(230, 240, 255)); // Background color

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 100, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 70, 100, 25);
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 200, 25);
        add(emailField);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(150, 120, 100, 30);
        insertButton.setBackground(new Color(102, 178, 255)); // Button color
        insertButton.setForeground(Color.WHITE); // Text color
        add(insertButton);

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = nameField.getText();
                String email = emailField.getText();
                insertUser(conn, userName, email);
                JOptionPane.showMessageDialog(null, "User Inserted!");
                dispose();
            }
        });

        setVisible(true);
    }

    // Method to insert a user
    public void insertUser(Connection conn, String userName, String email) {
        String query = "INSERT INTO users (user_name, email) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
