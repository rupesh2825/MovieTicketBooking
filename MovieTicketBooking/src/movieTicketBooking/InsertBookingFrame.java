package movieTicketBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertBookingFrame extends JFrame {

    public InsertBookingFrame(Connection conn) {
        setTitle("Insert Booking");
        setSize(400, 300); // Increased size
        setLocationRelativeTo(null); // Center the frame
        setLayout(null);
        getContentPane().setBackground(new Color(255, 240, 230)); // Background color

        JLabel movieLabel = new JLabel("Movie:");
        movieLabel.setBounds(50, 30, 100, 25);
        add(movieLabel);

        JTextField movieField = new JTextField();
        movieField.setBounds(150, 30, 200, 25);
        add(movieField);

        JLabel seatsLabel = new JLabel("Seats:");
        seatsLabel.setBounds(50, 70, 100, 25);
        add(seatsLabel);

        JTextField seatsField = new JTextField();
        seatsField.setBounds(150, 70, 200, 25);
        add(seatsField);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(50, 110, 100, 25);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 110, 200, 25);
        add(userField);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(150, 160, 100, 30);
        insertButton.setBackground(new Color(102, 178, 255)); // Button color
        insertButton.setForeground(Color.WHITE); // Text color
        add(insertButton);

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String movieName = movieField.getText();
                int seats = Integer.parseInt(seatsField.getText());
                int userId = Integer.parseInt(userField.getText());
                insertBooking(conn, movieName, seats, userId);
                JOptionPane.showMessageDialog(null, "Booking Inserted!");
                dispose();
            }
        });

        setVisible(true);
    }

    // Method to insert a booking
    public void insertBooking(Connection conn, String movieName, int seats, int userId) {
        String query = "INSERT INTO bookings (movie_name, seats, user_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, movieName);
            pstmt.setInt(2, seats);
            pstmt.setInt(3, userId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
