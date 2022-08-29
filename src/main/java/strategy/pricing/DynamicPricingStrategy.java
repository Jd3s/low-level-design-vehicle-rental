package strategy.pricing;

import model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DynamicPricingStrategy implements PricingStrategy {

    private static double surgeDemandPercent = 80.00;
    private static double priceIncreasePercent = 10;

    public BigDecimal getPrice(Branch branch, Vehicle vehicle, Range duration) {
        VehicleInventory vehicleInventory = branch.getVehicleInventory();
        ReservationLog reservationLog = branch.getReservationLog();

        String vehicleType = vehicle.getType();

        BigDecimal dynamicPrice = null;

        List<Vehicle> vehicleList = vehicleInventory.getInventory(vehicle.getType());

        int totalVehicles = vehicleList.size(), availableVehicles = 0;

        for (Vehicle curVehicle : vehicleList) {
            if (reservationLog.checkAvailability(curVehicle, duration))
                availableVehicles++;
        }

        double demandPercent = (totalVehicles - availableVehicles) * 100 / totalVehicles;

        if (demandPercent > surgeDemandPercent) {
            dynamicPrice = vehicle.getPrice().multiply(new BigDecimal(priceIncreasePercent / 100));
            dynamicPrice = dynamicPrice.add(vehicle.getPrice()).multiply(new BigDecimal(duration.getNumberOfHours()));
        } else
            dynamicPrice = vehicle.getPrice().multiply(new BigDecimal(duration.getNumberOfHours()));

        return dynamicPrice;
    }
}
