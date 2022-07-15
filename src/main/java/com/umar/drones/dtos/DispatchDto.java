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
public class DispatchDto {
    String droneSerialNumber, medCode;
    
    public String getDroneSerialNumber(){
        return this.droneSerialNumber;
    }
    
    public String getMedCode(){
        return this.medCode;
    }
}
