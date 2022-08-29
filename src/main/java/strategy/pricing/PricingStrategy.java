package strategy.pricing;

import model.*;

import java.math.BigDecimal;
import java.time.Duration;

public interface PricingStrategy {

    BigDecimal getPrice(Branch branch, Vehicle vehicle, Range duration);
}
