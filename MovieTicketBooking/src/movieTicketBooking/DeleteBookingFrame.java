package movieTicketBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBookingFrame extends JFrame {

    public DeleteBookingFrame(Connection conn) {
        setTitle("Delete Booking");
        setSize(400, 200); // Increase the size
        setLayout(null);
        setLocationRelativeTo(null); // Open in the center of the screen

        // Set background color (CSS-like styling)
        getContentPane().setBackground(new Color(240, 230, 255));

        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(50, 50, 100, 25);
        add(bookingIdLabel);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(150, 50, 180, 25);
        add(bookingIdField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(150, 100, 100, 30);
        deleteButton.setBackground(new Color(255, 102, 102)); // Button color
        deleteButton.setForeground(Color.WHITE); // Text color
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bookingId = Integer.parseInt(bookingIdField.getText());
                deleteBooking(conn, bookingId);
                JOptionPane.showMessageDialog(null, "Booking Deleted!");
                dispose();
            }
        });

        setVisible(true);
    }

    // Method to delete booking
    public void deleteBooking(Connection conn, int bookingId) {
        String query = "DELETE FROM bookings WHERE booking_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, bookingId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
