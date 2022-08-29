package strategy.booking;

import model.*;

public interface BookingStrategy {

    Vehicle getVehicleToBook(Branch branch, String vehicleType, Range duration);

    Boolean makeBooking(Branch branch, Vehicle vehicle, Range duration);
}
