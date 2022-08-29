package model;

import lombok.Getter;
import lombok.Setter;
import strategy.booking.BookingStrategy;
import strategy.pricing.PricingStrategy;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Branch {
    private String name;
    private ReservationLog reservationLog;
    private VehicleInventory vehicleInventory;

    public Branch(String name, ReservationLog reservationLog, VehicleInventory vehicleInventory) {
        this.name = name;
        this.reservationLog = reservationLog;
        this.vehicleInventory = vehicleInventory;
    }

    public Branch(String name) {
        this.name = name;
        this.reservationLog = new ReservationLog();
        this.vehicleInventory = new VehicleInventory();
    }
}
