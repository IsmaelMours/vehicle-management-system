package com.ismael.vehicle_management_system.model;

public class Vehicle {
    private Long id;
    private String vehicleName;
    private String vehicleModel;
    private Double vehiclePrice;


    public Vehicle() {
    }

    public Vehicle(Long id, String vehicleName, String vehicleModel, Double vehiclePrice) {
        this.id = id;
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.vehiclePrice = vehiclePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehiclePrice=" + vehiclePrice +
                '}';
    }
}
