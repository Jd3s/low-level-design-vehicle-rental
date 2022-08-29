package commands;

import constants.CommandConstants;
import exception.InvalidInputException;
import model.Command;
import service.VehicleRentalService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    private Map<String, CommandExecutor> commandExecutorMap;


    public CommandExecutorFactory(final VehicleRentalService vehicleRentalService) {
        commandExecutorMap = new HashMap<>();
        populateCommands(vehicleRentalService);
    }

    private void populateCommands(VehicleRentalService vehicleRentalService) {
        commandExecutorMap.put(CommandConstants.addBranch, new AddBranchExecutor(vehicleRentalService));
        commandExecutorMap.put(CommandConstants.addVehicle, new AddVehicleExecutor(vehicleRentalService));
        commandExecutorMap.put(CommandConstants.bookVehicle, new BookVehicleExecutor(vehicleRentalService));
        commandExecutorMap.put(CommandConstants.displayVehicle, new DisplayVehiclesExecutor(vehicleRentalService));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        final CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidInputException("please enter a valid command !");
        }
        return commandExecutor;
    }

}
