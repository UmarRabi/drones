/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.repositories;

import com.umar.drones.entities.Drones;
import com.umar.drones.entities.States;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author the Rabbi
 */
@Repository
public interface DronesRepository extends JpaRepository<Drones, Long> {
    @Override
    Page<Drones> findAll(Pageable pageable);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE drones d set d.state_code=?2 WHERE d.updated_at < ?1", nativeQuery=true)
    public void idle(Date fiveMinutes, String statecode);
    
    @Query(value="SELECT d FROM drones d WHERE d.state_code='IDE' OR d.state_code='RTG'", nativeQuery=true)
    Page<Drones> findByAvailability(Pageable pageable);
    
    Drones findBySerialNumber(String serialNumber);
    
}
