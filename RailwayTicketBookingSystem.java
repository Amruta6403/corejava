package corejava;


import java.util.Scanner;

// Ticket Booking class
class TicketBooking {

    private int availableSeats = 15;

    // Synchronized method to prevent double booking
    synchronized void bookSeats(String customerName, int seats) {

        System.out.println("\n" + customerName +
                " is requesting " + seats + " seats...");

        if (seats <= 0) {

            System.out.println("Booking failed: " +
                    "Seat count must be greater than zero.");

        } 
        else if (seats <= availableSeats) {

            availableSeats = availableSeats - seats;

            System.out.println("Booking successful!");
            System.out.println(customerName + " booked " +
                    seats + " seats successfully.");

            System.out.println("Remaining seats: " + availableSeats);

        } 
        else {

            System.out.println("Booking failed: Not enough seats available.");
            System.out.println("Currently available seats: " + availableSeats);
        }
    }

    // Display final available seats
    void displayAvailableSeats() {

        System.out.println("\n========== BOOKING SUMMARY ==========");
        System.out.println("Final available seats: " + availableSeats);
        System.out.println("=====================================");
    }
}

// Customer thread class
class RailwayCustomer extends Thread {

    private TicketBooking booking;
    private String customerName;
    private int seatsRequired;

    RailwayCustomer(TicketBooking booking,
                    String customerName, int seatsRequired) {

        this.booking = booking;
        this.customerName = customerName;
        this.seatsRequired = seatsRequired;
    }

    @Override
    public void run() {

        booking.bookSeats(customerName, seatsRequired);
    }
}

// Main class
public class RailwayTicketBookingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicketBooking booking = new TicketBooking();

        System.out.println("=====================================");
        System.out.println("     RAILWAY TICKET RESERVATION");
        System.out.println("=====================================");
        System.out.println("Total available seats: 15");

        // Taking input from customers
        System.out.print("\nEnter seats required by Customer 1: ");
        int seats1 = sc.nextInt();

        System.out.print("Enter seats required by Customer 2: ");
        int seats2 = sc.nextInt();

        // Creating customer threads
        RailwayCustomer customer1 =
                new RailwayCustomer(booking, "Customer 1", seats1);

        RailwayCustomer customer2 =
                new RailwayCustomer(booking, "Customer 2", seats2);

        System.out.println("\nProcessing booking requests...");

        // Starting both threads
        customer1.start();
        customer2.start();

        try {

            // Waiting for both customers to complete booking
            customer1.join();
            customer2.join();

        } 
        catch (InterruptedException e) {

            System.out.println("Booking process interrupted.");
            Thread.currentThread().interrupt();
        }

        // Display final booking status
        booking.displayAvailableSeats();

        sc.close();
    }
}
