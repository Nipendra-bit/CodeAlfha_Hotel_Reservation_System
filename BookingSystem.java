package mypack;


import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    private Hotel hotel;
    private PaymentProcessing paymentProcessor;

    public BookingSystem() {
        hotel = new Hotel();
        paymentProcessor = new PaymentProcessing();
    }

    public void searchRooms() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter room category: ");
        String category = sc.nextLine();
        List<Room> results = hotel.searchRooms(category);
        // display search results
    }

    public void bookRoom() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter room number: ");
        int roomNumber = sc.nextInt();
        Room room = hotel.getRoom(roomNumber);
        if (room != null && room.isAvailable()) {
            System.out.print("Enter guest name: ");
            String guestName = sc.nextLine();
            System.out.print("Enter arrival date (yyyy-MM-dd): ");
            int arrivalDate = sc.nextInt();
            System.out.print("Enter departure date (yyyy-MM-dd): ");
            int departureDate = sc.nextInt();
            Reservation reservation = new Reservation(guestName, room, arrivalDate, departureDate);
            paymentProcessor.processPayment(reservation);
            room.setAvailable(false);
            System.out.println("Booking confirmed!");
        } else {
            System.out.println("Room not available");
        }
    }

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.searchRooms();
        bookingSystem.bookRoom();
    }
}

