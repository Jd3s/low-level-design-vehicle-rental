package model;

import util.VehiclePriceComparator;

import java.util.*;

public class VehicleInventory {
    private Map<String, List<Vehicle>> inventoryBook;

    public VehicleInventory() {
        this.inventoryBook =  new HashMap<>();
    }


    public boolean addVehicleType(String vehicleType){

        if(inventoryBook.containsKey(vehicleType))
            return false;

        List<Vehicle> vehicleList =  new ArrayList<>();
        inventoryBook.put(vehicleType,vehicleList);
        return true;
    }

    public boolean addVehicle(Vehicle vehicle){
        if(!inventoryBook.containsKey(vehicle.getType()))
           return false;

        List<Vehicle> vehicleList =  inventoryBook.get(vehicle.getType());
      vehicleList.add(vehicle);
      inventoryBook.put(vehicle.getType(), vehicleList);
      return true;
    }

    public List<Vehicle> getInventory(String vehicleType){
        return inventoryBook.get(vehicleType);
    }

    public Map<String, List<Vehicle>> getAllInventory(){
        return inventoryBook;
    }

    @Override
    public String toString() {
        return "VehicleInventory{" +
                "inventoryBook=" + inventoryBook +
                '}';
    }
}
