package util;

import model.Vehicle;

import java.util.Comparator;

public class VehiclePriceComparator implements Comparator<Vehicle>{
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getPrice().compareTo(v2.getPrice());
    }
}
