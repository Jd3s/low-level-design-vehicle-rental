package commands;

import constants.OutputConstants;
import model.Branch;
import model.Command;
import model.Range;
import model.Vehicle;
import service.BookingService;
import service.VehicleRentalService;
import util.DurationParserUtil;

import java.util.List;

public class DisplayVehiclesExecutor extends CommandExecutor {
    public DisplayVehiclesExecutor(VehicleRentalService vehicleRentalService) {
        super(vehicleRentalService);
    }

    @Override
    public boolean validate(Command command) {return command.getParameters().size() == 3;}

    @Override
    public void execute(Command command) {
        BookingService bookingService = vehicleRentalService.getBookingService();
        String branchName = command.getParameters().get(0);
        Branch branch = vehicleRentalService.getBranch(branchName);
        try {
            Range duration  = DurationParserUtil.parse(command.getParameters().get(1),command.getParameters().get(2));
            List<Vehicle> availableVehicles = bookingService.displayAvailableVehicles(branch, duration);
            print(availableVehicles);
        } catch (RuntimeException e){
            printOutput(OutputConstants.NEGATIVE_ONE);
        }
    }

    public void print(List<Vehicle> availableVehicles){
        StringBuilder outputSb = new StringBuilder();
        for(Vehicle vehicle: availableVehicles) {
            outputSb.append(vehicle.getId());
            outputSb.append(",");
        }

        if(outputSb.length() > 1)
         outputSb.setLength(outputSb.length()-1);

        String output = outputSb.toString();
        printOutput(output);
    }
}
