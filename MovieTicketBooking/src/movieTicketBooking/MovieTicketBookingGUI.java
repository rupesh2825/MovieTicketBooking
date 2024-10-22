package movieTicketBooking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class MovieTicketBookingGUI extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/movie_booking";
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "ra.one"; // Your MySQL password
    private Connection conn;

    public MovieTicketBookingGUI() {
        try {
            // Establishing connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the main frame
        setTitle("Movie Ticket Booking System");
        setSize(500, 500); // Increase size
        setLayout(null);
        setLocationRelativeTo(null); // Open in the center of the screen
        getContentPane().setBackground(new Color(255, 240, 230)); // Background color

        // Buttons for different operations
        JButton insertUserButton = new JButton("Insert User");
        insertUserButton.setBounds(150, 50, 200, 40);
        insertUserButton.setBackground(new Color(102, 178, 255)); // Button color
        insertUserButton.setForeground(Color.WHITE); // Text color
        add(insertUserButton);

        JButton insertBookingButton = new JButton("Insert Booking");
        insertBookingButton.setBounds(150, 110, 200, 40);
        insertBookingButton.setBackground(new Color(102, 178, 255));
        insertBookingButton.setForeground(Color.WHITE);
        add(insertBookingButton);

        JButton updateBookingButton = new JButton("Update Booking");
        updateBookingButton.setBounds(150, 170, 200, 40);
        updateBookingButton.setBackground(new Color(255, 178, 102));
        updateBookingButton.setForeground(Color.WHITE);
        add(updateBookingButton);

        JButton deleteBookingButton = new JButton("Delete Booking");
        deleteBookingButton.setBounds(150, 230, 200, 40);
        deleteBookingButton.setBackground(new Color(255, 102, 102));
        deleteBookingButton.setForeground(Color.WHITE);
        add(deleteBookingButton);

        JButton displayBookingButton = new JButton("Display All Bookings");
        displayBookingButton.setBounds(150, 290, 200, 40);
        displayBookingButton.setBackground(new Color(178, 255, 102));
        displayBookingButton.setForeground(Color.DARK_GRAY);
        add(displayBookingButton);

        // Button actions
        insertUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InsertUserFrame(conn);
            }
        });

        insertBookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InsertBookingFrame(conn);
            }
        });

        updateBookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UpdateBookingFrame(conn);
            }
        });

        deleteBookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteBookingFrame(conn);
            }
        });

        displayBookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DisplayBookingFrame(conn);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MovieTicketBookingGUI();
    }
}
