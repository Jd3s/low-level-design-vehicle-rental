package commands;

import model.Command;
import org.junit.Before;
import org.junit.Test;
import service.VehicleRentalService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookVehicleTest {
    private VehicleRentalService vehicleRentalService;
    private BookVehicleExecutor bookVehicleExecutor;

    @Before
    public void init() throws Exception {
        vehicleRentalService = new VehicleRentalService();
        bookVehicleExecutor = new BookVehicleExecutor(vehicleRentalService);
    }

    @Test
    public void happyFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B1");
        paramsList.add("CAR");
        paramsList.add("1");
        paramsList.add("5");
        assertTrue(bookVehicleExecutor.validate(new Command("BOOK_VEHICLES", paramsList)));
    }

    @Test
    public void invalidArguementFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B1");
        paramsList.add("1");
        assertFalse(bookVehicleExecutor.validate(new Command("DISPLAY_VEHICLES", paramsList)));
    }
}
