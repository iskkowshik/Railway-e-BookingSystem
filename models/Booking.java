package models;

import java.io.File;
import java.io.PrintWriter;

public class Booking {
    public static String trainNumber;

    public static int numTickets;
    public String passengerName;

    public int age;

    public String preference;
    public static String mobileNumber;
    public static String destination;
    
    public static String boardingPoint;

    public Booking(String passengerName, int age, String preference) {
        this.passengerName = passengerName;

        this.age = age;

        this.preference = preference;
    }

    public static void printTicket(Booking[] bookings, int n, String tn) throws Exception {
        File file = new File("ticket.pdf");
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);

        pw.println("Indian Railways welcomes you");
        pw.println("Train No: " + tn);

        pw.println("Boarding Point: " + boardingPoint);
        pw.println("Destination: " + destination);

        pw.println("No of Tickets: " + numTickets);
        pw.println("Mobile Number: " + mobileNumber);

        for (int i = 0, j = 1; i < n; i++, j++) {
            pw.println("Details of Passenger " + j);
            pw.println("Passenger " + j + " Name: " + bookings[i].passengerName);
            pw.println("Passenger " + j + " Age: " + bookings[i].age);

            pw.println("Passenger " + j + " Berth Preference: " + bookings[i].preference);
            pw.println("\n");
        }
        pw.close();
    }
}
