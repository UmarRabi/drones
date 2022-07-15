/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.services;

import com.umar.drones.entities.Medications;
import com.umar.drones.repositories.MedicationsRepository;
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
public class MedicationsService {
    
    @Autowired
    private MedicationsRepository medicationsRepository;
    
    public Medications medication(String code){
        return medicationsRepository.findByCode(code);
    }
    
    public Page<Medications> medications(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return medicationsRepository.findAll(pageable);
    }
    
    public Medications create(Medications medications){
        return medicationsRepository.save(medications);
    }
}
