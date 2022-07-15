/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.dtos;

/**
 *
 * @author the Rabbi
 */
public class DroneDto {
    private String model, weight, state, serialNumber;
    private Double batteryCapacity;
    
    public String getModel(){
        return this.model;
    }
    
    public String getWeight(){
        return this.weight;
    }
    
    public String getState(){
        return this.state;
    }
    
    public String getSerialNumber(){
        return this.serialNumber;
    }
    
    public Double getBatteryCapacity(){
        return this.batteryCapacity;
    }
    
    
}
