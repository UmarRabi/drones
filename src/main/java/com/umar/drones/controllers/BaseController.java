/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.controllers;

import com.umar.drones.entities.Models;
import com.umar.drones.entities.States;
import com.umar.drones.entities.Status;
import com.umar.drones.services.StatesService;
import com.umar.drones.services.StatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * This Controller allows you to retrieve Base Data like states, status, models
 */
@RestController
public class BaseController {
    @Autowired
    private StatusService statusService;
    
    @Autowired
    private StatesService statesService;

    @GetMapping("/states")
    public List<States> states(){
        return statesService.states();
    }
    
    @GetMapping("/status")
    public List<Status> status(){
        return statusService.statuses();
    }
    
//    @GetMapping("/status")
//    public List<Models> models(){
//        
//    }
}
