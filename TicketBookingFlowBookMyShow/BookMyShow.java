package TicketBookingFlowBookMyShow;

import java.util.*;

// Movie Class
class Movie {
    private String name;
    private List<Show> shows;

    public Movie(String name) {
        this.name = name;
        this.shows = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }
}

// Show Class
class Show {
    private String showTime;
    private List<Seat> seats;

    public Show(String showTime, int seatCount) {
        this.showTime = showTime;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(i));
        }
    }

    public String getShowTime() {
        return showTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat getAvailableSeat(int seatNumber) {
        if (seats.get(seatNumber - 1).isAvailable()) {
            return seats.get(seatNumber - 1);
        }
        return null;
    }
}

// Seat Class
class Seat {
    private int seatNumber;
    private boolean isAvailable;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = true;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        this.isAvailable = false;
    }
}

// Payment Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// CreditCard Payment Class
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// PayPal Payment Class
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Booking Class
class Booking {
    private List<Seat> seats;
    private Show show;
    private double totalPrice;

    public Booking(Show show) {
        this.show = show;
        this.seats = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addSeat(Seat seat) {
        seat.book();
        seats.add(seat);
        totalPrice += 10.0; // assuming each seat costs $10
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void confirmBooking(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(totalPrice);
        System.out.println("Booking confirmed for show: " + show.getShowTime());
        System.out.println("Seats booked: " + seats);
    }
}

// User Class
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void bookTicket(Movie movie, String showTime, int seatNumber, PaymentStrategy paymentStrategy) {
        Show selectedShow = null;
        for (Show show : movie.getShows()) {
            if (show.getShowTime().equals(showTime)) {
                selectedShow = show;
                break;
            }
        }

        if (selectedShow != null) {
            Seat seat = selectedShow.getAvailableSeat(seatNumber);
            if (seat != null) {
                Booking booking = new Booking(selectedShow);
                booking.addSeat(seat);
                booking.confirmBooking(paymentStrategy);
            } else {
                System.out.println("Seat not available.");
            }
        } else {
            System.out.println("Show not found.");
        }
    }
}

// Main Class
public class BookMyShow {
    public static void main(String[] args) {
        Movie movie = new Movie("Inception");
        movie.addShow(new Show("10:00 AM", 50));
        movie.addShow(new Show("01:00 PM", 50));

        User user = new User("John Doe");

        // Booking a ticket
        user.bookTicket(movie, "10:00 AM", 5, new CreditCardPayment("1234-5678-9012-3456"));
        user.bookTicket(movie, "01:00 PM", 10, new PayPalPayment("johndoe@example.com"));
    }
}

