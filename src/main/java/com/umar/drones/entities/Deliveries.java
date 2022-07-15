/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.entities;

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
@Table(name="deliveries")
@Proxy(lazy = false)
public class Deliveries extends BaseEntity{
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="droneSerialNumber", referencedColumnName="serialNumber")
    private Drones drone;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="medCode", referencedColumnName="code")
    private Medications medication;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="statusCode", referencedColumnName="code")
    private Status status;
    
    
}
