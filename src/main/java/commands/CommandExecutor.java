package commands;

import model.Command;
import service.VehicleRentalService;

public abstract class CommandExecutor {

    protected VehicleRentalService vehicleRentalService;

    public CommandExecutor(VehicleRentalService vehicleRentalService) {
       this.vehicleRentalService = vehicleRentalService;
    }

    public abstract boolean validate(Command command);
    public abstract void execute(Command command);

    public void printOutput(String output) {
        System.out.println(output);
    }

}
