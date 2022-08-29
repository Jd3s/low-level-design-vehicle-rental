package commands;

import model.Command;
import org.junit.Before;
import org.junit.Test;
import service.VehicleRentalService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddBranchTest {

    private VehicleRentalService vehicleRentalService;
    private AddBranchExecutor addBranchExecutor;

    @Before
    public void init() throws Exception {
        vehicleRentalService = new VehicleRentalService();
        addBranchExecutor = new AddBranchExecutor(vehicleRentalService);
    }

    @Test
    public void happyFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B1");
        paramsList.add("CAR,BIKE,VAN");
        assertTrue(addBranchExecutor.validate(new Command("ADD_BRANCH", paramsList)));
    }

    @Test
    public void invalidArguementFlowTest() {
        List<String> paramsList = new ArrayList<>();
        paramsList.add("B2");
        assertFalse(addBranchExecutor.validate(new Command("ADD_BRANCH", paramsList)));
    }

}
