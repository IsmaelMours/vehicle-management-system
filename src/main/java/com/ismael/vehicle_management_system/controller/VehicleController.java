package com.ismael.vehicle_management_system.controller;

import com.ismael.vehicle_management_system.model.Vehicle;
import com.ismael.vehicle_management_system.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add-vehicle")
    public String addVehicle(@RequestBody Vehicle vehicle){

       String newVehicle = vehicleService.addVehicle(vehicle);

        return newVehicle;
    }

    @GetMapping("get-all")
    public List<Vehicle> getAllVehicle(){
        return vehicleService.getAllVehicle();
    }

    @GetMapping("get-vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {

        Vehicle vehicle = vehicleService.getVehicleById(id);

        return vehicle;
    }


    @DeleteMapping("remove/{id}")
    public String deleteVehicleById(@PathVariable Long id) {

        String removeVehicle = vehicleService.deleteVehicleById(id);

        return  removeVehicle;
    }

    @PutMapping("/update/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id){

        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle, id);
        return updatedVehicle;
    }


}
