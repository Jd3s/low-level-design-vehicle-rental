package commands;

import constants.OutputConstants;
import exception.InvalidInputException;
import model.Command;
import model.Vehicle;
import service.VehicleRentalService;

import java.math.BigDecimal;

public class AddVehicleExecutor extends CommandExecutor{

    public AddVehicleExecutor(VehicleRentalService vehicleRentalService) {
        super(vehicleRentalService);
    }

    @Override
    public boolean validate(Command command) {return command.getParameters().size() == 4;}

    @Override
    public void execute(Command command) {
        String branchName = command.getParameters().get(0);

        Vehicle vehicle = parseInput(command);

        boolean isBooked = false;
       try {
          isBooked = vehicleRentalService.addVehicle(branchName, vehicle);
       } catch (RuntimeException e){
           printOutput(OutputConstants.FALSE);
           return;
       }

       if(isBooked)
           printOutput(OutputConstants.TRUE);
       else
           printOutput(OutputConstants.FALSE);

    }


    public Vehicle parseInput(Command command) {

        try{
            String vehicleType = command.getParameters().get(1);
            String vehicleId = command.getParameters().get(2);
            BigDecimal price = new BigDecimal(command.getParameters().get(3));
            Vehicle vehicle = new Vehicle(vehicleType, vehicleId, price);
            return vehicle;
        } catch (Exception e) {
            throw new InvalidInputException("");
        }

    }
}
