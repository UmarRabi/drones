/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.services;

import com.umar.drones.entities.States;
import com.umar.drones.repositories.StatesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author the Rabbi
 */
@Service
public class StatesService {
    @Autowired
    private StatesRepository statesRepository;
    
    public List<States> states(){
        return statesRepository.findAll();
    }
    
    public States findByCode(String code){
       return statesRepository.findByCode(code);
    }
   
   public Page<States> states(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return statesRepository.findAll(pageable);
   }
    
}
