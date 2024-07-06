package com.ismael.vehicle_management_system.service;

import com.ismael.vehicle_management_system.model.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    List<Vehicle> vehicleList = new ArrayList<>();

    private Long nextId = 1L;


    public String addVehicle(Vehicle vehicle){

        vehicle.setId(nextId++);
        vehicleList.add(vehicle);
        return "Vehicle added successfully";
    }


    public List<Vehicle> getAllVehicle(){
        return vehicleList;
    }


    public Vehicle getVehicleById( Long id) {

        return vehicleList.stream()
                .filter(n-> n.getId().equals(id))
                .findFirst()
                .orElse(null);
    }



    public String deleteVehicleById(Long id) {

        Vehicle vehicle = vehicleList.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst().orElse(null);

        if(vehicle == null)
            return "vehicle not found";

        vehicleList.remove(vehicle);

        return "vehicle with id: "+id+ " is removed successfully";
    }


    public Vehicle updateVehicle(Vehicle vehicle, Long id){

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
