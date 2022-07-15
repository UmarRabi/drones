/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.controllers;

import com.umar.drones.dtos.DispatchDto;
import com.umar.drones.dtos.DispatchStateDto;
import com.umar.drones.entities.Deliveries;
import com.umar.drones.entities.Drones;
import com.umar.drones.entities.Medications;
import com.umar.drones.entities.States;
import com.umar.drones.entities.Status;
import com.umar.drones.services.DeliveriesService;
import com.umar.drones.services.DronesService;
import com.umar.drones.services.MedicationsService;
import com.umar.drones.services.StatesService;
import com.umar.drones.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author the Rabbi
 */
@RestController
@RequestMapping("/dispatch")
public class DispatchController {
    
    @Autowired
    private DronesService dronesService;
    
    @Autowired
    private MedicationsService medicationsService;
    
    @Autowired
    private StatusService statusService;
    
    @Autowired
    private DeliveriesService deliveriesService;
    
    @Autowired
    private StatesService statesService;
    @PostMapping("/")
    public ResponseEntity<Object> load(@RequestBody DispatchDto dispatchDto){
        try{
            if(dispatchDto.getDroneSerialNumber()==null || dispatchDto.getMedCode()==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("One of more field is null");
            }

            Drones drone=dronesService.drone(dispatchDto.getDroneSerialNumber());
            if(drone==null){
                return ResponseEntity.badRequest().body("No drone with the provided serial number");
            }
            System.out.println(drone);
            if(drone.getState().getCode()!="IDE" && drone.getState().getCode()!="RTG" && drone.getBatteryCapacity() < 10){
                return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body("Drone is not Availble");
            }
            States state=statesService.findByCode("LDG");
            dronesService.changeState(drone, state);
            Medications medication=medicationsService.medication(dispatchDto.getMedCode());
            if(medication==null){
                return ResponseEntity.badRequest().body("No medication found with the code provided");
            }
            Deliveries delivery=new Deliveries();
            delivery.setDrone(drone);
            delivery.setMedication(medication);
            state=statesService.findByCode("LDD");
            dronesService.changeState(drone, state);
            Status status=statusService.findByCode("IPS");
            delivery.setStatus(status);
            delivery=deliveriesService.create(delivery);
            state=statesService.findByCode("DLG");
            dronesService.changeState(drone, state);
            return ResponseEntity.status(200).body(delivery);
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> complete(@PathVariable Long id){
        try{
            Deliveries delivery=deliveriesService.findById(id);
            if(delivery==null){
                return ResponseEntity.status(400).body("No delivery details found with this delivery id");
            }
            Status status=statusService.findByCode("CPD");
            delivery.setStatus(status);
            delivery=deliveriesService.create(delivery);
            return ResponseEntity.status(200).body(delivery);
        }catch(Exception e){
             return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStatus(
            @RequestBody DispatchStateDto dispatchStateDto,
            @PathVariable("id") Long id){
        try{
            States state=statesService.findByCode(dispatchStateDto.getState());
            if(state==null){
                return ResponseEntity.badRequest().body("Not a valid state");
            }
            Deliveries delivery=deliveriesService.findById(id);
            if(delivery==null){
                return ResponseEntity.badRequest().body("No Delivery found");
            }
            if(dispatchStateDto.getState()=="RTG"){
                Status status=statusService.findByCode("CPD");
                delivery.setStatus(status);
            }
            dronesService.changeState(delivery.getDrone(), state);
            return ResponseEntity.ok().body("Drone State updated successfully");
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }  
    }
    
}


