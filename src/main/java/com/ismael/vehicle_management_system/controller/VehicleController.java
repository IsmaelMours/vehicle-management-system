package com.ismael.vehicle_management_system.controller;

import com.ismael.vehicle_management_system.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    List<Vehicle> vehicleList = new ArrayList<>();

    private Long nextId = 1L;


    @PostMapping("/add-vehicle")
    public String addVehicle(@RequestBody Vehicle vehicle){
//        for (Vehicle v : vehicleList) {
//            if (v.getId().equals(vehicle.getId())) {
//                throw new RuntimeException("Id with same id no: " +
//                        vehicle.getId() + " already exists");
//            }
//        }
        vehicle.setId(nextId++);
        vehicleList.add(vehicle);
        return "Vehicle added successfully";
    }

    @GetMapping("get-all")
    public List<Vehicle> getAllVehicle(){
        return vehicleList;
    }

    @GetMapping("get-vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {

        return vehicleList.stream()
                .filter(n-> n.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @DeleteMapping("remove/{id}")
    public String deleteVehicleById(@PathVariable Long id) {

//        for (Vehicle v : vehicleList) {
//            if (v.getId().equals(id)) {
//                vehicleList.remove(v);
//            }
//        }

     Vehicle vehicle = vehicleList.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst().orElse(null);

     if(vehicle == null)
         return "vehicle not found";

        vehicleList.remove(vehicle);

        return "vehicle with id: "+id+ " is removed successfully";
    }

    @PutMapping("/update/{id}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id){

         Optional<Vehicle> optionalVehicle = vehicleList.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();


         if(optionalVehicle.isPresent()){
             Vehicle existVehicle = optionalVehicle.get();
             existVehicle.setVehicleName(vehicle.getVehicleName());
             existVehicle.setVehicleModel(vehicle.getVehicleModel());
             existVehicle.setVehiclePrice(vehicle.getVehiclePrice());
             return existVehicle;
         }
         else {
             throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not fount with id: "+id);
         }
    }


}
