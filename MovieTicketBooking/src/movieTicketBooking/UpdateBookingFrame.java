package movieTicketBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBookingFrame extends JFrame {

    public UpdateBookingFrame(Connection conn) {
        setTitle("Update Booking");
        setSize(400, 250); // Increase the size
        setLayout(null);
        setLocationRelativeTo(null); // Open in the center of the screen

        // Set background color (CSS-like styling)
        getContentPane().setBackground(new Color(230, 240, 255));

        JLabel bookingIdLabel = new JLabel("Booking ID:");
        bookingIdLabel.setBounds(50, 30, 100, 25);
        add(bookingIdLabel);

        JTextField bookingIdField = new JTextField();
        bookingIdField.setBounds(150, 30, 180, 25);
        add(bookingIdField);

        JLabel seatsLabel = new JLabel("New Seats:");
        seatsLabel.setBounds(50, 70, 100, 25);
        add(seatsLabel);

        JTextField seatsField = new JTextField();
        seatsField.setBounds(150, 70, 180, 25);
        add(seatsField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(150, 120, 100, 30);
        updateButton.setBackground(new Color(102, 178, 255)); // Button color
        updateButton.setForeground(Color.WHITE); // Text color
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bookingId = Integer.parseInt(bookingIdField.getText());
                int newSeats = Integer.parseInt(seatsField.getText());
                updateBooking(conn, bookingId, newSeats);
                JOptionPane.showMessageDialog(null, "Booking Updated!");
                dispose();
            }
        });

        setVisible(true);
    }

    // Method to update booking
    public void updateBooking(Connection conn, int bookingId, int newSeats) {
        String query = "UPDATE bookings SET seats = ? WHERE booking_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, newSeats);
            pstmt.setInt(2, bookingId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
