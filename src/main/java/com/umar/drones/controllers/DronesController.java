/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.umar.drones.controllers;

import com.umar.drones.dtos.DroneDto;
import com.umar.drones.entities.Drones;
import com.umar.drones.entities.Models;
import com.umar.drones.entities.States;
import com.umar.drones.services.DronesService;
import com.umar.drones.services.ModelsService;
import com.umar.drones.services.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author the Rabbi
 */
@RestController
@RequestMapping("/drones")
public class DronesController {
    
    @Autowired
    private DronesService dronesService;
    
    @Autowired
    private ModelsService modelsService;
    
    @Autowired
    private StatesService statesService;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody DroneDto drone){
        try{
            Drones d=null;
            Models model=modelsService.findByCode(drone.getModel());
            if(model == null){
                return ResponseEntity.status(400).body("inveld model code entered");
            }
            States state=statesService.findByCode("IDE");
            d=new Drones(drone, model, state);
            d = dronesService.create(d);
            return ResponseEntity.status(200).body(d);
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> all(
        @RequestParam("page") int page, 
        @RequestParam("size") int size 
    ){
        try{
            Page<Drones> d = dronesService.drones(page, size);
            return ResponseEntity.status(200).body(d);
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
       
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody DroneDto droneDto, @PathVariable("id") Long id){
        try{
            Drones d=dronesService.drone(id);
            if(droneDto.getBatteryCapacity()>100 || droneDto.getBatteryCapacity()==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Battery percentage can only 100 or less");
            }
            d.setBatteryCapacity(droneDto.getBatteryCapacity());
            d=dronesService.create(d);
            return ResponseEntity.status(200).body(d);
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    
    @GetMapping("/available")
    public ResponseEntity<Object> availability(
            @RequestParam("page") int page, 
            @RequestParam("size") int size 
    ){
        try{
             Page<Drones> d = dronesService.available(page, size);
             return ResponseEntity.status(200).body(d);
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    
    
}
