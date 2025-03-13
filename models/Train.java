package models;

public class Train {
    public String trainNumber;

    public String source;

    public String destination;

    public int totalSeats;
    
    public int availableSeats;

    public Train(String trainNumber, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.source = source;

        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
}
