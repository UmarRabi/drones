/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.services;

import com.umar.drones.entities.Deliveries;
import com.umar.drones.repositories.DeliveriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author the Rabbi
 */
@Service
public class DeliveriesService {
    @Autowired
    private DeliveriesRepository deliveriesRepository;
    
    public Deliveries create(Deliveries delivery){
        return deliveriesRepository.save(delivery);
    }
    
    public Deliveries findById(Long id){
        return deliveriesRepository.getById(id);
    }
}
