package commands;

import model.Command;
import org.junit.Before;
import org.junit.Test;
import service.VehicleRentalService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddVehicleTest {
    private VehicleRentalService vehicleRentalService;
    private AddVehicleExecutor addVehicleExecutor;

    @Before
    public void init() throws Exception {
        vehicleRentalService = new VehicleRentalService();
        addVehicleExecutor = new AddVehicleExecutor(vehicleRentalService);
    }

    @Test
    public void happyFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B1");
        paramsList.add("CAR");
        paramsList.add("V1");
        paramsList.add("500");
        assertTrue(addVehicleExecutor.validate(new Command("ADD_VEHICLE", paramsList)));
    }

    @Test
    public void invalidArguementFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B2");
        paramsList.add("CAR");
        paramsList.add("500");
        assertFalse(addVehicleExecutor.validate(new Command("ADD_VEHICLE", paramsList)));
    }



}
