package service;

import exception.BookingFailedException;
import exception.NoAvailableVehicleException;
import model.*;
import strategy.booking.BookingStrategy;
import strategy.pricing.PricingStrategy;
import util.VehiclePriceComparator;

import java.math.BigDecimal;
import java.util.*;

public class BookingService {
   private BookingStrategy bookingStrategy;
   private PricingStrategy pricingStrategy;

    public BookingService(BookingStrategy bookingStrategy, PricingStrategy pricingStrategy){
        this.bookingStrategy = bookingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public BigDecimal book(Branch branch, String vehicleType, Range duration) throws RuntimeException {
       Vehicle vehicle =  bookingStrategy.getVehicleToBook(branch,vehicleType,duration);
       if(vehicle == null)
           throw new NoAvailableVehicleException();

     BigDecimal price =  pricingStrategy.getPrice(branch, vehicle, duration);
     Boolean isBooked = bookingStrategy.makeBooking(branch,vehicle,duration);


     if(isBooked)
         return price;
     else
         throw new BookingFailedException();
    }

    public List<Vehicle> displayAvailableVehicles(Branch branch, Range duration){
        VehicleInventory vehicleInventory = branch.getVehicleInventory();
        ReservationLog reservationLog = branch.getReservationLog();

        List<Vehicle> availableVehicles = new ArrayList<>();

        Map<String, List<Vehicle>> inventoryBook = vehicleInventory.getAllInventory();


        for(List<Vehicle> inventory : inventoryBook.values()){
            for(Vehicle vehicle : inventory){
                if(reservationLog.checkAvailability(vehicle,duration))
                    availableVehicles.add(vehicle);
            }
        }

        Collections.sort(availableVehicles, new VehiclePriceComparator());
        return availableVehicles;
    }

}
