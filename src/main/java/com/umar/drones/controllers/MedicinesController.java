/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.controllers;

import com.umar.drones.entities.Medications;
import com.umar.drones.services.MedicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author the Rabbi
 */
@RestController
public class MedicinesController {
    @Autowired
    private MedicationsService medicationsService;
    
    @GetMapping("/medications/{code}")
    public Medications medication(@PathVariable String code){
        return medicationsService.medication(code);
    }
    
    @GetMapping("/medications")
    public ResponseEntity<Object> medications(
            @RequestParam("page") int page, 
            @RequestParam("size") int size 
    ){
        try{
            Page<Medications> m = medicationsService.medications(page, size);
            return ResponseEntity.status(200).body(m);
        }catch(Exception e){
             return ResponseEntity.status(500).body(e.getMessage());
        }
        
    }
    
    @PostMapping("/medications")
    public ResponseEntity<Object> create(@RequestBody Medications medications){
        try{
            
            Medications m= medicationsService.create(medications);
            return ResponseEntity.status(200).body(m);
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
        
    }
}
