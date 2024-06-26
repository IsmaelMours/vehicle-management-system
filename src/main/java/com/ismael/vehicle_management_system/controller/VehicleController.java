package com.ismael.vehicle_management_system.controller;

import com.ismael.vehicle_management_system.model.Vehicle;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    List<Vehicle> vehicleList = new ArrayList<>();


    @PostMapping("/add-vehicle")
    public String addVehicle(@RequestBody Vehicle vehicle){
        for (Vehicle v : vehicleList) {
            if (v.getId().equals(vehicle.getId())) {
                throw new RuntimeException("Id with same id no: " +
                        vehicle.getId() + " already exists");
            }
        }
        vehicleList.add(vehicle);
        return "Vehicle added successfully";
    }

    @GetMapping("get-all")
    public List<Vehicle> getAllVehicle(){
        return vehicleList;
    }

    @GetMapping("get-vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        for (Vehicle v : vehicleList) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        throw new RuntimeException("Vehicle with id: " +
                id + " does not exist within the list");
    }


    @GetMapping("remove/{id}")
    public void deleteVehicleById(@PathVariable Long id) {
        for (Vehicle v : vehicleList) {
            if (v.getId().equals(id)) {
                vehicleList.remove(v);
            }
        }
        throw new RuntimeException("Vehicle with id: " +
                id + " does not exist within the list");
    }


}
