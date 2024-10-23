CREATE DATABASE movie_booking;

USE movie_booking;

-- Create 'users' table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100),
    email VARCHAR(100)
);

-- Create 'bookings' table with a reference to 'users' table
CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_name VARCHAR(100),
    seats INT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
