/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.services;

import com.umar.drones.entities.Drones;
import com.umar.drones.entities.States;
import com.umar.drones.repositories.DronesRepository;
import com.umar.drones.repositories.StatesRepository;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author the Rabbi
 */
@Service
public class DronesService {
    
    @Autowired
    private DronesRepository dronesRepository;
    
    @Autowired
    private StatesRepository statesRepository;
    
    public Page<Drones> drones(int page, int size){
         Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return dronesRepository.findAll(pageable);
    }
    
    public Drones drone(Long id){
        return dronesRepository.getById(id);
    }
    
    public Drones create(Drones drone){
        Drones d=dronesRepository.save(drone);
        return d;
    }
    
    @Scheduled(fixedDelay = 60000)
    public void idle(){
        LocalDateTime localDateTime=LocalDateTime.now().minusMinutes(5);
        Date date=new Date();
        date.setMinutes(localDateTime.getMinute());
        System.out.println(date);
        dronesRepository.idle(date, "IDE");
    }
    
     public Page<Drones> available(int page, int size){
         Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
         return dronesRepository.findByAvailability(pageable);
    }
    
    public Drones drone(String serialNumber){
        return dronesRepository.findBySerialNumber(serialNumber);
    }
    
    @Async
    public void batteryDrop(Drones drone){
        drone.setBatteryCapacity(drone.getBatteryCapacity()-10);
        dronesRepository.save(drone);
    }
    
    @Async
    public void changeState(Drones drone, States state){
        drone.setState(state);
        dronesRepository.save(drone);
    }
     
}
