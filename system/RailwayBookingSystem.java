package system;

import models.Train;
import java.util.*;

public class RailwayBookingSystem {
    public Map<String, Train> trains;

    public Map<String, String> route;

    public Map<String, String> rsd;

    public Map<String, Integer> tseat;

    public RailwayBookingSystem() {
        this.trains = new HashMap<>();

        this.route = new HashMap<>();
        this.rsd = new HashMap<>();

        this.tseat = new HashMap<>();
    }

    public void addTrain(Train train) {
        trains.put(train.trainNumber, train);

        route.put(train.source, train.destination);
        tseat.put(train.trainNumber, train.totalSeats);
        mao<int,int>mp;
        rsd.put(train.source.substring(train.source.length() - 1) + "-" +
                train.destination.substring(train.destination.length() - 1) + train.trainNumber, train.trainNumber);
    }
}
