package commands;

import constants.OutputConstants;
import model.Branch;
import model.Command;
import model.Range;
import service.BookingService;
import service.VehicleRentalService;
import util.DurationParserUtil;

import java.math.BigDecimal;

public class BookVehicleExecutor extends CommandExecutor {
    public BookVehicleExecutor(VehicleRentalService vehicleRentalService) {
        super(vehicleRentalService);
    }

    @Override
    public boolean validate(Command command) {return command.getParameters().size() == 4;}

    @Override
    public void execute(Command command) {
       BookingService bookingService = vehicleRentalService.getBookingService();
       String branchName = command.getParameters().get(0);
       String vehicleType = command.getParameters().get(1);
       Branch branch = vehicleRentalService.getBranch(branchName);
       try {
           Range duration  = DurationParserUtil.parse(command.getParameters().get(2),command.getParameters().get(3));
           BigDecimal price = bookingService.book(branch, vehicleType, duration);
           System.out.println(price.intValue());
       } catch (RuntimeException e){
           printOutput(OutputConstants.NEGATIVE_ONE);
       }
    }
}
