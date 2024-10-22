package movieTicketBooking;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayBookingFrame extends JFrame {

    public DisplayBookingFrame(Connection conn) {
        setTitle("Display All Bookings");
        setSize(600, 500); // Increase the size
        setLayout(null);
        setLocationRelativeTo(null); // Open in the center of the screen

        // Set background color (CSS-like styling)
        getContentPane().setBackground(new Color(255, 245, 230));

        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(10, 10, 560, 440);
        displayArea.setEditable(false);
        displayArea.setBackground(Color.WHITE);
        displayArea.setForeground(Color.DARK_GRAY);
        displayArea.setFont(new Font("Serif", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(10, 10, 560, 440);
        add(scrollPane);

        displayBookings(conn, displayArea);

        setVisible(true);
    }

    // Method to display all bookings
    public void displayBookings(Connection conn, JTextArea displayArea) {
        String query = "SELECT b.booking_id, b.movie_name, b.seats, u.user_name FROM bookings b " +
                       "JOIN users u ON b.user_id = u.user_id";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            StringBuilder bookings = new StringBuilder("Current Bookings:\n\n");
            while (rs.next()) {
                bookings.append("Booking ID: ").append(rs.getInt("booking_id"))
                        .append("\nMovie Name: ").append(rs.getString("movie_name"))
                        .append("\nUser Name: ").append(rs.getString("user_name"))
                        .append("\nSeats: ").append(rs.getInt("seats"))
                        .append("\n\n");
            }
            displayArea.setText(bookings.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
