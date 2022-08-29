package model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Vehicle {
    private String type;
    private String id;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                '}';
    }

    public Vehicle(String type, String id, BigDecimal price) {
        this.type = type;
        this.id = id;
        this.price = price;
    }
}
