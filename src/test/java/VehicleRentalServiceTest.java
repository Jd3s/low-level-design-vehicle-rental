
import commands.CommandExecutorFactory;
import commands.CommandProcessor;
import org.junit.Test;
import service.VehicleRentalService;
import strategy.booking.DefaultBookingStrategy;
import strategy.pricing.DynamicPricingStrategy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

// please make sure Line Seperators are set to LF(Mac/Linux)

public class VehicleRentalServiceTest {

 private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


 @Test
 public void testVehicleRentalService() throws IOException {
  System.setOut(new PrintStream(outputStream));

  final String expectedOutput =
                "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "FALSE\n"
                  + "-1\n"
                  + "1000\n"
                  + "250\n"
                  + "900\n"
                  + "V2\n";
  Application.main(new String[]{"src/main/resources/input.txt"});
  assertEquals(expectedOutput, outputStream.toString());
 }


 @Test
 public void testVehicleRentalServiceWithDynamicPricing() throws IOException {
  System.setOut(new PrintStream(outputStream));

  final String expectedOutput =
                    "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  +"TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "FALSE\n"
                  + "-1\n"
                  + "1000\n"
                  + "2000\n"
                  + "2000\n"
                  + "2000\n"
                  + "2000\n"
                  + "2640\n"
                  + "250\n"
                  + "900";

  final VehicleRentalService vehicleRentalService = new VehicleRentalService(new DefaultBookingStrategy(), new DynamicPricingStrategy());
  final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(vehicleRentalService);
  CommandProcessor commandProcessor = new CommandProcessor(commandExecutorFactory);
  commandProcessor.start("src/main/resources/input_dynamicPricing.txt");
  assertEquals(expectedOutput, outputStream.toString());
 }


 @Test
 public void invalidBranchTest() throws IOException {
  System.setOut(new PrintStream(outputStream));

  final String expectedOutput =
                   "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "FALSE\n"
                  + "FALSE\n"
                  + "-1\n"
                  + "1000\n"
                  + "250\n"
                  + "900\n"
                  + "V2\n";
  final VehicleRentalService vehicleRentalService = new VehicleRentalService(new DefaultBookingStrategy(), new DynamicPricingStrategy());
  Application.main(new String[]{"src/main/resources/input_invalidBranch.txt"});
  assertEquals(expectedOutput, outputStream.toString());
 }


 @Test
 public void invalidVehicleTest() throws IOException {
  System.setOut(new PrintStream(outputStream));

  final String expectedOutput =
          "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "TRUE\n"
                  + "FALSE\n"
                  + "FALSE\n"
                  + "-1\n"
                  + "1000\n"
                  + "250\n"
                  + "900\n"
                  + "V2\n";
  final VehicleRentalService vehicleRentalService = new VehicleRentalService(new DefaultBookingStrategy(), new DynamicPricingStrategy());
  Application.main(new String[]{"src/main/resources/input_invalidVehicle.txt"});
  assertEquals(expectedOutput, outputStream.toString());
 }

}


