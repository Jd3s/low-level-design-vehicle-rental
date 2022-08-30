import commands.CommandExecutorFactory;
import commands.CommandProcessor;
import service.VehicleRentalService;

import java.io.IOException;


public class Application {

    public static void main(String[] args) throws IOException {

        String fileName;

        // default input
        if(args.length != 1)
            fileName = "src/main/resources/input.txt";
        else
            fileName = args[0];

        final VehicleRentalService vehicleRentalService = new VehicleRentalService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(vehicleRentalService);
        CommandProcessor commandProcessor = new CommandProcessor(commandExecutorFactory);
        commandProcessor.start(fileName);
    }
}
