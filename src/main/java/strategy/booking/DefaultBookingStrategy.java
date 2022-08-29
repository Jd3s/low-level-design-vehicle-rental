package strategy.booking;

import model.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class DefaultBookingStrategy implements BookingStrategy{
    @Override
    public Vehicle getVehicleToBook(Branch branch, String vehicleType, Range duration) {
        List<Vehicle> vehicleList = branch.getVehicleInventory().getInventory(vehicleType);
        ReservationLog reservationLog = branch.getReservationLog();

        Vehicle vehicleToBook = null;
        BigDecimal minPrice = BigDecimal.valueOf(Integer.MAX_VALUE);
        for(Vehicle vehicle : vehicleList){
            if(reservationLog.checkAvailability(vehicle, duration) && (vehicle.getPrice().compareTo(minPrice) < 0)) {
                vehicleToBook = vehicle;
                minPrice = vehicle.getPrice();
            }
        }

        return vehicleToBook;
    }

    @Override
    public Boolean makeBooking(Branch branch, Vehicle vehicle, Range duration) {
        ReservationLog reservationLog = branch.getReservationLog();
        return reservationLog.makeReservation(vehicle, duration);
    }
}
