package model;

import com.sun.source.tree.Tree;
import lombok.Getter;

import java.util.*;

@Getter
public class ReservationLog {
    private Map<String, TreeSet<Integer>[]> reservationLogs;

    public boolean makeReservation(Vehicle vehicle, Range range) {
        Integer startTime = range.getStartTime();
        Integer endTime = range.getEndTime();
        if (startTime >= endTime) {
            return false;
        }
        TreeSet<Integer>[] rangeList;
        if (!reservationLogs.containsKey(vehicle.getId())) {
            rangeList = new TreeSet[2];
            rangeList[0] = new TreeSet<>();
            rangeList[1] = new TreeSet<>();
        } else {
            rangeList = reservationLogs.get(vehicle.getId());
        }

        rangeList[0].add(startTime);
        rangeList[1].add(endTime);

        reservationLogs.put(vehicle.getId(), rangeList);

        return true;
    }

    public boolean checkAvailability(Vehicle vehicle, Range duration) {
        Integer startTime = duration.getStartTime();
        Integer endTime = duration.getEndTime();

        if (startTime >= endTime)
            return false;

        if (reservationLogs.containsKey(vehicle.getId())) {
            TreeSet<Integer>[] rangeList = reservationLogs.get(vehicle.getId());
            TreeSet<Integer> startTimes = rangeList[0];
            TreeSet<Integer> endTimes = rangeList[1];

            if (startTimes.contains(duration.getStartTime()) || endTimes.contains(duration.getEndTime()))
                return  false;

            Long startCount = startTimes.parallelStream().filter(element -> element < duration.getStartTime()).count();
            Long endCount = endTimes.parallelStream().filter(element -> element < duration.getEndTime()).count();

            if (startCount == endCount && (startCount%2 == 0 && endCount%2 == 0))
                return true;

            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ReservationLog{" +
                "reservationLogs=" + reservationLogs +
                '}';
    }

    public ReservationLog() {
        this.reservationLogs = new HashMap<>();
    }
}
