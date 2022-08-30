package service;

import constants.OutputConstants;
import exception.NoValidBranchException;
import lombok.Getter;
import model.Branch;
import model.Vehicle;
import strategy.booking.BookingStrategy;
import strategy.booking.DefaultBookingStrategy;
import strategy.pricing.DefaultPricingStrategy;
import strategy.pricing.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class VehicleRentalService {

    private Map<String,Branch> branches;

    @Getter
    private BookingService bookingService;

    public VehicleRentalService(){
        branches = new HashMap<>();
        bookingService = new BookingService(new DefaultBookingStrategy(), new DefaultPricingStrategy());
    }

    public VehicleRentalService(BookingStrategy bookingStrategy, PricingStrategy pricingStrategy){
        branches = new HashMap<>();
        bookingService = new BookingService(bookingStrategy, pricingStrategy);
    }



    public String addBranch(Branch newBranch){
       if(branches.containsKey(newBranch.getName()))
           return OutputConstants.FALSE;

        branches.put(newBranch.getName(), newBranch);
        return OutputConstants.TRUE;
    }

    public boolean addVehicle(String branchName, Vehicle vehicle){
        Branch branch = branches.get(branchName);

        if(branch == null)
            throw new NoValidBranchException(OutputConstants.NO_VALID_BRANCH);

      return  branch.getVehicleInventory().addVehicle(vehicle);
    }

    public Branch getBranch(String branchName){
        Branch branch = branches.get(branchName);
        return branch;
    }


}
