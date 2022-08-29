package strategy.pricing;

import model.*;

import java.math.BigDecimal;

public class DefaultPricingStrategy implements PricingStrategy{

    @Override
    public BigDecimal getPrice(Branch branch, Vehicle vehicle, Range duration) {
        return vehicle.getPrice().multiply(new BigDecimal(duration.getNumberOfHours()));
    }
}
