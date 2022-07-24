package _20220724_UndergroundSystem;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    // ${from}:${to}
    private static final String TRIP_FORMAT = "%s:%s";

    private final Map<Integer, CustomerCheckIn> checkInInfo = new HashMap<>();
    private final Map<String, TripData> tripInfo = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkInInfo.put(id, new CustomerCheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CustomerCheckIn customerCheckIn = checkInInfo.get(id);
        if (customerCheckIn == null) {
            throw new RuntimeException("bad input");
        }

        String trip = tripName(customerCheckIn.station, stationName);

        tripInfo.compute(trip, (key, oldVal) -> {
            if (oldVal == null) {
                oldVal = new TripData();
            }
            oldVal.add(t - customerCheckIn.time);
            return oldVal;
        });
    }

    public double getAverageTime(String startStation, String endStation) {
        String trip = tripName(startStation, endStation);

        TripData data = tripInfo.get(trip);
        if (data == null) {
            throw new RuntimeException("bad input");
        }

        return data.avg();
    }

    private String tripName(String from, String to) {
        return String.format(TRIP_FORMAT, from, to);
    }

    private static class CustomerCheckIn {
        String station;
        int time;

        CustomerCheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class TripData {
        int totalTime;
        int totalCustomer;

        void add(int time) {
            totalTime += time;
            totalCustomer += 1;
        }

        double avg() {
            return (double) totalTime / totalCustomer;
        }
    }

}
