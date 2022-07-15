/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.services;

import com.umar.drones.entities.Models;
import com.umar.drones.repositories.ModelsRepository;
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
public class ModelsService {
    
    
   @Autowired
   private ModelsRepository modelsRepository;
   
   public Models findByCode(String code){
       return modelsRepository.findByCode(code);
   }
   
   public Page<Models> models(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return modelsRepository.findAll(pageable);
   }
}
