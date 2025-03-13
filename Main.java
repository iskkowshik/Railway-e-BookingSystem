import models.Train;
import models.Booking;

import system.RailwayBookingSystem;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        RailwayBookingSystem bookingSystem = new RailwayBookingSystem();
        Scanner sc = new Scanner(System.in);

        Train train1 = new Train("T1", "StationA", "StationB", 50);

        Train train2 = new Train("T2", "StationC", "StationD", 30);

        Train train3 = new Train("T3", "StationC", "StationD", 30);
        Train train4 = new Train("T4", "StationC", "StationD", 30);

        bookingSystem.addTrain(train1);
        bookingSystem.addTrain(train2);
        bookingSystem.addTrain(train3);

        bookingSystem.addTrain(train4);

        System.out.println("Search trains between stations");
        System.out.print("Enter boarding point: ");
        String boardPoint = sc.next();
        System.out.print("Enter destination: ");
        String destination = sc.next();

        if (bookingSystem.route.containsKey(boardPoint) && bookingSystem.route.get(boardPoint).equals(destination)) {
            for (Map.Entry<String, String> entry : bookingSystem.rsd.entrySet()) {
                String key = entry.getKey().substring(0, 3);
                if (key.equals(boardPoint.substring(boardPoint.length() - 1) + "-" +
                        destination.substring(destination.length() - 1))) {
                    System.out.println(entry.getValue());
                }
            }

            System.out.print("Select train: ");

            String trainNum = sc.next();

            System.out.print("Enter 'yes' to book tickets: ");
            String decision = sc.next();

            if (decision.equalsIgnoreCase("yes")) {
                System.out.print("Enter number of tickets: ");
                int numTickets = sc.nextInt();

                Booking[] bookings = new Booking[numTickets];

                if (bookingSystem.tseat.containsKey(trainNum) && bookingSystem.tseat.get(trainNum) > 0) {
                    for (int i = 0; i < numTickets; i++) {
                        System.out.print("Enter passenger " + (i + 1) + " name: ");
                        String name = sc.next();
                        System.out.print("Enter passenger " + (i + 1) + " age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter berth preference (lb/mb/ub): ");
                        String preference = sc.next();

                        bookings[i] = new Booking(name, age, preference);
                    }

                    System.out.print("Enter mobile number: ");
                    String mobile;
                    do {
                        mobile = sc.next();
                        Booking.mobileNumber = mobile;
                    } while (mobile.length() != 10);

                    Booking.numTickets = numTickets;
                    Booking.destination = destination;
                    Booking.boardingPoint = boardPoint;


                    System.out.println("Total cost: " + (numTickets * 300));
                    System.out.print("Enter 'yes' to confirm payment: ");
                    String payment = sc.next();

                    if (payment.equalsIgnoreCase("yes")) {
                        System.out.println("Payment successful!");
                    } else {
                        System.out.println("Transaction canceled.");
                        return;
                    }

                    System.out.print("Do you want to print the ticket? (yes/no): ");
                    String printTicket = sc.next();
                    if (printTicket.equalsIgnoreCase("yes")) {

                        try {
                            Booking.printTicket(bookings, numTickets, trainNum);
                            System.out.println("Ticket generated successfully!");
                        } catch (Exception e) {
                            System.out.println("Error generating ticket: " + e.getMessage());
                        }
                    }

                } else {
                    System.out.println("No seats available.");
                }
            }
        } else {
            System.out.println("No train services available between these two stations.");
        }
    }
}
