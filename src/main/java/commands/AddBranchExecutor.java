package commands;

import model.Branch;
import model.Command;
import model.VehicleInventory;
import service.VehicleRentalService;

public class AddBranchExecutor extends CommandExecutor {
    public AddBranchExecutor(VehicleRentalService vehicleRentalService) {
        super(vehicleRentalService);
    }

    @Override
    public boolean validate(Command command) {return command.getParameters().size() == 2;}

    @Override
    public void execute(Command command) {
        Branch branch = new Branch(command.getParameters().get(0));
        String[] vehicleTypes = command.getParameters().get(1).split(",");
        VehicleInventory vehicleInventory =  branch.getVehicleInventory();
        for(String vehicleType : vehicleTypes)
           vehicleInventory.addVehicleType(vehicleType);
        printOutput(vehicleRentalService.addBranch(branch));
    }


}
