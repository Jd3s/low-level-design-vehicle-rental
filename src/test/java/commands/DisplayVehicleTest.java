package commands;

import model.Command;
import org.junit.Before;
import org.junit.Test;
import service.VehicleRentalService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisplayVehicleTest {
    private VehicleRentalService vehicleRentalService;
    private DisplayVehiclesExecutor displayVehiclesExecutor;

    @Before
    public void init() throws Exception {
        vehicleRentalService = new VehicleRentalService();
        displayVehiclesExecutor = new DisplayVehiclesExecutor(vehicleRentalService);
    }

    @Test
    public void happyFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B1");
        paramsList.add("1");
        paramsList.add("5");
        assertTrue(displayVehiclesExecutor.validate(new Command("DISPLAY_VEHICLES", paramsList)));
    }

    @Test
    public void invalidArguementFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B1");
        paramsList.add("1");
        assertFalse(displayVehiclesExecutor.validate(new Command("DISPLAY_VEHICLES", paramsList)));
    }

}
