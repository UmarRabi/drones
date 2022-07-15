/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.services;

import com.umar.drones.entities.Status;
import com.umar.drones.repositories.StatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author the Rabbi
 */
@Service
public class StatusService {
    
    @Autowired
    private StatusRepository statusRepository;
    
    public List<Status> statuses(){
        return statusRepository.findAll();
    }
    
    public Status findByCode(String code){
        return statusRepository.findByCode(code);
    }
    
}
