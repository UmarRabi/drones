/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.repositories;

import com.umar.drones.entities.Deliveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author the Rabbi
 */
@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, Long>  {
    
}
