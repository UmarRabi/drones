/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.entities;

import com.umar.drones.dtos.DroneDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author the Rabbi
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="drones")
@Proxy(lazy = false)
public class Drones extends BaseEntity{
    
    @Column(nullable=false, unique=true, length=100)
    private String serialNumber;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelCode", referencedColumnName="code")
    private Models model;
    
    @Column(nullable=false)
    private String weight;
    
    @Column(nullable=false)
    private Double batteryCapacity=0.0;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="stateCode", referencedColumnName="code")
    private States state;
    
    public Drones(DroneDto droneDto, Models model, States state){
        this.serialNumber=droneDto.getSerialNumber();
        this.weight=droneDto.getWeight();
        this.model=model;
        this.state=state;
    }
}
